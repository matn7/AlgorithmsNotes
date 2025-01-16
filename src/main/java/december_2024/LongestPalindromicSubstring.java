package december_2024;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "bb";

        LongestPalindromicSubstring palindromicSubstring = new LongestPalindromicSubstring();
        String result = palindromicSubstring.longestPalindrome(s);
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        int[] maxRange = new int[] {0, 0};
        for (int i = 0; i < s.length() - 1; i++) {
            int[] odd = palindrome(i, i, s);
            int[] even = palindrome(i, i + 1, s);
            int[] currMax;
            if (even[0] == -1) {
                currMax = odd;
            } else {
                if (odd[1] - odd[0] > even[1] - even[0]) {
                    currMax = odd;
                } else {
                    currMax = even;
                }
            }
            if (currMax[1] - currMax[0] > maxRange[1] - maxRange[0]) {
                maxRange = currMax;
            }
        }

        return s.substring(maxRange[0], maxRange[1]);
    }

    private int[] palindrome(int start, int end, String s) {
        int[] res = new int[] {-1, -1};
        if (s.charAt(start) != s.charAt(end)) {
            return res;
        }

        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) != s.charAt(end)) {
                break;
            }
            start--;
            end++;
        }

        res[0] = start + 1;
        res[1] = end;
        return res;
    }

}
