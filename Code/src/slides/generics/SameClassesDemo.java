package slides.generics;

import java.util.ArrayList;
import java.util.List;

public class SameClassesDemo {
    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>();
        List<String> sList = new ArrayList<>();
        boolean isSame = iList.getClass() == sList.getClass();
        System.out.println("iList == sList returns " + isSame);
    }
}
