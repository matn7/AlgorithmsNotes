package medium;

public class LevenshteinDistance {

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";

        int result = levenshteinDistance(str1, str2);
        System.out.println(result);
    }

    // O(NM) time | O(NM) space
    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.

        int[][] E = new int[str1.length() + 1][str2.length() + 1];
        E[0][0] = 0;
        for (int row = 1; row <= str1.length(); row++) {
            E[row][0] = row;
        }
        for (int col = 1; col <= str2.length(); col++) {
            E[0][col] = col;
        }

        //      " " y  a  b  d
        // " "   0  1  2  3  4   to build either of this substring from " " -> y = " " + y
        //  a    1  1  1  2  3
        //  b    2  2  2  1  2
        //  c    3  3  3  2  2
        for (int row = 1; row <= str1.length(); row++) {
            for (int col = 1; col <= str2.length(); col++) {
                if (str1.charAt(row-1) == str2.charAt(col-1)) {
                    E[row][col] = E[row - 1][col - 1];
                } else {
                    E[row][col] = 1 + Math.min(
                            Math.min(E[row][col - 1], E[row - 1][col]), E[row - 1][col - 1]);
                }
            }
        }
        return E[str1.length()][str2.length()];
    }

    // // O(NM) time | O(min(N,M)) space    BETTER complexity
}
