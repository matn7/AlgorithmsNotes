package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LevensteinDistance {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "yabd";

        int result = levenshteinDistance2(str1, str2);
        System.out.println(result);

    }

    // O(n*m) time | O(min(n,m)) space
    public static int levenshteinDistance(String str1, String str2) {
        String small = str1.length() < str2.length() ? str1 : str2; // abc
        String big = str1.length() >= str2.length() ? str1 : str2; // yabd
        List<Integer> evenEdits = new ArrayList<>();
        for (int i = 0; i < small.length() + 1; i++) {
            evenEdits.add(i); // [0,1,2,3]
        }
        List<Integer> oddEdits = new ArrayList<>();
        for (int i = 0; i < small.length() + 1; i++) {
            oddEdits.add(null); // [null, null, null, null]
        }
        List<Integer> currentEdits = new ArrayList<>();
        List<Integer> previousEdits = new ArrayList<>();
        for (int i = 1; i < big.length() + 1; i++) {
            if (i % 2 == 1) {
                currentEdits = oddEdits;
                previousEdits= evenEdits;
            } else {
                currentEdits = evenEdits; // [2, 1, 2, 3]
                previousEdits = oddEdits; // [1, 1, 2, 3]
            }
            currentEdits.set(0, i);
            // yabd     abc
            //   *      *
            for (int j = 1; j < small.length() + 1; j++) { // i = 2, j = 3
                if (big.charAt(i - 1) == small.charAt(j - 1)) { //a == c
                    currentEdits.set(j, previousEdits.get(j - 1));
                } else {
                    int min = Math.min(previousEdits.get(j - 1),
                            Math.min(previousEdits.get(j), currentEdits.get(j - 1))); // min(2, 3, 2) = 2
                    currentEdits.set(j, 1 + min);
                }
            }
        }
        if (big.length() % 2 == 0) {
            return evenEdits.get(evenEdits.size() - 1);
        }
        return oddEdits.get(oddEdits.size() - 1);
    }

    // O(n*m) time | O(n*m) space
    public static int levenshteinDistance2(String str1, String str2) {
        // Write your code here.
        // str1 = "abc"
        // str2 = "yabd"

        //      " "  y  a  b  d
        //  " "  0   1  2  3  4
        //   a   1   1  1  2  3
        //   b   2   2  2  1  2
        //   c   3   3  3  2  2

        // if str1[r-1] == str2[c-1]: E[r][c] = E[r-1][c-1]
        // else: E[r][c] = 1 + min(E[r][c-1], E[r-1][c], E[r-1][c-1])
        int[][] edits = new int[str1.length() + 1][str2.length() + 1];
        for (int row = 0; row < str1.length() + 1; row++) {
            edits[row][0] = row;
        }
        for (int col = 0; col < str2.length() + 1; col++) {
            edits[0][col] = col;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1],
                      Math.min(edits[i][j - 1], edits[i - 1][j]));
                }
            }
        }

        return edits[str1.length()][str2.length()];
    }

}
