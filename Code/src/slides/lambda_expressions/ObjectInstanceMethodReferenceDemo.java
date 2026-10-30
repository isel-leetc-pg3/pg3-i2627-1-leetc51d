package slides.lambda_expressions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

class ComparisonProvider {
    public int compareByName(Person a, Person b) {
        return a.getName().compareTo(b.getName());
    }

    public int compareByAge(Person a, Person b) {
        return a.getBirthday().compareTo(b.getBirthday());
    }
}

public class ObjectInstanceMethodReferenceDemo {

    public static <T> T mergeThings(T a, T b, BiFunction<T, T, T> merger) {
        return merger.apply(a, b);
    }

    public String appendStrings2(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {

        ObjectInstanceMethodReferenceDemo myApp = new ObjectInstanceMethodReferenceDemo();

        // Reference to an instance method of a particular object
        System.out.println(ObjectInstanceMethodReferenceDemo.
                mergeThings("Hello ", "World!", myApp::appendStrings2));

        // Reference to an instance method of an arbitrary object of a
        // particular type
        System.out.println(ObjectInstanceMethodReferenceDemo.
                mergeThings("Hello ", "World!", String::concat));

        // Another example
        List<Person> roster = Arrays.asList(
                new Person("Maria José", Person.Gender.FEMALE, LocalDate.of(2000, 1, 1), "maria.jose@gmail.com"),
                new Person("Mário Chispim", Person.Gender.MALE, LocalDate.of(1990, 1, 1), "mario.chispim@hotmail.com"),
                new Person("Lucas Simões", Person.Gender.MALE, LocalDate.of(2005, 1, 1), "lucas.simoes@gmail.com"),
                new Person("Xoné da Xica", Person.Gender.MALE, LocalDate.of(2000, 1, 2), "xone.xica@gmail.com")
        );
        Person[] rosterAsArray = roster.toArray(new Person[roster.size()]);
        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterAsArray, myComparisonProvider::compareByName);
        for (Person p : rosterAsArray) p.printPerson();

    }
}