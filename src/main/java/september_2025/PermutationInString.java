package september_2025;

public class PermutationInString {

    public static void main(String[] args) {
//        String s1 = "ab";
//        String s2 = "eidbaooo";

        String s1 = "adc";
        String s2 = "dcda";

        PermutationInString permutationInString = new PermutationInString();
        boolean result = permutationInString.checkInclusion(s1, s2);
        System.out.println(result);

    }

    // O(n + m) time | O(1) space
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        // O(m) time
        int[] pattern = new int[26];
        for (char c : s1.toCharArray()) {
            pattern[c - 'a']++;
        }

        int l = 0;
        int[] sub = new int[26];
        // O(n) time
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            //   *
            // eidbaooo
            if (i >= s1.length()) {
                boolean match = true;
                // O(26) time
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] != sub[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
                char t = s2.charAt(l);
                l++;
                sub[t - 'a']--;
            }
            sub[c - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (pattern[j] != sub[j]) {
                return false;
            }
        }
        return true;
    }


}
