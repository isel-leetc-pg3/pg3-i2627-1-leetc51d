package slides.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericTypeOrWildcardDemo<T4 extends Number> {
    public static double sumOfList1(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }
    public static <T extends Number>  double sumOfList2(List<T> list) {
        double s = 0.0;
        for (T n : list)
            s += n.doubleValue();
        return s;
    }

    public static void printList1(List<?> list) {
        for (Object elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }
    public static <T> void printList2(List<T> list) {
        for (T elem: list)
            System.out.print(elem + " ");
        System.out.println();
    }

    public static <T> void copy1(List<T> dest, List<? extends T> src) {
        for (T e: src)
            dest.add(e);
    }
    public static <T, S extends T> void copy2(List<T> dest, List<S> src) {
        for (T e: src)
            dest.add(e);
    }

    static List<List<? extends Number>> history1 = new ArrayList<>();
    public static double sumList1(List<? extends Number> list) {
        history1.addLast(list);
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    // O tipo genérico não pode ser usado num membro estático
    ArrayList<List<T4>> history2 = new ArrayList<>();
    public double sumList2(List<T4> list) {
        history2.addLast(list);
        double s = 0.0;
        for (T4 n : list)
            s += n.doubleValue();
        return s;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sumOfList1: " + sumOfList1(li));
        System.out.println("sumOfList2: " + sumOfList2(li));
        System.out.print("printList1: "); printList1(li);
        System.out.print("printList2: "); printList2(li);
        List<Integer> dst1 = new ArrayList<>();
        copy1(dst1, li); System.out.println("copy1: " + dst1);
        List<Integer> dst2 = new ArrayList<>();
        copy2(dst2, li); System.out.println("copy2: " + dst2);
        GenericTypeOrWildcardDemo<Integer> demo = new GenericTypeOrWildcardDemo<>();
        List<Double> ld = Arrays.asList(1.1, 2.2, 3.3);
        sumList1(li); sumList1(ld); sumList1(li);
        System.out.println("history1: " + history1);
        demo.sumList2(li); // Since demo is created with Integer argument type, sumList2 may be called only with list of integers
                           // The same does not happen with wildcard.
        // demo.sumList2(ld); // Compile error
        System.out.println("history2: " + demo.history2);
    }
}
