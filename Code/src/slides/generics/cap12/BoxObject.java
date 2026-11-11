package slides.generics.cap12;

public class BoxObject {
    private Object t;
    public BoxObject() {}
    public BoxObject(Object t) { this.t = t; }
    public Object get() { return t; }
    public void set(Object t) { this.t = t; }
}
