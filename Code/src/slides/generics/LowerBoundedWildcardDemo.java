package slides.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowerBoundedWildcardDemo {
    public static void addRange(List<? super Integer> list, int n) {
        for(int i = 1; i <= n; i ++)
            list.add ( i );
    }

    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>(Arrays.asList(1, 3, 4, 10));
        List<Number> ln = new ArrayList<>(Arrays.asList(1.7, 3.5, 4, 10.2));
        addRange(li, 10);
        addRange(ln, 5);
        li.forEach(System.out::println);
        ln.forEach(System.out::println);
    }
}
