package december_2024;

public class PermutationInString {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "adcbczad";

        PermutationInString permutation = new PermutationInString();
        boolean result = permutation.checkInclusion(s1, s2);
        System.out.println(result);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] pat = new int[26];
        for (char c : s1.toCharArray()) {
            pat[c - 'a']++;
        }

        int[] str = new int[26];
        int l = 0;

        for (int r = 0; r < s2.length(); r++) {
            char c = s2.charAt(r);

            str[c - 'a']++;
            if (r - l + 1 == s1.length()) {
                if (compare(pat, str)) {
                    return true;
                }
                str[s2.charAt(l) - 'a']--;
                l++;
            }
        }

        return false;
    }

    private boolean compare(int[] pat, int[] str) {
        for (int i = 0; i < str.length; i++) {
            if (pat[i] != str[i]) {
                return false;
            }
        }
        return true;
    }
}
