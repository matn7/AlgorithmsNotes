package april_2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString {

    public static void main(String[] args) {
        String s = "badc", t = "baba";

        IsomorphicString isomorphicString = new IsomorphicString();
        boolean isomorphic = isomorphicString.isIsomorphic(s, t);

        System.out.println(isomorphic);

    }

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            char val = t.charAt(i);

            if (mapping.containsKey(key)) {
                if (mapping.get(key) != val) {
                    return false;
                }
            } else {
                if (seen.contains(val)) {
                    return false;
                }
                mapping.put(key, val);
                seen.add(val);
            }
        }
        return true;
    }

}
