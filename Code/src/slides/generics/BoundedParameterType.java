package slides.generics;

public class BoundedParameterType<T extends Number> {
    private T e1, e2;

    public BoundedParameterType(T e1, T e2) {
        this.e1 = e1; this.e2 = e2;
    }
    public double sum() { return e1.doubleValue() + e2.doubleValue(); }

    public static void main(String[] args) {
        BoundedParameterType<Integer> bv = new BoundedParameterType<>(10, 26);
        double sum = bv.sum();
        System.out.println(sum);
    }
}
