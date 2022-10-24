package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String s = reverseWordsInString("AlgoExpert is the      best!");
        System.out.println(s);
    }
     // OK - repeated 15/02/2022
    // O(n) time | O(n) space
//    public static String reverseWordsInString(String string) {
//        char[] characters = string.toCharArray();
//        // string = "AlgoExpert is the      best!"
//        reverseListRange(characters, 0, characters.length - 1);
//
//        // string = "!tseb      eht si trepxEoglA"
//        //                e
//        int startOfWord = 0;
//        while (true) {
//            int endOfWord = startOfWord;
//            while (endOfWord < characters.length && characters[endOfWord] != ' ') {
//                endOfWord++;
//            }
//            if (endOfWord == characters.length) {
//                reverseListRange(characters, startOfWord, characters.length - 1);
//                break;
//            }
//
//            reverseListRange(characters, startOfWord, endOfWord - 1);
//            startOfWord = endOfWord + 1;
//            // best!      the is AlgoExpert"
//        }
//        return String.valueOf(characters);
//    }
//
//    private static void reverseListRange(char[] characters, int start, int end) {
//        // string = "AlgoExpert is the      best!"
//        //           s                          e
//        // string = "!tseb      eht si trepxEoglA"
//        while (start < end) {
//            swap(start, end, characters);
//            start++;
//            end--;
//        }
//    }
//
//    private static void swap(int i, int j, char[] array) {
//        char temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }

    // O(n) time | O(n) space
    public static String reverseWordsInString(String string) {
        // "AlgoExpert is the      best!"
        //                         i
        List<String> words = new ArrayList<>();
        int startOfWord = 0;
        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);
            if (character == ' ') {
                words.add(string.substring(startOfWord, idx));
                startOfWord = idx;
            } else if (string.charAt(startOfWord) == ' ') {
                words.add(" ");
                startOfWord = idx;
            }
        }
        // ["AlgoExpert", " ", "is", " ", "the", " ", " ", " ", " ", " ", " ", " ", "best!"]
        words.add(string.substring(startOfWord));

        int index = words.size() - 1;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(index));
            index--;
        }
        return result.toString();
    }

//    // O(n) time | O(n) space
//    public static String reverseWordsInString(String string) {
//        // Write your code here.
//        List<String> words = new ArrayList<>();
//        StringBuilder builder = new StringBuilder();
//        int counter = 0;
//        // "AlgoExpert is the      best!"
//        //            c
//        while (counter < string.length()) {
//            // take care of words
//            while (counter < string.length() && string.charAt(counter) != ' ') {
//                builder.append(string.charAt(counter));
//                counter++;
//            }
//            if (builder.length() > 0) {
//                words.add(builder.toString());
//                // ["AlgoExpert", " ", "is", " ", "the", "      ", "best!"]
//            }
//            builder.setLength(0);
//            // take care of spaces
//            while (counter < string.length() && string.charAt(counter) == ' ') {
//                builder.append(string.charAt(counter));
//                counter++;
//            }
//            if (builder.length() > 0) {
//                words.add(builder.toString());
//            }
//            builder.setLength(0);
//            System.out.println();
//        }
//        int index = words.size() - 1;
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < words.size(); i++) {
//            result.append(words.get(index));
//            index--;
//        }
//        return result.toString();
//    }
}
