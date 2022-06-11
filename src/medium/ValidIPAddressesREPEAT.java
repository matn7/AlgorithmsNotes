package medium;

import java.util.ArrayList;

public class ValidIPAddressesREPEAT {

    // O(1) time (does not depend of size of input O(2^32)) | O(1) space
    // OK - repeated 13/02/2022
    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        ArrayList<String> ipAddressesFound = new ArrayList<>();

        //           0 1 2 3 4 5 6
        // ------------------------
        // string = "1 9 2 1 6 8 0"
        //                 i j k
        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] currentIpAddressParts = {"", "", "", ""};
            currentIpAddressParts[0] = string.substring(0, i); // 192
            
            if (!isValidPart(currentIpAddressParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                currentIpAddressParts[1] = string.substring(i, j); // 168
                if (!isValidPart(currentIpAddressParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    currentIpAddressParts[2] = string.substring(j, k); // 0
                    currentIpAddressParts[3] = string.substring(k, string.length() - 1); // 0

                    if (isValidPart(currentIpAddressParts[2]) && isValidPart(currentIpAddressParts[3])) {
                        ipAddressesFound.add(currentIpAddressParts[0] + "." + currentIpAddressParts[1] + "."
                                + currentIpAddressParts[2] + "." + currentIpAddressParts[3]);
                    }
                }
            }

        }

        return ipAddressesFound; // ["1.9.216.80", "1.92.16.80", "1.92.168.0", "19.2.16.80", "19.2.168.0",
        // "19.21.6.80", "19.21.68.0", "19.216.8.0", "192.1.6.80", "192.1.68.0", "192.16.8.0"]
    }

    private boolean isValidPart(String string) {
        Integer stringAsInt = Integer.valueOf(string);
        if (stringAsInt > 255) {
            return false;
        }
        return string.length() == String.valueOf(stringAsInt).length();
    }
}
