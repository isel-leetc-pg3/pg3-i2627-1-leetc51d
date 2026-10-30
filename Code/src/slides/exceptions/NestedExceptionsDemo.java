package exceptions;

public class NestedExceptionsDemo {
    public static void main(String[] args) throws BException, CException {
        int cnt = 10; System.out.println("Insira palavras");
        while (cnt-- > 0)
            try {
                try { System.out.println(ExceptionsGenerator.generate()); }
                catch(AException e) { System.out.println("Inner try: " + e.getMessage()); }
            }
            catch(BException e) {
                System.out.println("Outer: " + e.getMessage());
                try { System.out.println(ExceptionsGenerator.generate()); }
                catch(AException e1) { System.out.println("Inner catch: " + e1.getMessage()); }
            }
            catch(CException e) { System.out.println("Outer: " + e.getMessage()); }
    }
}
