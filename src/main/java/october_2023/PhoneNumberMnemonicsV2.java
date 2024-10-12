package october_2023;

import java.util.*;

public class PhoneNumberMnemonicsV2 {

    static Map<Character, List<String>> keyMap = new HashMap<>();

    static {
        keyMap.put('0', Arrays.asList("0"));
        keyMap.put('1', Arrays.asList("1"));
        keyMap.put('2', Arrays.asList("A", "B", "C"));
        keyMap.put('3', Arrays.asList("D", "E", "F"));
        keyMap.put('4', Arrays.asList("G", "H", "I"));
        keyMap.put('5', Arrays.asList("J", "K", "L"));
        keyMap.put('6', Arrays.asList("M", "N", "O"));
        keyMap.put('7', Arrays.asList("P", "Q", "R", "S"));
        keyMap.put('8', Arrays.asList("T", "U", "V"));
        keyMap.put('9', Arrays.asList("W", "Z", "Y", "Z"));
    }

    public static void main(String[] args) {
        String phoneNumber = "1905";
        mnemonics(phoneNumber);
    }

    // O(4^n*n) time | O(4^n*n) space
    public static List<String> mnemonics(String phoneNumber) {
        List<String> result = new ArrayList<>();
        mnemonicsHelper(phoneNumber, "", 0, phoneNumber.length(), result);
        return result;
    }

    private static void mnemonicsHelper(String phoneNumber, String mnemonic, int startIdx, int endIdx,
                                        List<String> result) {
        if (startIdx == endIdx) {
            result.add(mnemonic);
        } else {
            char number = phoneNumber.charAt(startIdx);
            List<String> keyChars = keyMap.get(number);
            for (String key : keyChars) {
                String newMnemonic = mnemonic + key;
                mnemonicsHelper(phoneNumber, newMnemonic, startIdx + 1, endIdx, result);
            }
        }

    }

}
