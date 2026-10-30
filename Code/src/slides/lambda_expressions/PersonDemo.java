package slides.lambda_expressions;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

interface CheckPerson {
    boolean test(Person p);
}
class CheckMale_18_25 implements CheckPerson {
    public boolean test(Person p) {
        return p.getGender() == Person.Gender.MALE &&
                p.getAge() >= 18 &&
                p.getAge() <= 25;
    }
}

public class PersonDemo {
    public static void printWithinAgeRangeDemo(List<Person> roster) {
        for (Person p : roster) {
            if (p.getGender() == Person.Gender.MALE && 18 <= p.getAge() && p.getAge() < 25) {
                p.printPerson();
            }
        }
    }

    private static void printWithCheckPerson(List<Person> roster, CheckPerson tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printWithLocalClassDemo(List<Person> roster) {
        printWithCheckPerson(roster, new CheckMale_18_25());
    }

    public static void printWithAnonymousClassDemo(List<Person> roster) {
        printWithCheckPerson(
                roster,
                new CheckPerson() {
                    public boolean test(Person p) {
                        return p.getGender() == Person.Gender.MALE
                                && p.getAge() >= 18
                                && p.getAge() <= 25;
                    }
                }
        );
    }

    public static void printWithLambdaDemo(List<Person> roster) {
        printWithCheckPerson(
                roster,
                (Person p) -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }

    private static void printWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    public static void printPredicateDemo(List<Person> roster) {
        printWithPredicate(
                roster,
                (p) -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );
    }

    private static void process(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                block.accept(p);
            }
        }
    }

    public static void processPersonsPredicateConsumerDemo(List<Person> roster) {
        process(
                roster,
                p -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.printPerson()
        );
    }
    private static void processWithFunction(List<Person> roster, Predicate<Person> tester,
                                                  Function<Person, String> mapper, Consumer<String> block) {
        for (Person p : roster) {
            if (tester.test(p)) {
                String data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    public static void processPersonsWithFunctionDemo(List<Person> roster) {
        processWithFunction(
                roster,
                p -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }
    private static <X,Y> void processGenerics(
            Iterable<X> source, Predicate<X> tester,
            Function<X, Y> mapper, Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    public static void processGenericsDemo(List<Person> roster) {
        processGenerics(
                roster,
                p -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }
    public static void processGenericsWithMethodReferencesDemo(List<Person> roster) {
        processGenerics(
                roster,
                p -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::getEmailAddress,
                System.out::println
        );
    }
    public static void processAggregateOperationsDemo(List<Person> roster) {
        roster
                .stream()
                .filter(
                        p -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25)
                .map(Person::getEmailAddress)
                .forEach(System.out::println);
    }

    public static void processGenericsDemo2(List<Person> roster) {
        processGenerics(
                roster,
                p -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                _ -> System.out.println("Xpto")
        );
    }
    interface CheckPerson3<T> {
        boolean test(T p, int l, int h);
    }
    static <X,Y> void processGenerics3(
            Iterable<X> source, CheckPerson3<X> tester,
            Function<X, Y> mapper, Consumer<Y> block)
    {
        for (X p : source) {
            if (tester.test(p, 18, 25)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }
    public static void processGenericsDemo3(List<Person> roster) {
        processGenerics3(
                roster,
                (p, l, h) -> p.getGender() == Person.Gender.MALE
                        && p.getAge() >= l
                        && p.getAge() <= h,
                p -> p.getEmailAddress(),
                email -> System.out.println(email)
        );
    }

}
