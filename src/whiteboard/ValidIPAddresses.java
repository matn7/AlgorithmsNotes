package whiteboard;

import java.util.ArrayList;

public class ValidIPAddresses {

    public static void main(String[] args) {
        ValidIPAddresses valid = new ValidIPAddresses();
        String string = "1921680";
        valid.validIPAddresses(string);
    }

    // O(1) time | O(1) space
    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        ArrayList<String> result = new ArrayList<>();
        for (int i = 1; i < string.length(); i++) {
            String A = string.substring(0, i);
            for (int j = i + 1; j < string.length(); j++) {
                String B = string.substring(i, j);
                for (int k = j + 1; k < string.length(); k++) {
                    String C = string.substring(j, k);
                    String D = string.substring(k);
                    if (isValidPart(A) && isValidPart(B) && isValidPart(C) && isValidPart(D)) {
                        String curr = A + "." + B + "." + C + "." + D;
                        result.add(curr);
                    }
                }
            }
        }
        return result;
    }


    private boolean isValidPart(String string) {
        Integer stringAsInt = Integer.valueOf(string);
        if (stringAsInt > 255) {
            return false;
        }
        return string.length() == String.valueOf(stringAsInt).length();
    }

}
