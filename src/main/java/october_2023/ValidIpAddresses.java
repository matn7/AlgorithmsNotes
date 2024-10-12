package october_2023;

import java.util.ArrayList;
import java.util.List;

public class ValidIpAddresses {

    public static void main(String[] args) {
        String str = "1921680";
        validIPAddresses(str);
    }

    // O(1) time | O(1) space
    public static List<String> validIPAddresses(String str) {
        List<String> result = new ArrayList<>();
        for (int a = 1; a < Math.min(4, str.length()); a++) {
            String partA = str.substring(0, a);
            if (!isValidPart(partA)) {
                continue;
            }
            for (int b = a + 1; b < a + Math.min(4, str.length() - a); b++) {
                String partB = str.substring(a, b);
                if (!isValidPart(partB)) {
                    continue;
                }
                for (int c = b + 1; c < b + Math.min(4, str.length() - b); c++) {
                    String partC = str.substring(b, c);
                    String partD = str.substring(c);
                    if (isValidPart(partC) && isValidPart(partD)) {
                        result.add(partA + "." + partB + "." + partC + "." + partD);
                    }
                }
            }
        }


        return result;
    }

    private static boolean isValidPart(String part) {
        int partValue = Integer.parseInt(part);
        if (partValue > 255 || partValue < 0) {
            return false;
        }
        return String.valueOf(partValue).length() == part.length();
    }

}
