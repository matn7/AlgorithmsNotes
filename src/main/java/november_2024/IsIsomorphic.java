package november_2024;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {


    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> mapping = new HashMap<>();

        int i = 0;
        int j = 0;

        while (i < s.length()) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(j);

            if (!mapping.containsKey(sChar)) {
                Collection<Character> values = mapping.values();
                if (values.contains(tChar)) {
                    return false;
                }
                mapping.put(sChar, tChar);
            } else {
                Character mapped = mapping.get(sChar);
                if (tChar != mapped) {
                    return false;
                }
            }
            i++;
            j++;
        }
        return true;
    }

}
