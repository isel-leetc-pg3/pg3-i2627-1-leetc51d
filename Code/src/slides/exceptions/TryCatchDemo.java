package exceptions;

import java.util.Scanner;

public class TryCatchDemo {
    public static final String ENTRANCE_MSG = "Basic calculator machine";
    public static final String ENTER_END_PROGRAM_MSG = "Terminar programa? (Y/n)";
    public static final String ENTER_OPA_MSG = "Insira operando A: ";
    public static final String ENTER_OPB_MSG = "Insira operando B: ";
    public static final String LEAVING_MSG = "Terminando basic calculator";
    static int doMultiplication(int a, int b) { return a * b; }
    static int doDivision(int a, int b) { return a / b; }
    public static void tryCatchDemo() {
        Scanner in = new Scanner(System.in);
        int opA, opB;
        boolean isFinished;
        System.out.println(ENTRANCE_MSG);
        try {
            do {
                System.out.println(ENTER_END_PROGRAM_MSG);
                isFinished = in.next().charAt(0) == 'Y';
                if (!isFinished) {
                    System.out.print(ENTER_OPA_MSG); opA = in.nextInt();
                    System.out.print(ENTER_OPB_MSG); opB = in.nextInt();
                    System.out.println(opA + " / " + opB + " = " + doDivision(opA, opB));
                    System.out.println(opA + " * " + opB + " = " + doMultiplication(opA, opB));
                }
            } while(!isFinished);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }
        System.out.println(LEAVING_MSG);
    }

    public static void main(String[] args) {
        tryCatchDemo();
    }
}
