package slides.lambda_expressions;

import java.util.Arrays;
import java.util.function.BiFunction;

public class TypeInstanceMethodReferenceDemo {

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public static void main(String[] args) {

        // Reference to an instance method of an arbitrary object of a particular type
        System.out.println(TypeInstanceMethodReferenceDemo.
                mergeThings("Hello ", "World!", String::concat));
        // Another example
        String[] stringArray = { "Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda" };
        Arrays.sort(stringArray, String::compareToIgnoreCase);
        for (String s : stringArray) System.out.println(s);
        // The same with lambda expression
        Arrays.sort(stringArray, (a, b) -> a.compareToIgnoreCase(b));
        for (String s : stringArray) System.out.println(s);
    }
}