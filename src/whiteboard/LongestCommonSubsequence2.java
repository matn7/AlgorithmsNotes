package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence2 {

    public static void main(String[] args) {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";

        longestCommonSubsequence(str1, str2);
    }

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        String[][] lsc = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                lsc[i][j] = "";
            }
        }

        for (int row = 1; row <= str1.length(); row++) {
            for (int col = 1; col <= str2.length(); col++) {
                if (str1.charAt(row-1) == str2.charAt(col - 1)) {
                    lsc[row][col] = lsc[row - 1][col - 1] + str1.charAt(row - 1);
                } else {
                    if (lsc[row - 1][col].length() > lsc[row][col - 1].length()) {
                        lsc[row][col] = lsc[row - 1][col];
                    } else {
                        lsc[row][col] = lsc[row][col - 1];
                    }
                }
            }
        }

        String strRes = lsc[str1.length()][str2.length()];
        List<Character> result = new ArrayList<>();
        for (Character c : strRes.toCharArray()) {
            result.add(c);
        }

        return result;
    }

}
