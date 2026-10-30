package exceptions;

public class FinallyDemo {
    public static void main(String[] args) throws CException {
        int cnt = 3;
        while (cnt-- > 0) {
            System.out.println("Insira palavra");
            try {
                System.out.println(ExceptionsGenerator.generate());
            } catch (AException e) {
                System.out.println("1: " + e.getMessage());
            } catch (BException e) {
                System.out.println("2: " + e.getMessage());
            } finally {
                System.out.println("3: Finally block");
            }
            System.out.println("Doing again");
        }
    }
}
