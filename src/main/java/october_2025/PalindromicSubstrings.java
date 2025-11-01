package october_2025;

public class PalindromicSubstrings {

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        String s = "abc";
        int result = palindromicSubstrings.countSubstrings(s);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public int countSubstrings(String s) {
        int count = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            count += checkPali(s, i, i);
            count += checkPali(s, i, i + 1);
        }

        return count;
    }

    private int checkPali(String s, int i, int j) {
        if (s.charAt(i) != s.charAt(j)) {
            return 0;
        }
        int count = 0;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                break;
            }
            count++;
            i--;
            j++;
        }
        return count;
    }


}
