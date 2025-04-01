package january_2025;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        int result = palindromicSubstrings.countSubstrings(s);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += isPalindrome(s, i, i);
            res += isPalindrome(s, i, i + 1);
        }

        return res;
    }

    private int isPalindrome(String s, int l, int r) {
        if (l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        int res = 0;
        while (l >= 0 && r <= s.length() - 1) {
            if (s.charAt(l) == s.charAt(r)) {
                res++;
            } else {
                break;
            }
            l--;
            r++;
        }
        return res;
    }

}
