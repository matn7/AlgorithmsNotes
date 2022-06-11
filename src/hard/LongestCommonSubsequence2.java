package hard;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence2 {

    public static void main(String[] args) {
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";
        //      " "  x  k  y  k   z    p    w
        // " "   #   #  #  #  #   #    #    #
        //  z    #   #  #  #  #   z    z    z
        //  x    #   x  x  x  x   x    x    x
        //  v    #   x  x  x  x   x    x    x
        //  v    #   x  x  x  x   x    x    x
        //  y    #   x  x xy xy  xy   xy   xy
        //  z    #   x  x xy xy xyz  xyz  xyz
        //  w    #   x  x xy xy xyz  xyz xyzw

        longestCommonSubsequence(str1, str2);
    }

    // O(nm * min(n,m)) time | O(nm * min(n,m)) space
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.

        String[][] lcs = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                lcs[i][j] = " ";
            }
        }


        for (int row = 1; row <= str1.length(); row++) {
            for (int col = 1; col <= str2.length(); col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    lcs[row][col] = lcs[row - 1][col - 1] + str1.charAt(row - 1);
                } else {
                    if (lcs[row-1][col].length() > lcs[row][col-1].length()) {
                        lcs[row][col] = lcs[row-1][col];
                    } else {
                        lcs[row][col] = lcs[row][col-1];
                    }
                }
            }
        }
        String result = lcs[str1.length()][str2.length()].trim();
        List<Character> resultArray = new ArrayList<>();
        for (Character c : result.toCharArray()) {
            resultArray.add(c);
        }
        return resultArray;
    }

}
