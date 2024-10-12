package september_2023;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String str1 = "ABCDEFG";
        String str2 = "APPLES";

        longestCommonSubsequence(str1, str2);
    }

    // O(nm) time | O(nm) space
    public static List<Character> longestCommonSubsequence(
            String str1, String str2
    ) {
        // Write your code here.
        //     ''   Z   X   V   V   Y   Z   W
        //  ''  /   /   /   /   /   /   /   /
        //  X   /   /   X   X   X   X   X   X
        //  K   /   /   X   X   X   X   X   X
        //  Y   /   /   X   X   X   XY  XY  XY
        //  K   /   /   X   X   X   XY  XY  XY
        //  Z   /   Z   ZX  ZX  ZX  ZX  XYZ XYZ
        //  P   /
        //  W   /
        //
        // max(left, diag, up)
        // match diag + curr
        if (str1.length() == 0 || str2.length() == 0) {
            return new ArrayList<>();
        }
        String[][] matrix = new String[str2.length() + 1][str1.length() + 1];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[row][col] = " ";
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[row].length; col++) {
                char rowChar = str2.charAt(row - 1);
                char colChar = str1.charAt(col - 1);
                if (rowChar == colChar) {
                    matrix[row][col] = matrix[row - 1][col - 1] + rowChar;
                } else {
                    int leftLength = matrix[row][col - 1].length();
                    int upLength = matrix[row - 1][col].length();
                    if (leftLength > upLength) {
                        matrix[row][col] = matrix[row][col - 1];
                    } else {
                        matrix[row][col] = matrix[row - 1][col];
                    }
                }
            }
        }
        String resultStr = matrix[str2.length()][str1.length()].trim();
        List<Character> characters = new ArrayList<>();
        for (char c : resultStr.toCharArray()) {
            characters.add(c);
        }
        return characters;
    }

}
