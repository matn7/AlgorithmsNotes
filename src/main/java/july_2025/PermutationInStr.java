package july_2025;

public class PermutationInStr {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

//        String s1 = "ab";
//        String s2 = "eidboaoo";

        PermutationInStr permutationInStr = new PermutationInStr();
        boolean result = permutationInStr.checkInclusion(s1, s2);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public boolean checkInclusion(String s1, String s2) {
        int[] pat = new int[26];
        for (int c : s1.toCharArray()) {
            pat[c - 'a']++;
        }
        int[] str = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (i >= s1.length()) {
                boolean res = true;
                for (int j = 0; j < 26; j++) {
                    if (pat[j] != str[j]) {
                        res = false;
                        break;
                    }
                }
                if (res) {
                    return true;
                }
                str[s2.charAt(i - s1.length()) - 'a']--;
            }
            str[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (pat[i] != str[i]) {
                return false;
            }
        }
        return true;
    }

}
