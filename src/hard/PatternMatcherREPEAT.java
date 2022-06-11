package hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternMatcherREPEAT {

    public static void main(String[] args) {
        String pattern = "xxyxxy";
        String str = "gogopowerrangergogopowerranger";
        // ["go","powerranger"]

        patternMatcher(pattern, str);
    }

    // O(n^2 + m) time | O(n + m) space
    // OK - repeated 02/02/2022
    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        if (pattern.length() > str.length()) {
            return new String[] {};
        }
        char[] newPattern = getNewPattern(pattern); // newPattern = xxyxxy
        boolean didSwitch = newPattern[0] != pattern.charAt(0); // false
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('x', 0);
        counts.put('y', 0);
        // { 'x': 0, 'y': 0}

        int firstYPos = getCountsAndFirstYPos(newPattern, counts); // 2
        // { 'x': 4, 'y': 2}
        if (counts.get('y') != 0) {
            for (int lenOfX = 1; lenOfX < str.length(); lenOfX++) {
                // (30 - 2*4)/2 = 22 / 2 = 11
                int lenOfY = (str.length() - lenOfX * counts.get('x')) / counts.get('y');
                if (lenOfY <= 0 || lenOfY % 1 != 0) {
                    continue;
                }
                int yIdx = firstYPos * lenOfX; // 2 * 2 = 4
                String x = str.substring(0, lenOfX); // go
                String y = str.substring(yIdx, yIdx + lenOfY); // powerranger
                List<String> potentialMatch = new ArrayList<>();
                for (int i = 0; i < newPattern.length; i++) { // xxyxxy
                    if (newPattern[i] == 'x') {
                        potentialMatch.add(x);
                    } else {
                        potentialMatch.add(y);
                    }
                }
                // [ go, go, powerranger, go, go, powerranger]

                StringBuilder stringBuilder = new StringBuilder();
                for (String element : potentialMatch) {
                    stringBuilder.append(element);
                }
                // gogopowerrangergogopowerranger
                if (str.equals(stringBuilder.toString())) {
                    if (!didSwitch) {
                        return new String[] {x, y};
                    } else {
                        return new String[] {y, x};
                    }
                }
            }
        } else {
            int lenOfX = str.length() / counts.get('x');
            if (lenOfX % 1 == 0) {
                String x = str.substring(0, lenOfX);
                List<String> potentialMatch = new ArrayList<>();
                for (int i = 0; i < newPattern.length; i++) {
                    potentialMatch.add(x);
                }
                StringBuilder potentialMatchString = new StringBuilder();
                for (String element : potentialMatch) {
                    potentialMatchString.append(element);
                }
                if (str.equals(potentialMatchString.toString())) {
                    if (!didSwitch) {
                        return new String[] {x, ""};
                    } else {
                        return new String[] {"", x};
                    }
                }
            }
        }
        return new String[] {};
    }

    private static char[] getNewPattern(String pattern) {
        char[] patternLetters = pattern.toCharArray();
        if (pattern.charAt(0) == 'x') {
            return patternLetters;
        } else {
            for (int i = 0; i < pattern.length(); i++) {
                if (pattern.charAt(i) == 'y') {
                    patternLetters[i] = 'x';
                } else {
                    patternLetters[i] = 'y';
                }
            }
        }
        return patternLetters;
    }

    private static int getCountsAndFirstYPos(char[] pattern, Map<Character, Integer> counts) {
        // xxyxxy
        // {'x': 4, 'y': 2}
        int firstYPos = -1; // 2
        for (int i = 0; i < pattern.length; i++) {
            char character = pattern[i]; // x
            counts.put(character, counts.get(character) + 1);
            if (character == 'y' && firstYPos == -1) {
                firstYPos = i;
            }
        }
        return firstYPos; // 2
    }


}
