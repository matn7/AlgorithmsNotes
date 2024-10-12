package october_2023;

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
        String[] listOfWords = {"DOG", "CAT", "FISH", "FOG"};

        String number = "364";

        phoneNumberMnemonic(number, listOfWords);
    }

    // O(k^n) time | O(k^n) space - k num of digits in number
    public static List<String> phoneNumberMnemonic(String number, String[] listOfWords) {
        List<String> result = new ArrayList<>();

        List<String> mnemonics = new ArrayList<>();
        generateMnemonic(number, "", 0, number.length(), mnemonics);

        for (String word : listOfWords) {
            if (mnemonics.contains(word)) {
                result.add(word);
            }
        }

        return result;
    }

    private static void generateMnemonic(String number, String mnemo, int startIdx, int endIdx, List<String> mnemonics) {
        if (startIdx == endIdx) {
            mnemonics.add(mnemo);
        } else {
            char curr = number.charAt(startIdx);
            List<String> strings = keyMap.get(curr);
            for (String s : strings) {
                String newMnemo = mnemo + s;
                generateMnemonic(number, newMnemo, startIdx + 1, endIdx, mnemonics);
            }
        }
    }

}
