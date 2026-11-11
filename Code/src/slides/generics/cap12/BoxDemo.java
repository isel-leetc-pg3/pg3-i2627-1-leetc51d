package slides.generics.cap12;

public class BoxDemo {
    static void rawParametrizedType() {
        BoxGeneric<String> b1 = new BoxGeneric<>();
        BoxGeneric b2 = b1;
        b2.set(123);

        BoxGeneric b3 = new BoxGeneric();
        BoxGeneric<Integer> b4 = b3;

        //BoxGeneric<Object> b5 = b1; // Erro de compilação

    }
    public static void main(String[] args) {
        BoxObject b1 = new BoxObject();
        BoxGeneric<String> b2 = new BoxGeneric<>();

        b1.set("123");
        String s1 = (String)b1.get();
        b2.set("123");
        String s2 = b2.get();
        b1.set(123);
        String s3 = (String)b1.get();
        //b2.set(123); // Erro de compilação

        rawParametrizedType();
    }
}
