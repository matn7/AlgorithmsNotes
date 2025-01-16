package december_2024;

public class PalindromicSubstring {

    public static void main(String[] args) {
        String s = "aaa";

        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        int result = palindromicSubstring.countSubstrings(s);
        System.out.println(result);

    }

    // O(n^2) time | O(1) space
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            res += palindrome(l, r, s);
            l = i;
            r = i + 1;
            res += palindrome(l, r, s);
        }
        return res;
    }

    private int palindrome(int l, int r, String s) {
        int res = 0;
        while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
        return res;
    }
}
