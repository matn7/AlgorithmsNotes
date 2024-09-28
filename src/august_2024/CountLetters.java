package august_2024;

import java.util.HashMap;
import java.util.Map;

public class CountLetters {

    public static void main(String[] args) {
        System.out.println(countLetters("hello"));
        System.out.println(countLetters("aauuchhh"));
        System.out.println(countLetters("aaaaa"));
        System.out.println(countLetters("abc"));
        System.out.println(countLetters("abca"));
    }

    public static Map<Character, Integer> countLetters(String str) {
        Map<Character, Integer> charsMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (charsMap.containsKey(c)) {
                charsMap.put(c, charsMap.get(c) + 1);
            } else {
                charsMap.put(c, 1);
            }
        }
        return charsMap;
    }

}
