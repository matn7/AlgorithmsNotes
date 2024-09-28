package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {

    public static void main(String[] args) {
        String[] words = {"abc", "cba", "diaper", "repaid", "test"};
        Semordnilap semordnilap = new Semordnilap();
        semordnilap.semordnilap(words);
    }

    // O(n * m) time | O(n * m) space
    public ArrayList<ArrayList<String>> semordnilap(String[] words) {
        // Write your code here.
        Set<String> wordsSet = new HashSet<>(Arrays.asList(words));

        ArrayList<ArrayList<String>> semordnilapPairs = new ArrayList<>();

        for (String word : words) {
//            String reverse = reverseWord(word, 0, word.length() - 1);
            String reverse = reverse(word);
            if (wordsSet.contains(reverse) && !reverse.equals(word)) {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(word);
                newList.add(reverse);
                semordnilapPairs.add(newList);
                wordsSet.remove(word);
                wordsSet.remove(reverse);
            }
        }
        return semordnilapPairs;
    }

    private String reverseWord(String word, int start, int end) {
        char[] chars = word.toCharArray();
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(c);
        }
        return builder.toString();
    }

    public String reverse(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
