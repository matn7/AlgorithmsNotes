package january_2024;

import java.util.*;

public class PhoneNumber {

    static Map<Character, List<String>> keyMap = new HashMap<>();

    static {
        keyMap.put('1', Arrays.asList("1"));
        keyMap.put('2', Arrays.asList("A", "B", "C"));
        keyMap.put('3', Arrays.asList("D", "E", "F"));
        keyMap.put('4', Arrays.asList("G", "H", "I"));
        keyMap.put('5', Arrays.asList("K", "K", "L"));
        keyMap.put('6', Arrays.asList("M", "N", "O"));
        keyMap.put('7', Arrays.asList("P", "Q", "R", "S"));
        keyMap.put('8', Arrays.asList("T", "U", "V"));
        keyMap.put('9', Arrays.asList("W", "X", "Y", "Z"));
        keyMap.put('0', Arrays.asList("0"));

    }

    public static void main(String[] args) {
        String phoneNumber = "364";
        String[] validWords = {"DOG", "CAT", "FISH", "FOG"};

        mnemonics(phoneNumber, validWords);
    }

    // O(4^n) time | O(n) space
    public static List<String> mnemonics(String phoneNumber, String[] validWords) {
        List<String> mnemonics = new ArrayList<>();
        mnemonicsHelper(phoneNumber, 0, phoneNumber.length(), "", mnemonics);

        List<String> result = new ArrayList<>();
        for (String word : validWords) {
            if (mnemonics.contains(word)) {
                result.add(word);
            }
        }
        return result;
    }

    private static void mnemonicsHelper(String phoneNumber, int startIdx, int endIdx, String word, List<String> mnemonics) {
        if (startIdx == endIdx) {
            mnemonics.add(word);
        } else {
            char character = phoneNumber.charAt(startIdx);
            List<String> chars = keyMap.get(character);
            for (String str : chars) {
                String newWord = word + str;
                mnemonicsHelper(phoneNumber, startIdx + 1, endIdx, newWord, mnemonics);
            }
        }
    }

}
