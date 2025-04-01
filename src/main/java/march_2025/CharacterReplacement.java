package march_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharacterReplacement {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        CharacterReplacement characterReplacement = new CharacterReplacement();
        int result = characterReplacement.characterReplacement(s, k);
        System.out.println(result);
    }

    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }
        int res = 0;
        for (char c : charSet) {
            int count = 0;
            int L = 0;
            for (int R = 0; R < s.length(); R++) {
                if (s.charAt(R) == c) {
                    count++;
                }
                while ((R - L + 1) - count > k) {
                    if (s.charAt(L) == c) {
                        count--;
                    }
                    L++;
                }
                res = Math.max(res, R - L + 1);
            }
        }
        return res;
    }
}
