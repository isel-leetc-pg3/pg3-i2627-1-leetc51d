package exceptions;

import java.util.Scanner;

public class ExceptionsGenerator {
    static Scanner in = new Scanner(System.in);
    static String generate() throws AException, BException, CException {
        String s = in.next();
        switch(s.charAt(0)) {
            case 'a','A': throw new AException();
            case 'b','B': throw new BException();
            case 'c','C': throw new CException();
        }
        return s;
    }
}
