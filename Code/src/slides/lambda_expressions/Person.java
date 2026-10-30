package slides.lambda_expressions;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    public static final String NO_EMAIL = "no email address";
    public enum Gender {
        MALE, FEMALE
    }

    private final String name;
    private final LocalDate birthday;
    private final Gender gender;
    private String emailAddress;

    public Person(String n, Gender g, LocalDate b, String e) {
        name = n; gender = g; birthday = b; emailAddress = e;
    }
    public Person(String n, Gender g, LocalDate b) {
        this (n, g, b, null);
    }
    public int getAge() {
        return Period.between(birthday, LocalDate.now()).getYears();
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Gender getGender() { return gender; }
    public String getEmailAddress() { return emailAddress; }
    public String getName() { return name; }
    public LocalDate getBirthday() { return birthday; }

    @Override
    public String toString() {
        return "" + name + " [" + gender + '|' + birthday + "]: " + (emailAddress == null ? NO_EMAIL : emailAddress);
    }
    public void printPerson() {
        System.out.println(this);
    }

    /*
    Método adicionado à classe Person no âmbito da demonstração com referência a métodos em vez de expressões lambda.
     */
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static void main(String[] args) {
        Person p = new Person("Tati", Gender.FEMALE, LocalDate.of(1978, 3, 6), "tati@hotmail.com");
        System.out.println(p);
    }
}
