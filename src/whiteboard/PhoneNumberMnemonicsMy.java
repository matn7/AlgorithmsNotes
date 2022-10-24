package whiteboard;

import java.util.*;

public class PhoneNumberMnemonicsMy {

    static Map<Character, List<Character>> keyPad = new HashMap<>();
    static {
        keyPad.put('1', new ArrayList<>(Arrays.asList('1')));
        keyPad.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        keyPad.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        keyPad.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        keyPad.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        keyPad.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        keyPad.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        keyPad.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        keyPad.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
        keyPad.put('0', new ArrayList<>(Arrays.asList('0')));
    }

    public static void main(String[] args) {
        String phoneNumber = "1905";

        PhoneNumberMnemonicsMy pnm2 = new PhoneNumberMnemonicsMy();
        pnm2.phoneNumberMnemonics(phoneNumber);
    }

    // O(4^n*n) time | O(4^n*n) space
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.
        String[] parts = new String[phoneNumber.length()];
        if (phoneNumber.equals("")) {
            return new ArrayList<String>();
        }
        Arrays.fill(parts, "0");
        ArrayList<String> result = new ArrayList<>();
        phoneNumberMnemonicsHelper(0, phoneNumber, parts, result);
        return result;
    }

    private void phoneNumberMnemonicsHelper(int idx, String phoneNumber, String[] parts, ArrayList<String> result) {
        if (idx == phoneNumber.length()) {
            StringBuilder number = new StringBuilder();
            for (String part : parts) {
                number.append(part);
            }
            result.add(String.valueOf(number));
            return;
        }

        char currentPart = phoneNumber.charAt(idx); // '1'
        List<Character> letters = keyPad.get(currentPart);
        for (Character letter : letters) {
            parts[idx] = String.valueOf(letter);
            phoneNumberMnemonicsHelper(idx + 1, phoneNumber, parts, result);
        }

    }

}
