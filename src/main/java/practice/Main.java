package practice;

import java.util.*;

public class Main {

    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска вводимого номера в консоль в каждой из структуры данных
     - проанализировать полученные данные
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNum = scanner.nextLine();
        long start;
        long stop;
        long duration;
        String find;

        List<String> list = new ArrayList<>(CoolNumbers.generateCoolNumbers());
        HashSet<String> hashSet = new HashSet<>(list);
        TreeSet<String> treeSet = new TreeSet<>(list);

        //поиск перебором
        start = System.nanoTime();
        find = CoolNumbers.bruteForceSearchInList(list, inputNum) ? "найден" : "не найден";
        stop = System.nanoTime();
        duration = stop - start;
        System.out.println("Поиск перебором: номер " + find + " поиск занял: " + duration + " нс");

        //бинарный поиск
        Collections.sort(list);
        start = System.nanoTime();
        find = CoolNumbers.binarySearchInList(list, inputNum) ? "найден" : "не найден";
        stop = System.nanoTime();
        duration = stop - start;
        System.out.println("Бинарный поиск: номер " + find + " поиск занял: " + duration + " нс");


        //поиск по hashSet
        start = System.nanoTime();
        find = CoolNumbers.searchInHashSet(hashSet, inputNum) ? "найден" : "не найден";
        stop = System.nanoTime();
        duration = stop - start;
        System.out.println("Поиск по hashSet: номер " + find + " поиск занял: " + duration + " нс");





        //поиск по treeSet
        start = System.nanoTime();
        find = CoolNumbers.searchInTreeSet(treeSet, inputNum) ? "найден" : "не найден";
        stop = System.nanoTime();
        duration = stop - start;
        System.out.println("Поиск по treeSet: номер " + find + " поиск занял: " + duration + " нс");
    }
}
