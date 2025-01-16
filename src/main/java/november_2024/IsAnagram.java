package november_2024;

public class IsAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        IsAnagram isAnagram = new IsAnagram();
        boolean anagram = isAnagram.isAnagram(s, t);
        System.out.println(anagram);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] schars = new int[26];
        int[] tchars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            schars[s.charAt(i) - 'a']++;
            tchars[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < schars.length; i++) {
            if (schars[i] != tchars[i]) {
                return false;
            }
        }
        return true;
    }

}
