package june_2025;

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
            res += countPali(s, i, i);
            res += countPali(s, i, i + 1);
        }

        return res;
    }

    private int countPali(String s, int i, int j) {
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
