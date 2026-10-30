package exceptions;

import java.util.Scanner;

public class MoreThanOneCatchDemo {

    public static void moreThanOneCatchWrongDemo() {
        int[] a = {0, 1, 2, 3};
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Insira um inteiro:");
            a[3] = scanner.nextInt();
            System.out.println("Insira outro inteiro:");
            a[4] = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("1: " + e.getClass() + ", " + e.getMessage());
        } /*catch (ArrayIndexOutOfBoundsException e) { // Error de compilação1
            System.out.println(e.getClass() + ", " + e.getMessage());
        }*/
    }

    public static void moreThanOneCatchRightDemo() {
        int[] a = {0, 1, 2, 3};
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Insira um inteiro:");
            a[3] = scanner.nextInt();
            System.out.println("Insira outro inteiro:");
            a[4] = scanner.nextInt();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("1: " + e.getClass() + ", " + e.getMessage());
        } catch (Exception e) {
            System.out.println("2: " + e.getClass() + ", " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        moreThanOneCatchWrongDemo();
        moreThanOneCatchRightDemo();
    }
}
