package udemy.faang;

import java.util.ArrayList;
import java.util.List;

public class TypedOutStrings {

    public static void main(String[] args) {
        TypedOutStrings typedOutStrings = new TypedOutStrings();

        String s = "ab##";
        String t = "c#d#";

        boolean result = typedOutStrings.backspaceCompareOptimal(s, t);
        System.out.println();
    }

    public boolean backspaceCompare(String s, String t) {
        List<Character> finalS = buildString(s);
        List<Character> finalT = buildString(t);

        if (finalS.size() != finalT.size()) {
            return false;
        }
        for (int p = 0; p < finalS.size(); p++) {
            if (finalS.get(p) != finalT.get(p)) {
                return false;
            }
        }
        return true;
    }

    private List<Character> buildString(String string) {
        List<Character> builtArray = new ArrayList<>();
        for (int p = 0; p < string.length(); p++) {
            if (string.charAt(p) != '#') {
                builtArray.add(string.charAt(p));
            } else {
                if (!builtArray.isEmpty()) {
                    builtArray.remove(builtArray.size() - 1);
                }
            }
        }
        return builtArray;
    }

    // O(a + b) time | O(1) space
    public boolean backspaceCompareOptimal(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;

        while (p1 >= 0 || p2 >= 0) {
            if ((p1 >= 0 && s.charAt(p1) == '#') || (p2 >= 0 && t.charAt(p2) == '#')) {
                if (p1 >= 0 && s.charAt(p1) == '#') {
                    int backcount = 2;
                    while (backcount > 0) {
                        p1--;
                        backcount--;
                        if (p1 >= 0 && s.charAt(p1) == '#') {
                            backcount += 2;
                        }
                    }
                }
                if (p2 >= 0 && t.charAt(p2) == '#') {
                    int backcount = 2;
                    while (backcount > 0) {
                        p2--;
                        backcount--;

                        if (p2 >= 0 && t.charAt(p2) == '#') {
                            backcount += 2;
                        }
                    }
                }
            } else {
                if (p1 < 0 || p2 < 0) {
                    return false;
                }
                if (s.charAt(p1) != t.charAt(p2)) {
                    return false;
                } else {
                    p1--;
                    p2--;
                }
            }
        }
        return true;
    }

    // mine
    public boolean backspaceCompareOptimal2(String s, String t) {
        int p1 = s.length() - 1;
        int p2 = t.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            int sJump = 0;
            while (p1 >= 0 && s.charAt(p1) == '#') {
                sJump++;
                p1--;
            }
            int tJump = 0;
            while (p2 >= 0 && t.charAt(p2) == '#') {
                tJump++;
                p2--;
            }
            if (p1 - sJump < 0 || p2 - tJump < 0) {
                return false;
            }
            if (s.charAt(p1 - sJump) != t.charAt(p2 - tJump)) {
                return false;
            }
            p1--;
            p2--;
        }

        return true;
    }

}
