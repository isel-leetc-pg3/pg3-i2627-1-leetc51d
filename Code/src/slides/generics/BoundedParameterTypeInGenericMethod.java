package slides.generics;

public class BoundedParameterTypeInGenericMethod {
    public static <T extends Comparable<T>> int countGreaterThan(T elem, T ... sequence) {
        int count = 0;
        for (T e : sequence)
            if (e.compareTo(elem) > 0)
                ++count;
        return count;
    }

    public static void main(String[] args) {
        int cnt = countGreaterThan(10.2, 1.0, 2.0, 3.0, 4.5, 10.2, 10.5, 10.0, 20.0);
        System.out.println(cnt);
        int cnt2 = countGreaterThan("m", "a", "b", "c", "m", "n", "o");
        System.out.println(cnt2);
    }
}
