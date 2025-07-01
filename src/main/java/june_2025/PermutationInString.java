package june_2025;

public class PermutationInString {

    public static void main(String[] args) {
//        String s1 = "abcg";
//        String s2 = "eidbaocaboo";

        String s1 = "adc";
        String s2 = "dcda";

        PermutationInString permutationInString = new PermutationInString();
        boolean result = permutationInString.checkInclusion(s1, s2);
        System.out.println(result);

    }

    // O(n) time | O(26) space
    public boolean checkInclusion(String s1, String s2) {
        int[] pattern = new int[26];
        for (char c : s1.toCharArray()) {
            pattern[c - 'a']++;
        }
        int[] substr = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (i >= s1.length()) {
                boolean found = true;
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] != substr[j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
                char t = s2.charAt(i - s1.length());
                substr[t - 'a']--;
            }
            substr[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (pattern[i] != substr[i]) {
                return false;
            }
        }
        return true;
    }


}
