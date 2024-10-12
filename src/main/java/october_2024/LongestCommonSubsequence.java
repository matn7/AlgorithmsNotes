package october_2024;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        int result = lcs.longestCommonSubsequence(text1, text2);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public int longestCommonSubsequence(String text1, String text2) {
        if (text2.length() > text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        int[][] lcs = new int[text2.length() + 1][text1.length() + 1];
        for (int i = 0; i < lcs.length; i++) {
            lcs[i][0] = 0;
        }
        Arrays.fill(lcs[0], 0);

        for (int row = 1; row <= text2.length(); row++) {
            for (int col = 1; col <= text1.length(); col++) {
                if (text2.charAt(row - 1) == text1.charAt(col - 1)) {
                    lcs[row][col] = lcs[row - 1][col - 1] + 1;
                } else {
                    int leftLen = lcs[row][col - 1];
                    int upLen = lcs[row - 1][col];
                    if (leftLen > upLen) {
                        lcs[row][col] = lcs[row][col - 1];
                    } else {
                        lcs[row][col] = lcs[row - 1][col];
                    }
                }
            }
        }
        return lcs[text2.length()][text1.length()];
    }


    // O(n*m) time | O(n*m) space
    public int longestCommonSubsequence2(String text1, String text2) {
        if (text2.length() > text1.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }

        String[][] lcs = new String[text2.length() + 1][text1.length() + 1];
        for (int i = 0; i < lcs.length; i++) {
            lcs[i][0] = "";
        }
        for (int i = 0; i < lcs[0].length; i++) {
            lcs[0][i] = "";
        }

        for (int row = 1; row <= text2.length(); row++) {
            for (int col = 1; col <= text1.length(); col++) {
                if (text2.charAt(row - 1) == text1.charAt(col - 1)) {
                    lcs[row][col] = lcs[row - 1][col - 1] + text2.charAt(row - 1);
                } else {
                    int diagLen = lcs[row - 1][col - 1].length();
                    int leftLen = lcs[row][col - 1].length();
                    int upLen = lcs[row - 1][col].length();
                    if (diagLen > leftLen && diagLen > upLen) {
                        lcs[row][col] = lcs[row - 1][col - 1];
                    } else if (leftLen > diagLen && leftLen > upLen) {
                        lcs[row][col] = lcs[row][col - 1];
                    } else {
                        lcs[row][col] = lcs[row - 1][col];
                    }
                }
            }
        }
        return lcs[text2.length()][text1.length()].length();
    }

}
