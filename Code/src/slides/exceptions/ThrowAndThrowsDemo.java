package exceptions;

import java.util.Scanner;

public class ThrowAndThrowsDemo {
    public static final int STOCK_SIZE = 10, MAX_TRIES = 3;
    static private Scanner in; static private int[] stock;

    public static int readStockItem() throws IllegalStockValueException {
        System.out.println("Insira valor entre 0 e 100:"); int v = in.nextInt();
        if (v < 0 || v > 100)
            throw new IllegalStockValueException("Invalid stock value: entered " + v + ", range valid: 0..100");
        return v;
    }
    public static void fillStock() throws IllegalStockValueException {
        for (int i = 0; i < stock.length; i++) stock[i] = readStockItem();
    }

    public static void main(String[] args) {
        in = new Scanner(System.in);
        stock = new int[STOCK_SIZE];
        int nTries = MAX_TRIES;
        boolean success = false;
        while (nTries > 0 && !success)
            try { fillStock(); success = true; }
            catch (IllegalStockValueException e) {
                System.out.println(e.getMessage());
                if (nTries > 0) System.out.println("Fill again");
                nTries -= 1;
            }
        System.out.println(success ?
                "Success filling stock":
                "Oh, no! Unsuccess filling stock");
    }
}

