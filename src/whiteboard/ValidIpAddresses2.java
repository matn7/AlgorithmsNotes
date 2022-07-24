package whiteboard;

import java.util.ArrayList;

public class ValidIpAddresses2 {

    // O(1) time (does not depend of size of input O(2^32)) | O(1) space
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

}
