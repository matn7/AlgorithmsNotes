package november_2025;

public class PalindromicSubstrings2 {

    public static void main(String[] args) {
        String s = "aaa";
        PalindromicSubstrings2 palindromicSubstrings2 = new PalindromicSubstrings2();
        int result = palindromicSubstrings2.countSubstrings(s);
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
