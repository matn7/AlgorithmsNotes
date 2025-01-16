package november_2024;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class IPAddresses {

    public static void main(String[] args) {
        IPAddresses ipAddresses = new IPAddresses();
//        String s = "0279245587303";
        String s = "25525511135";
        List<String> strings = ipAddresses.restoreIpAddresses(s);
        System.out.println(strings);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() > 12) {
            return res;
        }
        backtrack(0, 0, "", s, res);
        return res;
    }

    private void backtrack(int i, int dots, String currIP, String s, List<String> res) {
        if (dots == 4 && i == s.length()) {
            res.add(currIP.substring(0, currIP.length() - 1));
            return;
        }
        if (dots > 4) {
            return;
        }
        for (int j = i; j < Math.min(i + 3, s.length()); j++) {
            if (isValidPart(s.substring(i, j + 1))) {
                backtrack(j + 1, dots + 1, currIP + s.substring(i, j + 1) + ".", s, res);
            }
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() > 12) {
            return result;
        }

        for (int a = 1; a < Math.min(4, s.length()); a++) {
            String aPart = s.substring(0, a);
            if (!isValidPart(aPart)) {
                continue;
            }
            for (int b = a + 1; b < Math.min(a + 4, s.length()); b++) {
                String bPart = s.substring(a, b);
                if (!isValidPart(bPart)) {
                    continue;
                }
                for (int c = b + 1; c < Math.min(b + 4, s.length()); c++) {
                    String cPart = s.substring(b, c);
                    String dPart = s.substring(c);
                    if (isValidPart(cPart) && isValidPart(dPart)) {
                        result.add(aPart + "." + bPart + "." + cPart + "." + dPart);
                    }
                }
            }
        }

        return result;
    }

    private boolean isValidPart(String s) {
        BigInteger integer = new BigInteger(s);

        if (integer.compareTo(BigInteger.ZERO) < 0 || integer.compareTo(new BigInteger("255")) > 0) {
            return false;
        }
        return String.valueOf(integer.toString()).length() == s.length();
    }

}
