package july_2025;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.isAnagram(s, t);
        System.out.println(result);
    }

    // O(n) time | O(26) space
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] aChars = new int[26];
        int[] bChars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            aChars[s.charAt(i) - 'a']++;
            bChars[t.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (aChars[i] != bChars[i]) {
                return false;
            }
        }
        return true;
    }

}
