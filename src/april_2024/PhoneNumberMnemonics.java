package april_2024;

import java.util.*;

public class PhoneNumberMnemonics {

    static Map<Character, List<String>> keyMap = new HashMap<>();

    static {
        keyMap.put('1', Arrays.asList("1"));
        keyMap.put('2', Arrays.asList("A", "B", "C"));
        keyMap.put('3', Arrays.asList("D", "E", "F"));
        keyMap.put('4', Arrays.asList("G", "H", "I"));
        keyMap.put('5', Arrays.asList("J", "K", "L"));
        keyMap.put('6', Arrays.asList("M", "N", "O"));
        keyMap.put('7', Arrays.asList("P", "Q", "R", "S"));
        keyMap.put('8', Arrays.asList("T", "U", "V"));
        keyMap.put('9', Arrays.asList("W", "X", "Y", "Z"));
        keyMap.put('0', Arrays.asList("0"));
    }

    public static void main(String[] args) {
        String input = "23";

        List<String> mnemonics = mnemonics(input);
        System.out.println(mnemonics);

    }

    // O(4^n) time | O(4^n) space
    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> digitToString = new HashMap<>();
        digitToString.put('2', "abc");
        digitToString.put('3', "def");
        digitToString.put('4', "ghi");
        digitToString.put('5', "jkl");
        digitToString.put('6', "mno");
        digitToString.put('7', "pqrs");
        digitToString.put('8', "tuv");
        digitToString.put('9', "wxyz");
        List<String> ans = new ArrayList<>();
        solution(digits, digitToString, "", ans, 0);
        return ans;
    }

    private static void solution(String digits, Map<Character, String> digitToString, String curr, List<String> ans, int digitIndex) {
        if (curr.length() == digits.length()) {
            ans.add(curr);
            return;
        }
        char currentDigit = digits.charAt(digitIndex);
        String currentString = digitToString.get(currentDigit);

        for (int i = 0; i < currentString.length(); i++) {
            char ch = currentString.charAt(i);
            solution(digits, digitToString, curr + ch, ans, digitIndex + 1);
        }
    }

    // O(4^n*n) time | O(4^n*n) space
    public static List<String> mnemonics(String input) {
        List<String> result = new ArrayList<>();
        mnemonicsHelper(input, 0, input.length(), "", result);
        return result;
    }

    private static void mnemonicsHelper(String input, int start, int end, String currWord, List<String> result) {
        if (start == end) {
            result.add(currWord);
        } else {
            char currChar = input.charAt(start);
            List<String> chars = keyMap.get(currChar);
            for (String c : chars) {
                String newWord = currWord + c;
                mnemonicsHelper(input, start + 1, end, newWord, result);
            }
        }
    }


}
