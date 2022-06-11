package medium;

import java.util.*;

public class PhoneNumberMnemonics {

    public static void main(String[] args) {
        PhoneNumberMnemonics phoneNumberMnemonics = new PhoneNumberMnemonics();
        phoneNumberMnemonics.phoneNumberMnemonics("1905");
    }

    static Map<Integer, List<String>> keyPad = new HashMap<>();
    static {
        keyPad.put(1, new ArrayList<>(Arrays.asList("1")));
        keyPad.put(2, new ArrayList<>(Arrays.asList("a", "b", "c")));
        keyPad.put(3, new ArrayList<>(Arrays.asList("d", "e", "f")));
        keyPad.put(4, new ArrayList<>(Arrays.asList("g", "h", "i")));
        keyPad.put(5, new ArrayList<>(Arrays.asList("j", "k", "l")));
        keyPad.put(6, new ArrayList<>(Arrays.asList("m", "n", "o")));
        keyPad.put(7, new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        keyPad.put(8, new ArrayList<>(Arrays.asList("t", "u", "v")));
        keyPad.put(9, new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        keyPad.put(0, new ArrayList<>(Arrays.asList("0")));
    }

    // O(4^n*n) time | O(4^n*n) space
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.
        String[] currentMnemonic = new String[phoneNumber.length()];
        for (int i = 0; i < phoneNumber.length(); i++) {
            currentMnemonic[i] = "0";
        }

        ArrayList<String> mnemonicsFound = new ArrayList<>();

        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);

        return mnemonicsFound;
    }

    private void phoneNumberMnemonicsHelper(int idx, String phoneNumber,
                                            String[] currentMnemonic, ArrayList<String> mnemonicsFound) {
        if (idx == phoneNumber.length()) {
            StringBuilder sb = new StringBuilder();
            // O(n)
            for (String element : currentMnemonic) {
                sb.append(element);
            }
            mnemonicsFound.add(sb.toString());
        } else {
            Integer digit = Integer.valueOf(String.valueOf(phoneNumber.charAt(idx)));
            List<String> letters = keyPad.get(digit); //
            for (String letter : letters) {
                currentMnemonic[idx] = letter;
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsFound);
            }
        }
    }


}
