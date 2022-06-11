package hard;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequenceREPEAT {

//    public static List<Character> longestCommonSubsequence(String str1, String str2) {
//        List<List<String[]>> lcs = new ArrayList<>();
//        for (int i = 0; i <= str2.length(); i++) {
//            lcs.add(new ArrayList<>());
//            for (int j = 0; j <= str1.length(); j++) {
//                lcs.get(i).add(new String[]{null, "0", null, null});
//            }
//        }

//        for (int i = 1; i < str2.length() + 1; i++) {
//            for (int j = 1; j < str1.length() + 1; j++) {
//                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
//                    String[] element = {String.valueOf(str2.charAt(i - 1)),
//                            lcs.get(i - 1).get(j - 1)[1] + 1, String.valueOf(i - 1), String.valueOf(j - 1)};
//                    lcs.set(i, lcs.get(i).set(j, List.of(element)));
//                }
//            }
//        }
//    }

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
    // OK - repeated 29/01/2022
    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.

        // (ZXVVYZW, XKYKZPW)
        String[][] lcs = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                lcs[i][j] = " ";
            }
        }
        //       0  1  2   3   4    5    6     7
        //      " " x  k   y   k    z    p     w
        // 0 ""  #  #  #   #   #    #    #     #
        // 1  z  #  #  #   #   #    z    z     z
        // 2  x  #  x  x   x   x    x    x     x
        // 3  v  #  x  x   x   x    x    x     x
        // 4  v  #  x  x   x   x    x    x     x
        // 5  y  #  x  x  xy  xy   xy   xy    xy
        // 6  z  #  x  x  xy  xy  xyz  xyz   xyz
        // 7  w  #  x  x  xy  xy  xyz  xyz  xyzw
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
        String result = lcs[str1.length()][str2.length()].trim(); // xyzw
        List<Character> resultArray = new ArrayList<>();
        for (Character c : result.toCharArray()) {
            resultArray.add(c);
        }
        return resultArray; // [x, y, z, w]
    }

}
