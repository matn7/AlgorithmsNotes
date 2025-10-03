package september_2025;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        String s = "abc";

        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        int result = palindromicSubstrings.countSubstrings(s);
        System.out.println(result);
    }

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += checkPali(s, i, i);
            count += checkPali(s, i, i + 1);
        }
        return count;
    }

    private int checkPali(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j <= s.length() - 1) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            i--;
            j++;
            count++;
        }
        return count;
    }

}
