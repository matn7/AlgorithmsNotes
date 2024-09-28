package problems.medium;

import java.util.ArrayList;

public class ValidIpAddresses {

    public static void main(String[] args) {
        ValidIpAddresses validIpAddresses = new ValidIpAddresses();

        String string = "1921680";
        validIpAddresses.validIPAddresses(string);
    }

    // O(1) time (does not depend of size of input O(2^32)) | O(1) space
    public ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        ArrayList<String> ipAddressesFound = new ArrayList<>();

        for (int i = 1; i < Math.min(string.length(), 4); i++) {
            String[] currentIpAddressParts = {"","","",""};
            currentIpAddressParts[0] = string.substring(0,i);
            if (!isValidPart(currentIpAddressParts[0])) {
                continue;
            }
            for (int j = i + 1; j < i + Math.min(string.length() - i, 4); j++) {
                currentIpAddressParts[1] = string.substring(i, j);
                if (!isValidPart(currentIpAddressParts[1])) {
                    continue;
                }
                for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                    currentIpAddressParts[2] = string.substring(j, k);
                    currentIpAddressParts[3] = string.substring(k);

                    if (isValidPart(currentIpAddressParts[2]) && isValidPart(currentIpAddressParts[3])) {
                        ipAddressesFound.add(currentIpAddressParts[0] + "." + currentIpAddressParts[1] + "."
                            + currentIpAddressParts[2] + "." + currentIpAddressParts[3]);
                    }
                }
            }
        }

        return ipAddressesFound;
    }

    private boolean isValidPart(String string) {
        if (string.isEmpty()) {
            return false;
        }
        int stringAsInt = Integer.parseInt(string);
        if (stringAsInt > 255) {
            return false;
        }
        // check for leading 0
        return string.length() == String.valueOf(stringAsInt).length();
    }

}
