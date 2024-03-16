package september_2023;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String string = "AlgoExpert       is   the best!";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        reverseWordsInString.reverseWordsInString4(string);
    }

    // O(n) time | O(n) space
    public String reverseWordsInString(String string) {
        // Write your code here.
        if (string.length() <= 1) {
            return string;
        }
        Stack<String> stack = new Stack<>();
        int idx = 0;
        StringBuilder builder = new StringBuilder();
        while (idx < string.length()) {
            while (idx < string.length() && string.charAt(idx) != ' ') {
                builder.append(string.charAt(idx));
                idx++;
            }
            if (builder.length() > 0) {
                stack.push(builder.toString());
            }

            builder.setLength(0);
            while (idx < string.length() && string.charAt(idx) == ' ') {
                builder.append(string.charAt(idx));
                idx++;
            }
            if (builder.length() > 0) {
                stack.push(builder.toString());
            }
            builder.setLength(0);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    // O(n) time | O(n) space
    public String reverseWordsInString2(String string) {
        String reversed = reverse(string);
        int idx = 0;
        StringBuilder result = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        while (idx < reversed.length()) {
            while (idx < reversed.length() && reversed.charAt(idx) != ' ') {
                builder.append(reversed.charAt(idx));
                idx++;
            }
            if (builder.length() > 0) {
                result.append(reverse(builder.toString()));
            }
            builder.setLength(0);
            while (idx < reversed.length() && reversed.charAt(idx) == ' ') {
                builder.append(reversed.charAt(idx));
                idx++;
            }
            if (builder.length() > 0) {
                result.append(builder.toString());
            }
            builder.setLength(0);
        }
        return result.toString();
    }

    private String reverse(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    // O(n) time | O(n) space
    public String reverseWordsInString3(String string) {
        Stack<String> words = new Stack<>();
        int startOfWard = 0;
        for (int idx = 0; idx < string.length(); idx++) {
            char character = string.charAt(idx);

            if (character == ' ') {
                words.push(string.substring(startOfWard, idx));
                startOfWard = idx;
            } else if (string.charAt(startOfWard) == ' ') {
                words.push(" ");
                startOfWard = idx;
            }
        }

        words.push(string.substring(startOfWard));
        StringBuilder builder = new StringBuilder();
        while (!words.isEmpty()) {
            builder.append(words.pop());
        }

        return builder.toString();
    }

    // O(n) time | O(n) space
    public String reverseWordsInString4(String string) {
        List<Character> characters = new ArrayList<>();
        for (char c : string.toCharArray()) {
            characters.add(c);
        }
        reverseListRange(characters, 0, characters.size() - 1);
        int startOfWord = 0;
        while (startOfWord < characters.size()) {
            int endOfWord = startOfWord;
            while (endOfWord < characters.size() && characters.get(endOfWord) != ' ') {
                endOfWord++;
            }

            reverseListRange(characters, startOfWord, endOfWord - 1);
            startOfWord = endOfWord + 1;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < characters.size(); i++) {
            builder.append(characters.get(i));
        }
        return builder.toString();
    }

    private void reverseListRange(List<Character> characters, int start, int end) {
        while (start < end) {
            char temp = characters.get(start);
            characters.set(start, characters.get(end));
            characters.set(end, temp);
            start++;
            end--;
        }
    }

}

























