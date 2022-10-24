package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class LongestCommonSubsequenceMy {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        // Write your code here.
        if (str1.isEmpty() || str2.isEmpty()) {
            return new ArrayList<>();
        }

        String[][] sequence = new String[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row < sequence.length; row++) {
            sequence[row][0] = "";
        }
        for (int col = 0; col < sequence[0].length; col++) {
            sequence[0][col] = "";
        }
        for (int row = 1; row < sequence.length; row++) {
            for (int col = 1; col < sequence[row].length; col++) {
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    sequence[row][col] = sequence[row - 1][col - 1] + str1.charAt(row - 1);
                } else {
                    int fromTop = sequence[row - 1][col].length();
                    int fromLeft = sequence[row][col - 1].length();
                    if (fromTop > fromLeft) {
                        sequence[row][col] = sequence[row - 1][col];
                    } else {
                        sequence[row][col] = sequence[row][col - 1];
                    }
                }
            }
        }
        String result = sequence[str1.length()][str2.length()];
        if (result.length() == 0) {
            return new ArrayList<>();
        }
        List<Character> resArr = new ArrayList<>();
        for (int i = 0; i < result.length(); i++) {
            resArr.add(result.charAt(i));
        }
        return resArr;
    }

}
