package august_2024;

import java.util.*;
import java.util.stream.IntStream;

public class PhoneNumberMnemonics {

    public static void main(String[] args) {
        String number = "1905";
        List<String> mnemonics = phoneNumberMnemonics(number);
        System.out.println(mnemonics);

        System.out.println(phoneNumberMnemonicsV2(number));
    }

    static Map<String, List<String>> mnemonicMap = new HashMap<>();

    static {
        mnemonicMap.put("1", new ArrayList<>(Arrays.asList("1")));
        mnemonicMap.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        mnemonicMap.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        mnemonicMap.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        mnemonicMap.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        mnemonicMap.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        mnemonicMap.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        mnemonicMap.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        mnemonicMap.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        mnemonicMap.put("0", new ArrayList<>(Arrays.asList("0")));
    }

    // O(4^n) time | O(n * 4^n) space
    public static List<String> phoneNumberMnemonics(String number) {
        List<String> mnemonics = new ArrayList<>();
        helper(number, 0, number.length(), "", mnemonics);
        return mnemonics;
    }

    private static void helper(String number, int startIdx, int endIdx, String currentWord, List<String> mnemonics) {
        if (startIdx == endIdx) {
            mnemonics.add(currentWord);
        } else {
            String key = String.valueOf(number.charAt(startIdx));
            List<String> strings = mnemonicMap.get(key);
            for (String str : strings) {
                String newCurrentWord = currentWord + str;
                helper(number, startIdx + 1, endIdx, newCurrentWord, mnemonics);
            }
        }
    }

    // O(4^n) time | O(n * 4^n) space
    public static List<String> phoneNumberMnemonicsV2(String number) {
        List<String> mnemonics = new ArrayList<>();
        mnemonics.add(""); // Start with an empty string

        for (char digit : number.toCharArray()) {
            List<String> letters = mnemonicMap.get(String.valueOf(digit));
            List<String> newMnemonics = new ArrayList<>();

            for (String mnemonic : mnemonics) {
                for (String letter : letters) {
                    newMnemonics.add(mnemonic + letter);
                }
            }

            mnemonics = newMnemonics; // Move to the next set of combinations
        }

        return mnemonics;
    }

}
