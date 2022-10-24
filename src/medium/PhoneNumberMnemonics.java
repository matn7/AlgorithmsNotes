package medium;

import java.util.*;

public class PhoneNumberMnemonics {

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

    // O(4^n * n) time | O(4^n * n) space
    // OK - repeated 13/02/2022
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.
        ArrayList<String> currentMnemonic = new ArrayList<>();
        for (int i = 0; i < phoneNumber.length(); i++) {
            currentMnemonic.add("0");
        }
        // [0, 0, 0, 0]
        ArrayList<String> mnemonicsFound = new ArrayList<>();

        phoneNumberMnemonicsHelper(0, phoneNumber, currentMnemonic, mnemonicsFound);
        return mnemonicsFound;
    }

    private void phoneNumberMnemonicsHelper(int idx, String phoneNumber, ArrayList<String> currentMnemonic,
                                            ArrayList<String> mnemonicsFound) {
        if (idx == phoneNumber.length()) {
            StringBuilder sb = new StringBuilder();
            for (String element : currentMnemonic) {
                sb.append(element);
            }
            mnemonicsFound.add(sb.toString());
            // ["1w0j","1w0k", "1w0l", "1x0j", "1x0k", "1x0l", "1y0j", "1y0k", "1y0l", "1z0j", "1z0k", "1z0l"]
        } else {
            Integer digit = Integer.valueOf(String.valueOf(phoneNumber.charAt(idx))); // 5
            List<String> letters = keyPad.get(digit); // [w, x, y, z] | [j, k, l]
            for (String letter : letters) {
                currentMnemonic.set(idx, letter); // [1, w, 0, j]
                phoneNumberMnemonicsHelper(idx + 1, phoneNumber, currentMnemonic, mnemonicsFound);
            }
        }
    }

}
