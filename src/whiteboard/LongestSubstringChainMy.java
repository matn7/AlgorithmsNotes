package whiteboard;

import java.util.*;

public class LongestSubstringChainMy {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"));

        longestStringChain(strings);
    }

    // O(n * m^2 + nlog(n)) time | O(n * m) space
    // (n - length of input strings list, m - length of longest string, nlogn -sorting of input strings)
    public static List<String> longestStringChain(List<String> strings) {
        // Write your code here.
        Map<String, ModifiedElement> substringChains = new HashMap<>();
        for (String string : strings) {
            substringChains.put(string, new ModifiedElement("", 1));
        }

        List<String> sortedStrings = new ArrayList<>(strings);
        sortedStrings.sort(Comparator.comparingInt(String::length));
        int maxCount = 1;
        String maxElementKey = "";

        for (String currString : sortedStrings) {
            for (int i = 0; i < currString.length(); i++) {
                String modifiedString = modify(currString, i);
                if (substringChains.containsKey(modifiedString)) {
                    ModifiedElement modifiedElement = substringChains.get(modifiedString);
                    ModifiedElement currentModifiedElement = substringChains.get(currString);
                    if (currentModifiedElement.count < modifiedElement.count+ 1) {
                        if (modifiedElement.count + 1 > maxCount) {
                            maxCount = modifiedElement.count + 1;
                            maxElementKey = currString;
                        }
                        substringChains.remove(currString);
                        substringChains.put(currString, new ModifiedElement(modifiedString, modifiedElement.count + 1));
                    }

                }
            }
        }
        // found element with biggest count
        if (maxElementKey.equals("")) {
            return new ArrayList<>();
        }
        ModifiedElement startElement = substringChains.get(maxElementKey);
        ModifiedElement currElement = startElement;
        List<String> result = new ArrayList<>();
        result.add(maxElementKey);
        while (!currElement.key.equals("")) {
            result.add(currElement.key);
            currElement = substringChains.get(currElement.key);
        }

        return result;
    }

    private static String modify(String str, int index) {
        if (index == 0 && str.length() > 0) {
            return str.substring(index + 1);
        } else if (index == str.length() - 1) {
            return str.substring(0, index);
        } else {
            return str.substring(0, index) + str.substring(index + 1);
        }
    }

    static class ModifiedElement {
        String key;
        int count;

        public ModifiedElement(String key, int count) {
            this.key = key;
            this.count = count;
        }
    }

}
