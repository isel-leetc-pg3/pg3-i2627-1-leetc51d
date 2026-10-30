package slides.functional_interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    public static <T,R> List<R> functionDemo(List<T> list, Function<T,R> map) {
        ArrayList<R> r = new ArrayList<>();
        for(T v: list)
            r.add(map.apply(v));
        return r;
    }

    public static void main(String[] args) {
        List<Integer> il = Arrays.asList(1, 100, 230, 23, 48, 23, 63, 65, 23, 50);
        Function<Integer, Double> factor2p5 = i -> i*2.5;
        List<Double> dl = functionDemo(il, factor2p5); // print elems
        System.out.println(dl);
        List<String> sl = Arrays.asList("água", "terra", "ar", "fogo");
        Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();
        List<String> rsl = functionDemo(sl, reverse);
        System.out.println(rsl);
    }
}
