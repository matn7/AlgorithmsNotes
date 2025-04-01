package march_2025;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.isAnagram(s, t);
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] scount = new int[26];
        int[] tcount = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int cs = s.charAt(i) - 'a';
            int ts = t.charAt(i) - 'a';
            scount[cs]++;
            tcount[ts]++;
        }
        for (int i = 0; i < 26; i++) {
            if (scount[i] != tcount[i]) {
                return false;
            }
        }
        return true;
    }

}
