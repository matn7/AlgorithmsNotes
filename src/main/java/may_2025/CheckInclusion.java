package may_2025;

public class CheckInclusion {

    public static void main(String[] args) {
        String s1 = "oab";
        String s2 = "eidbaooo";
//
//        String s1 = "abc";
//        String s2 = "ddcba";

        CheckInclusion checkInclusion = new CheckInclusion();
        boolean result = checkInclusion.checkInclusion(s1, s2);
        System.out.println(result);
    }

    // O(n + m) time | O(1) space
    public boolean checkInclusion(String s1, String s2) {
        int[] pattern = new int[26];
        int start = 0;
        int[] str = new int[26];

        for (char c : s1.toCharArray()) {
            pattern[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (i >= s1.length()) {
                boolean found = true;
                for (int j = 0; j < 26; j++) {
                    if (pattern[j] != str[j]) {
                        found = false;
                        break;
                    }
                }
                if (found) {
                    return true;
                }
                str[s2.charAt(start) - 'a']--;
                start++;
            }
            str[c - 'a']++;
        }

        for (int j = 0; j < 26; j++) {
            if (pattern[j] != str[j]) {
                return false;
            }
        }

        return true;
    }

}
