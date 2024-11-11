package october_2024;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SplittingAString {

    public static void main(String[] args) {
//        String s = "0090089";
        String s = "3130";
        SplittingAString splittingAString = new SplittingAString();
        splittingAString.splitString(s);
    }

    // leetcode 1849

    // O(n*2^n) time | O(n) space
    public boolean splitString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            BigInteger val = new BigInteger((s.substring(0, i + 1)));
            if (dfs(i + 1, val, s)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int index, BigInteger prev, String s) {
        if (index == s.length()) {
            return true;
        }
        for (int j = index; j < s.length(); j++) {
            BigInteger val = new BigInteger(s.substring(index, j + 1));
            if (val.add(BigInteger.ONE).equals(prev) && dfs(j + 1, val, s)) {
                return true;
            }
        }
        return false;
    }

}
