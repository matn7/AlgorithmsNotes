package april_2024;

import java.util.ArrayList;
import java.util.List;

public class TypedOutStrings {

    public static void main(String[] args) {
        String S = "ab#z";
        String T = "az#z";

        boolean result = backSpaceCompare(S, T);
        System.out.println(result);
    }

    // O(n + m) time | O(1) space
    public static boolean backSpaceCompare2(String S, String T) {
        int p1 = S.length() - 1;
        int p2 = T.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            if (S.charAt(p1) == '#' || T.charAt(p2) == '#') {
                if (S.charAt(p1) == '#') {
                    int backcount = 2;
                    while (backcount > 0) {
                        p1--;
                        backcount--;
                        if (S.charAt(p1) == '#') {
                            backcount += 2;
                        }
                    }
                }
                if (T.charAt(p2) == '#') {
                    int backcount = 2;
                    while (backcount > 0) {
                        p2--;
                        backcount--;
                        if (T.charAt(p2) == '#') {
                            backcount += 2;
                        }
                    }
                }
            } else {
                if (S.charAt(p1) != T.charAt(p2)) {
                    return false;
                } else {
                    p1--;
                    p2--;
                }
            }
        }
        return true;

    }

    // O(n + m) time | O(n + m) space
    public static boolean backSpaceCompare(String S, String T) {
        List<Character> sChars = buildString(S);
        List<Character> tChars = buildString(T);
        if (sChars.size() != tChars.size()) {
            return false;
        }
        for (int i = 0; i < sChars.size(); i++) {
            if (sChars.get(i) != tChars.get(i)) {
                return false;
            }
        }
        return true;
    }

    private static List<Character> buildString(String str) {
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '#') {
                if (!chars.isEmpty()) {
                    chars.remove(chars.size() - 1);
                }
            } else {
                chars.add(curr);
            }
        }
        return chars;
    }

}
