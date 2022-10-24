package medium;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {

        String str = "abaxyzzyxf";

        String result = longestPalindromicSubstring(str);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    // OK - repeated 10/02/2022
    public static String longestPalindromicSubstring(String string) {
        // Write your code here.
        int[] currentLongest = new int[] {0, 1};

        // 0 1 2 3 4 5 6 7 8 9
        // a b a x y z z y x f
        //                   *
        for (int i = 1; i < string.length(); i++) { // 8
            int[] odd = getLongestPalindromeFrom(string, i - 1, i + 1); // [8,9]
            int[] even = getLongestPalindromeFrom(string, i - 1, i); // [8,8]
            int[] longest = new int[2];

            if (odd[1] - odd[0] > even[1] - even[0]) {
                longest = odd; // [8, 9]
            } else {
                longest = even; // [3, 9]
            }

            if (longest[1] - longest[0] > currentLongest[1] - currentLongest[0]) { // 9 - 3 > 3 - 0
                currentLongest = longest; // [3, 9]
            }
        }

        return string.substring(currentLongest[0], currentLongest[1]); // substring(3,9) = "x y z z y x"
    }

    // rec("abaxyzzyxf", 7, 8)
    // 0 1 2 3 4 5 6 7 8 9
    // a b a x y z z y x f
    //               l r
    private static int[] getLongestPalindromeFrom(String string, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < string.length()) {
            if (string.charAt(leftIdx) != string.charAt(rightIdx)) { // a != f
                break;
            }
            leftIdx--; // -1
            rightIdx++; // 3
        }
        return new int[] {leftIdx + 1, rightIdx}; // [8, 8]
    }

}
