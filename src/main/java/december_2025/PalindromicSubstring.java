package december_2025;

public class PalindromicSubstring {

    public static void main(String[] args) {
        String s = "aaa";

        PalindromicSubstring palindromicSubstring = new PalindromicSubstring();
        int result = palindromicSubstring.countSubstrings(s);
        System.out.println(result);

    }

    // O(n^2) time | O(1) space
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += checkPali(s, i, i);
            count += checkPali(s, i, i + 1);
        }

        return count;
    }

    private int checkPali(String s, int i, int j) {
        int res = 0;
        while (i >= 0 && j <= s.length() - 1 && s.charAt(i) == s.charAt(j)) {
            res++;
            i--;
            j++;
        }
        return res;
    }


}
