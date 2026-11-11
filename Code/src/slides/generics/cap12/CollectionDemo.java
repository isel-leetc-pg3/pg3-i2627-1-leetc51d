package slides.generics.cap12;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo {
    private Collection<Student> students = new ArrayList<>();

    public boolean addStudent(Student s) { return students.add(s); }
    public boolean removeStudent(Student s) { return students.remove(s); }
    public boolean containsStudent(Student s) { return students.contains(s); }
    public int getTotalStudents() { return students.size(); }
    public void clearAllStudents() { students.clear(); }
    public void printAllStudents() {
        students.forEach(s -> System.out.println("\t: " + s));
    }
}
