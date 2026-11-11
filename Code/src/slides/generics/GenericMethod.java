package slides.generics;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethod {
    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
               p1.getValue().equals(p2.getValue());
    }

    public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
        for(T o: a)
            c.add(o);
    }

    public static void compareDemo() {
        Pair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        Pair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        boolean same1 = GenericMethod.<Integer, String>compare(p1, p2);
        boolean same2 = GenericMethod.compare(p1, p2); // Por inferência
    }
    // Copied from https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
    // The compiler will generally infer the most specific type argument that will make the call type-correct.
    public static void fromArrayToCollectionDemo() {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<Object>();

        // T inferred to be Object
        fromArrayToCollection(oa, co);

        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<String>();

        // T inferred to be String
        fromArrayToCollection(sa, cs);

        // T inferred to be Object
        fromArrayToCollection(sa, co);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];
        Collection<Number> cn = new ArrayList<Number>();

        // T inferred to be Number
        fromArrayToCollection(ia, cn);

        // T inferred to be Number
        fromArrayToCollection(fa, cn);

        // T inferred to be Number
        fromArrayToCollection(na, cn);

        // T inferred to be Object
        fromArrayToCollection(na, co);

        // compile-time error: Number and String are not related with each other
        // fromArrayToCollection(na, cs);
    }

    public static void main(String[] args) {
        compareDemo();
    }
}
