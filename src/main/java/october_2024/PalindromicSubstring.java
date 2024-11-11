package october_2024;

import java.util.ArrayList;
import java.util.List;

public class PalindromicSubstring {

    public static void main(String[] args) {
        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        int result = palindromicSubstring.countSubstrings("abc");
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public int countSubstrings(String s) {
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            res += countPali(s, l, r);
            l = i;
            r = i + 1;
            res += countPali(s, l, r);
        }

        return res;
    }

    private int countPali(String s, int l, int r) {
        int res = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }
        return res;
    }




}
