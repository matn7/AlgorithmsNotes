package july_2024;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "abbba";

        String s = longestPalindrome(str);
        System.out.println(s);
    }

    // O(n^2) time | O(n^2) space
    public static String longestPalindrome(String st) {
        String ans = "";
        int n = st.length();
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int e = 0; e < n; e++) {
            for (int s = 0; s <= e; s++) {
                int middleStringLength = e - s + 1;
                boolean sameChar = st.charAt(s) == st.charAt(e);

                if (sameChar && (middleStringLength <= 1 || isPalindrome[s + 1][e - 1])) {
                    isPalindrome[s][e] = true;
                    if (e - s >= ans.length()) {
                        ans = st.substring(s, e + 1);
                    }
                }
            }
        }

        return ans;

    }

}
