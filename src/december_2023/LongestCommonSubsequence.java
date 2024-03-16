package december_2023;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        longestCommonSubsequence("ZXVVYZW", "XKYKZPW");
    }

    // O(nm * min(n,m)) time | O(nm * min(n,m)) space
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        String[][] lcs = new String[str2.length() + 1][str1.length() + 1];
        for (int i = 0; i < str2.length() + 1; i++) {
            for (int j = 0; j < str1.length() + 1; j++) {
                lcs[i][j] = "";
            }
        }

        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + str2.charAt(i - 1);
                } else {
                    if (lcs[i - 1][j].length() > lcs[i][j - 1].length()) {
                        lcs[i][j] = lcs[i - 1][j];
                    } else {
                        lcs[i][j] = lcs[i][j - 1];
                    }
                }
            }
        }

        List<Character> result = new ArrayList<>();
        String res = lcs[str2.length()][str1.length()];
        for (char character : res.toCharArray()) {
            result.add(character);
        }
        return result;
    }

}
