package slides.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Producer Extends, Consumer Super
 * Helps to understand when to use wildcard with extends or with super.
 * The gold rule is:
 * 1. When you only need to read (the generic type is a producer of values) use extends
 * 2. When you only need to write (the generic type is a consumer of values) use super
 *
 */
public class PecsDemo {
    public static void pe(List<? extends Number> l) {
        //l.set(0, 10.0); // Compile error: cannot do it because l elements type may differ from Double type (Integer, for instance)
        Number v = l.getFirst();
        System.out.println(v);
    }
    public static void cs(List<? super Double> l) {
        l.set(0, 10.0); // Support Double or any supertype
        //Number d = l.getFirst(); // Compile error: cannot do it because l elements may be from a supertype of Double
        Object d = l.getFirst(); // The minimum support type is Object because it is the only supertype of all class types
        System.out.println(d);
    }

    public static List<? super Number> copy(List<? super Number> dst, List<? extends Number> src) {
        for (Number n: src)
            dst.add(n);
        return dst;
    }

    public static void main(String[] args) {
        pe(List.of(11.1, 22.2));
        pe(List.of(11, 22));
        List<Number> list = new ArrayList<>();
        list.add(33.3); list.add(10); list.add(1.1);
        cs(list);
        System.out.println("copy: " + copy(new ArrayList<>(), list));
    }
}
