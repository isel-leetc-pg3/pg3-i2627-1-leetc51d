package slides.nested_classes;

public class LocalClass {
    static String regularExpression = "[^0-9]"; // Any character except 0 to 9

    public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {

        final int numberLength = 9;
        // Valid in JDK 8 and later:
        // int numberLength = 9; effectively final

        class PhoneNumber {
            String formattedPhoneNumber = null;

            // Contradiz o que está referido no tutorial: apenas suporta membros estáticos se forem constantes (final)
            // Deve ser uma capacidade adicionada depois da versão 8 do Java
            static String hello = "hello";
            static int cntHellos = 1;
            public static void sayGoodbye() {
                System.out.println("Goodbye");
            }
            PhoneNumber(String phoneNumber){
                // numberLength = 7;
                String currentNumber = phoneNumber.replaceAll(
                        regularExpression, "");
                if (currentNumber.length() == numberLength)
                    formattedPhoneNumber = currentNumber;
                else
                    formattedPhoneNumber = null;
            }

            public String getNumber() {
                return formattedPhoneNumber;
            }

            // Valid in JDK 8 and later:
            public void printOriginalNumbers() {
                System.out.println("Original numbers are " + phoneNumber1 +
                    " and " + phoneNumber2);
            }
        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        // Valid in JDK 8 and later:
        myNumber1.printOriginalNumbers();
        // Contradiz o que está referido no tutorial: apenas suporta membros estáticos se forem constantes (final)
        // Deve ser uma capacidade adicionada depois da versão 8 do Java
        System.out.println(PhoneNumber.hello + ' ' + PhoneNumber.cntHellos++);
        PhoneNumber.sayGoodbye();

        if (myNumber1.getNumber() == null)
            System.out.println("First number is invalid");
        else
            System.out.println("First number is " + myNumber1.getNumber());
        if (myNumber2.getNumber() == null)
            System.out.println("Second number is invalid");
        else
            System.out.println("Second number is " + myNumber2.getNumber());

    }

    public static void main(String... args) {
        validatePhoneNumber("21 345-67-89", "912-345-67-89");
        validatePhoneNumber("21 345-67-89", "912-345-67-89");
    }
}