package slides.generics;

import java.util.Arrays;
import java.util.List;

public class C2_OrderedPairDemo {
    public static void main(String[] args) {
        Pair<String, Integer> p1 = new OrderedPair<>("Even", 8);
        Pair<String, String>  p2 = new OrderedPair<>("hello", "world");
        Pair<Integer, List<String>> p3 = new OrderedPair<>(1, Arrays.asList("abc", "def"));
    }
}
