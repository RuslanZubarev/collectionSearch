package practice;

import java.util.*;

public class CoolNumbers {

    public static List<String> coolNum = new ArrayList<>();
    public static int coolNumId = 0;

    public static List<String> generateCoolNumbers() {
        StringBuilder coolNumStrB = new StringBuilder(); //для хранения сгенерированных номеров
        String allowedLetters = "АВЕКМНОРСТУХ";
        for (int i = 0; i < 12; i++) {                  // i - first letter
            for (int j = 0; j < 10; j++) {              // j - numbers
                for (int s = 0; s < 12; s++) {          // s - second letter
                    for (int t = 0; t < 12; t++) {      // t - third letter
                        for (int r = 1; r < 200; r++) { // r - region
                            coolNumStrB = new StringBuilder();
                            coolNumStrB.append(allowedLetters.charAt(i)).append(j).append(j).append(j)
                                    .append(allowedLetters.charAt(s)).append(allowedLetters.charAt(t));
                            if (r < 10) {
                                coolNumStrB.append("0").append(r); //вывод номера в формате 01
                            } else {
                                coolNumStrB.append(r);
                            }
                            coolNum.add(coolNumId, coolNumStrB.toString());
                            coolNumId++;
                        }
                    }
                }
            }
        }
        return coolNum;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        List<String> coolNums = new ArrayList<>(coolNum);
        for (String string : coolNums) {
            if (string.contains(number)) {
                System.out.println(string);
            }
        }
        return list.contains(number);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        int value = Collections.binarySearch(sortedList, number);
        return value >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
        if (hashSet.contains(number)) {
            for (String obj : hashSet) {
                if (obj.equals(number)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        if (treeSet.contains(number)) {
            for (String obj : treeSet) {
                if (obj.equals(number)) {
                    return true;
                }
            }
        }
        return false;
    }

}
