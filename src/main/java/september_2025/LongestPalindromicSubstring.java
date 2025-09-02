package september_2025;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babaxxyzzyxxd";

        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        String result = longestPalindromicSubstring.longestPalindrome(s);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public String longestPalindrome(String s) {
        int[] res = {0, 0};
        for (int i = 0; i < s.length(); i++) {
            int[] odd = checkPali(s, i, i);
            int[] even = checkPali(s, i, i + 1);

            int[] larger;
            if (odd[1] - odd[0] > even[1] - even[0]) {
                larger = odd;
            } else {
                larger = even;
            }

            if (larger[1] - larger[0] > res[1] - res[0]) {
                res = larger;
            }
        }
        return s.substring(res[0], res[1] + 1);
    }

    private int[] checkPali(String s, int i, int j) {

        if (i < 0 || j == s.length() || s.charAt(i) != s.charAt(j)) {
            return new int[] {-1, -1};
        }
        int[] res = {i, j};
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
        }
        res[0] = i + 1;
        res[1] = j - 1;
        return res;
    }

}
