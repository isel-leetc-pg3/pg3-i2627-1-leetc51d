package slides.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class Struct {
    Struct(int x, int y) { this.a = x; this.b = y; }
    int a, b, r;
    public String toString() { return "r = " + r; }
}

public class ConsumerDemo {
    public static <T> void ConsumerDemo(List<T> list, Consumer<T> consumer) {
        for(T v: list)
            consumer.accept(v);
    }

    public static void main(String[] args) {
        List<Integer> il = Arrays.asList(1, 100, 230, 23, 48, 23, 63, 65, 23, 50);
        Consumer<Integer> cons = System.out::println;
        ConsumerDemo(il, cons);
        List<Struct> xl = Arrays.asList(new Struct(10, 20), new Struct(15,20), new Struct(15, 4));
        Consumer<Struct> add = x -> x.r = x.a + x.b, sub = x -> x.r = x.a - x.b;
        ConsumerDemo(xl, add);
        System.out.println(xl);
        ConsumerDemo(xl, sub);
        System.out.println(xl);
    }
}
