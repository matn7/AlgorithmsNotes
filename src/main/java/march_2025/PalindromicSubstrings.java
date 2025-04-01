package march_2025;

public class PalindromicSubstrings {

    public static void main(String[] args) {
//        String s = "abc";
        String s = "aaa";

        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        int result = palindromicSubstrings.countSubstrings(s);
        System.out.println(result);
    }

    // O(n^2) time | O(1) space
    public int countSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            int j = i;
            int k = i;

            while (j >= 0 && k <= s.length() - 1 && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                count++;
            }

            j = i;
            k = i + 1;
            while (j >= 0 && k <= s.length() - 1 && s.charAt(j) == s.charAt(k)) {
                j--;
                k++;
                count++;
            }
        }

        return count;
    }

}
