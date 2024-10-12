package udemy.recursion;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {

    // O(n!) time
    public static List<String> findAnagrams(String word) {
        if (word.length() == 1) {
            List<String> potentialAnagramList = new ArrayList<>();
            potentialAnagramList.add(word);
            return potentialAnagramList;
        }

        List<String> anagramList = new ArrayList<>();
        char currentChar = word.charAt(0);
        String subset = word.substring(1, word.length());
        List<String> potentialAnagramList = findAnagrams(subset);
        insertCharacterAtEveryPosition(potentialAnagramList, currentChar, anagramList);

        return anagramList;
    }

    private static void insertCharacterAtEveryPosition(List<String> potentialAnagramList, char currentChar, List<String> anagramList) {
        for (String potentialAnagram : potentialAnagramList) {
            for (int insertIndex = 0; insertIndex <= potentialAnagram.length(); insertIndex++) {
                StringBuilder sb = new StringBuilder(potentialAnagram);
                if (insertIndex < potentialAnagram.length()) {
                    sb.insert(insertIndex, currentChar);
                } else {
                    sb.append(currentChar);
                }

                anagramList.add(sb.toString());
            }
        }
    }

}
