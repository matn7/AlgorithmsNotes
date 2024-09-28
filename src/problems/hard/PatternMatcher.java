package problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternMatcher {

    public static void main(String[] args) {
        String pattern = "xxyxxy";
        String str = "gogopowerrangergogopowerranger";
        // ["go","powerranger"]

        patternMatcher(pattern, str);
    }

    // O(n^2 + m) time | O(n + m) space
    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        if (pattern.length() > str.length()) {
            return new String[] {};
        }
        char[] newPattern = getNewPattern(pattern);
        boolean didSwitch = newPattern[0] != pattern.charAt(0);
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('x', 0);
        counts.put('y', 0);

        int firstYPos = getCountsAndFirstYPos(newPattern, counts);
        if (counts.get('y') != 0) {
            for (int lenOfX = 1; lenOfX < str.length(); lenOfX++) {
                int lenOfY = (str.length() - lenOfX * counts.get('x')) / counts.get('y');
                if (lenOfY <= 0 || lenOfY % 1 != 0) {
                    continue;
                }
                int yIdx = firstYPos * lenOfX;
                String x = str.substring(0, lenOfX);
                String y = str.substring(yIdx, yIdx + lenOfY);
                List<String> potentialMatch = new ArrayList<>();
                for (int i = 0; i < newPattern.length; i++) {
                    if (newPattern[i] == 'x') {
                        potentialMatch.add(x);
                    } else {
                        potentialMatch.add(y);
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (String element : potentialMatch) {
                    stringBuilder.append(element);
                }
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
        int firstYPos = -1;
        for (int i = 0; i < pattern.length; i++) {
            char character = pattern[i];
            counts.put(character, counts.get(character) + 1);
            if (character == 'y' && firstYPos == -1) {
                firstYPos = i;
            }
        }
        return firstYPos;
    }


}
