package veryhard;

import java.util.Arrays;

public class PalindromePartitioningMinCutsREPEAT {

    public static void main(String[] args) {
        String string = "noonabbad";
        palindromePartitioningMinCuts(string);
    }

    // O(n^2) time | O(n^2) space
    public static int palindromePartitioningMinCuts(String str) {
        // Write your code here.
        //        0  1  2  3  4  5  6  7  8
        // str = [n, o, o, n, a, b, b, a, d]
        boolean[][] palindromes = new boolean[str.length()][str.length()];
        //        0  1  2  3  4  5  6  7  8
        //        i
        //       [t, t, t, t, t, t, t, t, t],   0
        //       [t, t, t, t, t, t, t, t, t],   1
        //       [t, t, t, t, t, t, t, t, t],   2  length
        //       [t, t, t, t, t, t, t, t, t],   3
        //       [t, t, t, t, t, t, t, t, t],   4
        //       [t, t, t, t, t, t, t, t, t],   5
        //       [t, t, t, t, t, t, t, t, t],   6
        //       [t, t, t, t, t, t, t, t, t],   7
        //       [t, t, t, t, t, t, t, t, t],   8
        for (int i = 0; i < str.length(); i++) {
            palindromes[i][i] = true;
        }
        for (int length = 2; length < str.length() + 1; length++) {
            for (int i = 0; i < str.length() - length + 1; i++) {
                int j = i + length - 1; // 0 + 2 - 1 = 1
                if (length == 2) {
                    palindromes[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    palindromes[i][j] = str.charAt(i) == str.charAt(j) && palindromes[i + 1][j - 1];
                }
            }
        }
        int[] cuts = new int[str.length()];
        Arrays.fill(cuts, 99999);
        for (int i = 0; i < str.length(); i++) {
            if (palindromes[0][i]) {
                cuts[i] = 0;
            } else {
                cuts[i] = cuts[i - 1] + 1;
                for (int j = 1; j < i; j++) {
                    if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
                        cuts[i] = cuts[j - 1] + 1;
                    }
                }
            }
        }
        return cuts[str.length() - 1];
    }

//    // OK - repeated 21/02/2022
//    // O(n^3) time | O(n^2) space
//    public static int palindromePartitioningMinCuts(String str) {
//        // Write your code here.
//        boolean[][] palindromes = new boolean[str.length()][str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i; j < str.length(); j++) {
//                palindromes[i][j] = isPalindrome(str.substring(i, j + 1));
//            }
//        }
//        //        0  1  2  3  4  5  6  7  8
//        //                             i  j
//        // str = [n, o, o, n, a, b, b, a, d]
//        int[] cuts = new int[str.length()];
//        Arrays.fill(cuts, Integer.MIN_VALUE);
//        //
//        //         0  1  2  3  4  5  6  7  8
//        // cuts = [0, 1, 1, 0, 1, 2, 2, 1, 2]
//        //        0  1  2  3  4  5  6  7  8
//        //                                i
//        //       [T, f, f, T, f, f, f, f, f],   0 *
//        //       [f, T, T, f, f, f, f, f, f],   1 j
//        //       [f, f, T, f, f, f, f, f, f],   2
//        //       [f, f, f, T, f, f, f, f, f],   3
//        //       [f, f, f, f, T, f, f, T, f],   4
//        //       [f, f, f, f, f, T, T, f, f],   5
//        //       [f, f, f, f, f, f, T, f, f],   6
//        //       [f, f, f, f, f, f, f, T, f],   7
//        //       [f, f, f, f, f, f, f, f, T],   8
//        for (int i = 0; i < str.length(); i++) {
//            if (palindromes[0][i]) {
//                cuts[i] = 0;
//            } else {
//                cuts[i] = cuts[i - 1] + 1; // 1 + 1 = 2
//                for (int j = 1; j < i; j++) {
//                    if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
//                        cuts[i] = cuts[j - 1] + 1;
//                    }
//                }
//            }
//            System.out.println();
//        }
//        return cuts[str.length() - 1];
//    }
//
//    private static boolean isPalindrome(String string) {
//        int leftIdx = 0;
//        int rightIdx = string.length() - 1;
//        while (leftIdx < rightIdx) {
//            if (string.charAt(leftIdx) != string.charAt(rightIdx)) {
//                return false;
//            }
//            leftIdx++;
//            rightIdx--;
//        }
//        return true;
//    }

}
