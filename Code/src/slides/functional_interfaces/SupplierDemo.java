package slides.functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierDemo {
    public static <R extends List<S>,T,S> R supplierDemo(List<T> list, Supplier<R> supplier, Function<T,S> map) {
        R r = supplier.get();
        for(T v: list)
            r.add(map.apply(v));
        return r;
    }

    public static void main(String[] args) {
        List<Integer> il = Arrays.asList(1, 100, 230, 23, 48, 23, 63, 65, 23, 50);
        Supplier<List<Double>> col1 = ArrayList::new;
        Function<Integer, Double> factor2p5 = i -> i*2.5;
        List<Double> dl = supplierDemo(il, col1, factor2p5);
        System.out.println(dl);
        List<String> sl = Arrays.asList("água", "terra", "ar", "fogo");
        Supplier<List<String>> col2 = LinkedList::new;
        Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();
        List<String> rsl = supplierDemo(sl, col2, reverse);
        System.out.println(rsl);
    }
}
