package slides.lambda_expressions;

import java.util.function.BiFunction;

public class StaticMethodReferenceDemo {

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public static String appendStrings(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {

        // Calling the method mergeThings with a lambda expression
        System.out.println(StaticMethodReferenceDemo.
                mergeThings("Hello ", "World!", (a, b) -> a + b));

        // Reference to a static method
        System.out.println(StaticMethodReferenceDemo.
                mergeThings("Hello ", "World!", StaticMethodReferenceDemo::appendStrings));
    }
}