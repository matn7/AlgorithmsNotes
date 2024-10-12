package may_2024;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "babxyzbzyxb";

        String result = longestPalindrome(str);
        System.out.println(result);
    }

    // O(n^2) time | O(n) space
    public static String longestPalindrome(String str) {

        if (str.length() <= 1) {
            return str;
        }

        int[] longest = new int[] {0, 0};

        for (int i = 0; i < str.length() - 1; i++) {
            int[] even = findPalindrome(str, i, i);
            int[] odd = findPalindrome(str, i, i + 1);
            int[] currLongest;
            if (odd[0] == -1) {
                currLongest = even;
            } else if (even[0] == -1) {
                currLongest = odd;
            } else {
                if (even[1] - even[0] > odd[1] - odd[0]) {
                    currLongest = even;
                } else {
                    currLongest = odd;
                }
            }
            if (currLongest[1] - currLongest[0] > longest[1] - longest[0]) {
                longest[0] = currLongest[0];
                longest[1] = currLongest[1];
            }
        }
        return str.substring(longest[0], longest[1] + 1);
    }

    private static int[] findPalindrome(String str, int left, int right) {
        if (str.charAt(left) != str.charAt(right)) {
            return new int[] {-1, -1};
        }
        int[] result = new int[] {left, right};
        while (left >= 0 && right <= str.length() - 1 && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        result[0] = left + 1;
        result[1] = right - 1;
        return result;
    }


}
