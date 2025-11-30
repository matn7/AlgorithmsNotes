package november_2025;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abc";

        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        int result = palindromicSubstrings.countSubstrings(s);
        System.out.println(result);

    }

    // O(n^2) time | O(1) space
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += countPalindrome(s, i, i);
            res += countPalindrome(s, i, i + 1);
        }
        return res;
    }

    private int countPalindrome(String s, int i, int j) {
        if (i < 0 || j >= s.length() || s.charAt(i) != s.charAt(j)) {
            return 0;
        }
        int res = 0;
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            res++;
            i--;
            j++;
        }
        return res;
    }


}
