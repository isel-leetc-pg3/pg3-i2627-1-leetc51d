package slides.generics.cap12;

public final class Student {
    private String name;
    private int number;

    public Student(String name, int number) {
        this.name = name; this.number = number;
    }

    public String getName() { return name; }
    public int getNumber() { return number; }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student student)) return false;
        return number == student.number;
    }

    @Override
    public int hashCode() { return number; }

    @Override
    public String toString() {
        return "name: \"" + name + "\", number: " + number;
    }
}
