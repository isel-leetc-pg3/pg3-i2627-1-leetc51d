package slides.lambda_expressions;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

public class ConstructorMethodReferenceDemo {

    // The method transferElements copies elements from one collection to another

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(SOURCE sourceCollection, Supplier<DEST> collectionFactory)
    {
        DEST result = collectionFactory.get();
        result.addAll(sourceCollection);
        return result;
    }

    public static void main(String... args) {
        List<Person> roster = Arrays.asList(
                new Person("Maria José", Person.Gender.FEMALE, LocalDate.of(2000, 1,1), "maria.jose@gmail.com"),
                new Person("Mário Chispim", Person.Gender.MALE, LocalDate.of(1990,1, 1), "mario.chispim@hotmail.com"),
                new Person("Lucas Simões", Person.Gender.MALE, LocalDate.of(2005, 1, 1), "lucas.simoes@gmail.com"),
                new Person("Xoné da Xica", Person.Gender.MALE, LocalDate.of(2000, 1, 2), "xone.xica@gmail.com")
        );
        Set<Person> rosterSetLambda = transferElements(roster, () -> { return new HashSet<>(); });
        System.out.println("Printing rosterSetLambda:");
        rosterSetLambda.forEach(Person::printPerson);

        Set<Person> rosterSet = transferElements(roster, HashSet::new);
        System.out.println("Printing rosterSet:");
        rosterSet.forEach(Person::printPerson);

    }
}
