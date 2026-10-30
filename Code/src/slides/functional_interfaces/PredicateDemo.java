package slides.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static <T> int predicateDemo(List<T> list, Predicate<T> filter) {
        int count = 0;
        for(T v: list)
            if (filter.test(v))
                count += 1;
        return count;
    }

    public static void main(String[] args) {
        List<Integer> il = Arrays.asList(1, 100, 230, 23, 48, 23, 63, 65, 23, 50);
        int cnt;
        Predicate<Integer> size = _ -> true;
        cnt = predicateDemo(il, size); System.out.println("Size: " + cnt);
        Predicate<Integer> even = i -> i%2 == 0;
        cnt = predicateDemo(il, even); System.out.println("Evens: " + cnt);
        Predicate<Integer> odd = i -> i%2 == 1;
        cnt = predicateDemo(il, odd); System.out.println("Odds: " + cnt);
        Predicate<Integer> above50 = i -> i > 50;
        cnt = predicateDemo(il, above50); System.out.println("Above50: " + cnt);
        List<String> sl = Arrays.asList("água", "terra", "ar", "fogo");
        Predicate<String> above4Letters = s -> s.length() > 4;
        cnt = predicateDemo(sl, above4Letters); System.out.println("Above4Letters: " + cnt);
        Predicate<String> containsA = s -> s.toLowerCase().contains("a");
        cnt = predicateDemo(sl, containsA); System.out.println("ContainsALetter: " + cnt);
    }
}
