package star;

import java.util.*;

public class PhoneNumberMnemonics {

    static Map<Character, List<String>> mnemonicMap = new HashMap<>();

    static {
        mnemonicMap.put('1', new ArrayList<>(Arrays.asList("1")));
        mnemonicMap.put('2', new ArrayList<>(Arrays.asList("a", "b", "c")));
        mnemonicMap.put('3', new ArrayList<>(Arrays.asList("d", "e", "f")));
        mnemonicMap.put('4', new ArrayList<>(Arrays.asList("g", "h", "i")));
        mnemonicMap.put('5', new ArrayList<>(Arrays.asList("j", "k", "l")));
        mnemonicMap.put('6', new ArrayList<>(Arrays.asList("m", "n", "o")));
        mnemonicMap.put('7', new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        mnemonicMap.put('8', new ArrayList<>(Arrays.asList("t", "u", "v")));
        mnemonicMap.put('9', new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
        mnemonicMap.put('0', new ArrayList<>(Arrays.asList("0")));
    }

    public static void main(String[] args) {
        PhoneNumberMnemonics phoneNumberMnemonics = new PhoneNumberMnemonics();
        phoneNumberMnemonics.phoneNumberMnemonics("1905");
    }

    // O(4^n*n) time | O(4^n*n) space
    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        phoneNumberMnemonicsHelper(phoneNumber, "", result);
        return result;
    }

    private void phoneNumberMnemonicsHelper(String phoneNumber, String curr, ArrayList<String> result) {
        if (phoneNumber.isEmpty()) {
            result.add(curr);
        } else {
            Character currentNumber = phoneNumber.charAt(0);
            String newNumber = phoneNumber.substring(1);
            List<String> strings = mnemonicMap.get(currentNumber);
            for (String str : strings) {
                String builder = curr + str;
                phoneNumberMnemonicsHelper(newNumber, builder, result);
            }
        }
    }

}
