package slides.generics;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcardDemo {
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static <T extends Number> double sumOfList2(List<T> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li));
        List<Double> ld = Arrays.asList(1.6, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld));
        List<Long> ll = Arrays.asList(1L, 2L, 3L);
        System.out.println("sum = " + sumOfList(ll));
        List<Float> lf = Arrays.asList(1.6F, 2.3F, 3.5F);
        System.out.println("sum = " + sumOfList(lf));
    }
}
