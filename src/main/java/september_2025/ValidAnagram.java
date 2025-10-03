package september_2025;

public class ValidAnagram {

    // O(n) time | O(1) space
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            freqs[sChar - 'a']++;
            freqs[tChar - 'a']--;
        }
        for (int i = 0; i < freqs.length; i++) {
            if (freqs[i] != 0) {
                return false;
            }
        }
        return true;
    }

}
