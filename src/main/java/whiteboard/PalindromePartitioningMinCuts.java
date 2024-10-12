package whiteboard;

public class PalindromePartitioningMinCuts {

    // O(n^3) time | O(n^2) space
    // rand: 25/08/2022
    public static int palindromePartitioningMinCuts(String str) {
        // Write your code here.
        boolean[][] palindromes = new boolean[str.length()][str.length()];
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                palindromes[i][j] = isPalindrome(str.substring(i, j + 1));
            }
        }
        int[] cuts = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            cuts[i] = Integer.MIN_VALUE;
        }
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

    private static boolean isPalindrome(String string) {
        int left = 0;
        int right = string.length() - 1;
        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
