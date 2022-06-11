package hard;

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

    // O(n^2+m) time | O(n+m) space
    public static String[] patternMatcher(String pattern, String string) {
        // Write your code here.
        if (pattern.length() > string.length()) {
            return new String[] {};
        }
        char[] newPattern = getNewParent(pattern);
        boolean didSwitch = false;
        if (newPattern[0] != pattern.charAt(0)) {
            didSwitch = true;
        }
        Map<Character, Integer> counts = new HashMap<>();
        counts.put('x', 0);
        counts.put('y', 0);

        int firstYPos = getCountsAndFirstYPos(newPattern, counts);

        if (counts.get('y') != 0) {
            for (int lenOfX = 1; lenOfX < string.length(); lenOfX++) {
                int lenOfY = (string.length() - lenOfX * counts.get('x')) / counts.get('y');
                if (lenOfY <= 0 || lenOfY % 1 != 0) {
                    continue;
                }
//                lenOfY int(lenOfY);
                int yIdx = firstYPos * lenOfX;
                String x = string.substring(0,lenOfX); // g
                String y = string.substring(yIdx,yIdx + lenOfY); // gopowerranger
                List<String> potentialMatch = new ArrayList<>();
                for (int i = 0; i < newPattern.length; i++) {
                    if (newPattern[i] == 'x') {
                        potentialMatch.add(x);
                    } else {
                        potentialMatch.add(y);
                    }
                }
                StringBuilder potentialMatchString = new StringBuilder();
                for (String element : potentialMatch) {
                    potentialMatchString.append(element);
                }
                if (string.equals(potentialMatchString.toString())) {
                    if (!didSwitch) {
                        return new String[] {x, y};
                    } else {
                        return new String[] {y, x};
                    }
                }
            }
        } else {
            int lenOfX = string.length() / counts.get('x');
            if (lenOfX % 1 == 0) {
                String x = string.substring(0, lenOfX);
                List<String> potentialMatch = new ArrayList<>();
                for (int i = 0; i < newPattern.length; i++) {
                    potentialMatch.add(x);
                }
                StringBuilder potentialMatchString = new StringBuilder();
                for (String element : potentialMatch) {
                    potentialMatchString.append(element);
                }
                if (string.equals(potentialMatchString.toString())) {
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

    private static int getCountsAndFirstYPos(char[] pattern, Map<Character, Integer> counts) {
        int firstYPos = -1;
        for (int i = 0; i < pattern.length; i++) {
            char c = pattern[i];
            counts.put(pattern[i], counts.get(pattern[i]) + 1);
            if (c == 'y' && firstYPos == -1) {
                firstYPos = i;
            }
        }
        return firstYPos;
    }

    private static char[] getNewParent(String pattern) {
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

}
