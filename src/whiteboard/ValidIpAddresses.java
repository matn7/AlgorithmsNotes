package whiteboard;

import java.util.ArrayList;

public class ValidIpAddresses {

    // O(1) time (does not depend of size of input O(2^32)) | O(1) space
    // #2: 01/07/2022
    // rand: 22/08/2022
    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        for (int a = 1; a < Math.min(string.length(), 4); a++) {
            String aStr = string.substring(0, a);
            for (int b = a + 1; b < a + Math.min(string.length() - a, 4); b++) {
                String bStr = string.substring(a, b);
                for (int c = b + 1; c < b + Math.min(string.length() - b, 4); c++) {
                    String cStr = string.substring(b, c);
                    String dStr = string.substring(c);
                    if (isValidPart(aStr) && isValidPart(bStr) && isValidPart(cStr) && isValidPart(dStr)) {
                        result.add(aStr + "." + bStr + "." + cStr + "." + dStr);
                    }
                }
            }
        }
        return result;
    }

    private boolean isValidPart(String string) {
        Integer strAsInt = Integer.valueOf(string);
        if (strAsInt > 255) {
            return false;
        }
        return string.length() == String.valueOf(strAsInt).length();
    }

    // O(1) time | O(1) space
    public ArrayList<String> validIPAddressesMy(String string) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();

        for (int a = 1; a < Math.min(string.length(), 4); a++) {
            String aNum = string.substring(0, a);
            if (!isValid(aNum)) {
                continue;
            }
            for (int b = a + 1; b <  a + Math.min(string.length() - a, 4); b++) {
                String bNum = string.substring(a, b);
                if (!isValid(bNum)) {
                    continue;
                }
                for (int c = b + 1; c < b + Math.min(string.length() - b, 4); c++) {
                    String cNum = string.substring(b, c);
                    String dNum = string.substring(c);
                    if (isValid(cNum) && isValid(dNum)) {
                        result.add(aNum + "." + bNum + "." + cNum + "." + dNum);
                    }
                }
            }
        }
        return result;
    }


    private boolean isValid(String number) {
        Integer strAsInt = Integer.valueOf(number);
        if (strAsInt > 255) {
            return false;
        }
        return number.length() == String.valueOf(strAsInt).length();
    }

}
