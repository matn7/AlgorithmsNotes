package december_2025;

public class FirstUniqueCharacter {

    public static void main(String[] args) {
        String s = "aadadaad";

        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        int result = firstUniqueCharacter.firstUniqChar(s);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int firstUniqChar(String s) {
        int[] chars = new int[26];

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
