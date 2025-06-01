package may_2025;

public class IsAnagram {

    // O(n) time | O(1) space
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        short[] sChars = new short[26];
        short[] tChars = new short[26];

        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }

}
