package problems.veryhard;

public class PalindromePartitioningMinCuts {

    public static void main(String[] args) {
        String str = "noonabbad";

        palindromePartitioningMinCuts(str);
    }

    // O(n^2) time | O(n^2) space
    public static int palindromePartitioningMinCuts(String str) {
        // Write your code here.
        boolean[][] palindromes = new boolean[str.length()][str.length()];

        for (int i = 0; i < str.length(); i++) {
            palindromes[i][i] = true;
        }

        for (int length = 2; length < str.length() + 1; length++) {
            for (int i = 0; i < str.length() - length + 1; i++) {
                int j = i + length - 1;
                if (length == 2) {
                    palindromes[i][j] = str.charAt(i) == str.charAt(j);
                } else {
                    palindromes[i][j] = (str.charAt(i) == str.charAt(j) && palindromes[i + 1][j - 1]);
                }
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

//    // O(n^3) time | O(n^2) space
//    public static int palindromePartitioningMinCuts(String str) {
//        // Write your code here.
//        boolean[][] palindromes = new boolean[str.length()][str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            for (int j = i; j < str.length(); j++) {
//                palindromes[i][j] = isPalindroms(str.substring(i, j + 1));
//            }
//        }
//        int[] cuts = new int[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            cuts[i] = Integer.MIN_VALUE;
//        }
//        for (int i = 0; i < str.length(); i++) {
//            if (palindromes[0][i]) {
//                cuts[i] = 0;
//            } else {
//                cuts[i] = cuts[i - 1] + 1;
//                for (int j = 1; j < i; j++) {
//                    if (palindromes[j][i] && cuts[j - 1] + 1 < cuts[i]) {
//                        cuts[i] = cuts[j - 1] + 1;
//                    }
//                }
//            }
//        }
//        return cuts[str.length() - 1];
//    }
//
//    private static boolean isPalindroms(String string) {
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

