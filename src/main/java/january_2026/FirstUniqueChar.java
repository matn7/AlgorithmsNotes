package january_2026;

public class FirstUniqueChar {

    // O(n) time | O(1) space
    public int firstUniqChar(String s) {
        char[] chars = new char[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
