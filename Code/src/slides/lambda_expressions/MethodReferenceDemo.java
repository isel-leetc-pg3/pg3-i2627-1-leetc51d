package slides.lambda_expressions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String... args)  {
        List<Person> roster = Arrays.asList(
                new Person("Maria José", Person.Gender.FEMALE, LocalDate.of(2000, 1,1), "maria.jose@gmail.com"),
                new Person("Mário Chispim", Person.Gender.MALE, LocalDate.of(1990,1, 1), "mario.chispim@hotmail.com"),
                new Person("Lucas Simões", Person.Gender.MALE, LocalDate.of(2005, 1, 1), "lucas.simoes@gmail.com"),
                new Person("Xoné da Xica", Person.Gender.MALE, LocalDate.of(2000, 1, 2), "xone.xica@gmail.com")
                );

        for (Person p : roster) {
            p.printPerson();
        }

        Person[] rosterAsArray;

        class PersonAgeComparator
                implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        System.out.println("With class PersonAgeComparator implements Comparator");
        rosterAsArray = roster.toArray(new Person[roster.size()]);
        Arrays.sort(rosterAsArray, new PersonAgeComparator());
        for (Person p : rosterAsArray) p.printPerson();

        // With lambda expression with Comparator
        System.out.println("With lambda expression with Comparator");
        rosterAsArray = roster.toArray(new Person[roster.size()]);
        Arrays.sort(rosterAsArray,
                (a, b) -> a.getBirthday().compareTo(b.getBirthday())
        );
        for (Person p : rosterAsArray) p.printPerson();

        // With lambda expression with Person.compareByAge(...)
        System.out.println("With lambda expression with Person.compareByAge");
        rosterAsArray = roster.toArray(new Person[roster.size()]);
        Arrays.sort(rosterAsArray,
                (a, b) -> Person.compareByAge(a, b)
        );
        for (Person p : rosterAsArray) p.printPerson();

        // With compareByAge method reference
        System.out.println("With compareByAge method reference");
        rosterAsArray = roster.toArray(new Person[roster.size()]);
        Arrays.sort(rosterAsArray, Person::compareByAge);
        for (Person p : rosterAsArray) p.printPerson();
    }
}
