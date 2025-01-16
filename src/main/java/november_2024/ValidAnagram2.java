package november_2024;

public class ValidAnagram2 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int sChar = s.charAt(i) - 'a';
            int tChar = s.charAt(i) - 'a';
            count[sChar]++;
            count[tChar]--;
        }
        for (int n : count) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }

}
