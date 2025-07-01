package june_2025;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "anagram";

        ValidAnagram validAnagram = new ValidAnagram();
        boolean anagram = validAnagram.isAnagram(s, t);
        System.out.println(anagram);
    }

    // O(n) time | O(26) space
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] sChars = new int[26];
        int[] tChars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sChars[s.charAt(i) - 'a']++;
            tChars[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != tChars[i]) {
                return false;
            }
        }
        return true;
    }

}
