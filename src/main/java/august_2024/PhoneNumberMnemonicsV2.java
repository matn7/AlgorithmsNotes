package august_2024;

import java.util.*;

public class PhoneNumberMnemonicsV2 {

    static Map<Character, List<Character>> keyPad = new HashMap<>();

    static {
        keyPad.put('1', Arrays.asList('1'));
        keyPad.put('2', Arrays.asList('a', 'b', 'c'));
        keyPad.put('3', Arrays.asList('d', 'e', 'f'));
        keyPad.put('4', Arrays.asList('g', 'h', 'i'));
        keyPad.put('5', Arrays.asList('j', 'k', 'l'));
        keyPad.put('6', Arrays.asList('m', 'n', 'o'));
        keyPad.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyPad.put('8', Arrays.asList('t', 'u', 'v'));
        keyPad.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        keyPad.put('0', Arrays.asList('0'));
    }

    public static void main(String[] args) {
        String number = "1905";

        List<String> strings = phoneNumberMnemonics(number);
        System.out.println(strings);
    }

    // O(4^n) time | O(4^n) space
    public static List<String> phoneNumberMnemonics(String number) {
        if (number.length() == 0) {
            return null;
        }
        List<String> mnemonics = new ArrayList<>();
        getMnemonics(number, 0, number.length(), "", mnemonics);
        return mnemonics;
    }

    private static void getMnemonics(String number, int startIdx, int endIdx, String curr, List<String> mnemonics) {
        if (startIdx == endIdx) {
            mnemonics.add(curr);
        } else {
            char currChar = number.charAt(startIdx);
            List<Character> characters = keyPad.get(currChar);
            for (Character c : characters) {
                String newCurr = curr + c;
                getMnemonics(number, startIdx + 1, endIdx, newCurr, mnemonics);
            }
        }
    }

}


















