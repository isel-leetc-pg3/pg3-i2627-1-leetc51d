package slides.generics.cap12;

public class BoxGeneric<T> {
    private T t;
    public BoxGeneric() {}
    public BoxGeneric(T t) { this.t = t; }
    public T get() { return t; }
    public void set(T t) { this.t = t; }
}
