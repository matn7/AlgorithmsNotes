package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";

        longestCommonSubsequence(str1, str2);
    }

    // O(nm) time | O(nm) space
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        String[][] lcs = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            for (int j = 0; j < str2.length() + 1; j++) {
                lcs[i][j] = "";
            }
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                char curr1 = str1.charAt(i - 1);
                char curr2 = str2.charAt(j - 1);
                if (curr1 == curr2) {
                    String diag = lcs[i - 1][j - 1];
                    String res = diag + curr1;
                    lcs[i][j] = res;
                } else {
                    if (lcs[i][j - 1].length() > lcs[i - 1][j].length()) {
                        lcs[i][j] = lcs[i][j - 1];
                    } else {
                        lcs[i][j] = lcs[i - 1][j];
                    }
                }
            }
        }

        String longest = lcs[str1.length()][str2.length()];
        List<Character> result = new ArrayList<>();
        for (Character element : longest.toCharArray()) {
            result.add(element);
        }

        return result;
    }

}
