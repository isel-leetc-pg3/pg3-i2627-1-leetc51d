package slides.generics;

import slides.generics.cap12.BoxGeneric;

public class InheritanceVersusGenericsDemo {
    public static void inheritanceVersusGenerics() {
        BoxGeneric<Integer> b1 = new BoxGeneric<>(10);
        //BoxGeneric<Number> b2 = b1; // Compile error: Integer deriva de Number mas BoxGeneric<Integer> não deriva de BoxGeneric<Number>
    }
}
