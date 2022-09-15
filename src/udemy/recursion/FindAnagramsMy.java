package udemy.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAnagramsMy {

    public static void main(String[] args) {
        String string = "ROAD";

        findAnagrams(string);

        System.out.println();
    }

    public static List<String> findAnagrams(String string) {
        List<String> result = new ArrayList<>();
        findAnagramsHelper(string, "", result);
        return result;
    }

    private static void findAnagramsHelper(String string, String current, List<String> result) {
        if (string.isEmpty()) {
            result.add(current);
        } else {
            List<String> stringList = createList(string);
            int size = stringList.size();
            for (int i = 0; i < size; i++) {
                String str = stringList.get(i);
                String newCurrent = current + str;
                List<String> newList = createList(string);
                newList.remove(i);
                StringBuilder newString = new StringBuilder();
                for (String element : newList) {
                    newString.append(element);
                }
                findAnagramsHelper(newString.toString(), newCurrent, result);
            }
        }
    }

    private static List<String> createList(String string) {
        List<String> stringList = new ArrayList<>();
        for (char c : string.toCharArray()) {
            stringList.add("" + c);
        }
        return stringList;
    }

}
