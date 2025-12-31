package december_2025;

public class PermutationInString {

    public static void main(String[] args) {
//        String s1 = "ab";
//        String s2 = "eidbaooo";

        String s1 = "ab";
        String s2 = "eidboaoo";

        PermutationInString permutationInString = new PermutationInString();
        boolean result = permutationInString.checkInclusion(s1, s2);
        System.out.println(result);
    }

    // O(n + m) time | O(n + m) space
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] pattern = new int[26];
        for (char c : s1.toCharArray()) {
            pattern[c - 'a']++;
        }

        int l = 0;
        int[] substring = new int[26];
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (i >= s1.length()) {
                boolean match = true;

                for (int j = 0; j < 26; j++) {
                    if (pattern[j] != substring[j]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return true;
                }
                // remove first elem
                char first = s2.charAt(l);
                substring[first - 'a']--;
                l++;
            }
            substring[c - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (pattern[j] != substring[j]) {
                return false;
            }
        }
        return true;
    }


}
