package slides.generics.cap12;

import java.util.*;

public class ArrayListDemo {
    static void printWithGet(List<String> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
    static void printWithIterator(List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }
    static void printWithForEachInstruction(List<String> list) {
        for (String s : list) // internamente usa um iterador
            System.out.println(s);
    }
    static void printWithIterableForEachWithLambda(List<String> list) {
        list.forEach(v -> System.out.println(v));
    }
    static void printWithForEachWithMethodReference(List<String> list) {
        list.forEach(System.out::println);
    }
    public static void main(String[] args) {
        // Criação
        ArrayList<Integer> al = new ArrayList<>(100);
        // Adição
        System.out.println("isEmpty: " + al.isEmpty());
        al.add(10);
        al.add(1,20);
        al.add(30);
        System.out.println("size: " + al.size());
        al.set(1, 30);
        System.out.println("size: " + al.size());
        // Remoção
        al.removeFirst();
        al.remove(Integer.valueOf(30));
        System.out.println("size: " + al.size());
        // Pesquisa
        al.add(30);
        System.out.println("indexOf 30: " + al.indexOf(30));
        System.out.println("lastIndexOf 30: " + al.lastIndexOf(30));
        System.out.println("contains 10: " + al.contains(10));
        // Clone
        ArrayList<Integer> copyAl = (ArrayList<Integer>)al.clone();
        System.out.println("copyAl.equals(al): " + copyAl.equals(al));
        System.out.println("copyAl == al: " + (copyAl == al));
        // for-each
        List<String> l1 = Arrays.asList("Olá", "isto", "é", "um", "teste");
        System.out.println("l1.getClass().getName(): " + l1.getClass().getName());
        List<String> l2 = new LinkedList<>(l1);
        System.out.println("\nPrint with get");
        printWithGet(l1); printWithGet(l2);
        System.out.println("\nPrint with iterator");
        printWithIterator(l1); printWithIterator(l2);
        System.out.println("\nPrint with for each instruction");
        printWithForEachInstruction(l1); printWithForEachInstruction(l2);
        System.out.println("\nPrint with iterable for each with lambda");
        printWithIterableForEachWithLambda(l1); printWithIterableForEachWithLambda(l2);
        System.out.println("\nPrint with iterable for each with method reference");
        printWithForEachWithMethodReference(l1); printWithForEachWithMethodReference(l2);
    }
}
