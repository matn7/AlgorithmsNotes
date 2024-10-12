package problems.hard;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
//        String str1 = "ZXVVYZW";
//        String str2 = "XKYKZPW";
        String str1 = "ABCDEFG";
        String str2 = "APPLES";
        longestCommonSubsequence(str1, str2);
    }

    // O(nm * min(n,m)) time | O(nm * min(n,m)) space
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        String[][] lcs = new String[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i <= str2.length(); i++) {
            for (int j = 0; j <= str1.length(); j++) {
                lcs[i][j] = " ";
            }
        }

        for (int row = 1; row <= str2.length(); row++) {
            for (int col = 1; col <= str1.length(); col++) {
                if (str2.charAt(row - 1) == str1.charAt(col - 1)) {
                    lcs[row][col] = lcs[row - 1][col - 1] + str2.charAt(row - 1);
                } else {
                    if (lcs[row-1][col].length() > lcs[row][col-1].length()) {
                        lcs[row][col] = lcs[row-1][col];
                    } else {
                        lcs[row][col] = lcs[row][col-1];
                    }
                }
            }
        }
        String result = lcs[str2.length()][str1.length()].trim();
        List<Character> resultArray = new ArrayList<>();
        for (Character c : result.toCharArray()) {
            resultArray.add(c);
        }
        return resultArray;
    }
}
