package whiteboard;

import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {
        String[] str = {"abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"};
        List<String> strings = new ArrayList<>();
        for (String element : str) {
            strings.add(element);
        }

        longestStringChain(strings);
    }

    // O(n * m^2 + nlon(n)) time | O(nm) space
    // rand: 06/08/2022
    public static List<String> longestStringChain(List<String> strings) {
        // Write your code here.
        Map<String, StringChainInfo> stringChains = new HashMap<>();

        for (String string : strings) {
            stringChains.put(string, new StringChainInfo("", 1));
        }

        List<String> sortedStrings = new ArrayList<>(strings);
        sortedStrings.sort(Comparator.comparingInt(String::length));

        for (String string : sortedStrings) {
            findLongestStringChain(string, stringChains);
        }

        return buildLongestStringChain(strings, stringChains);
    }

    private static List<String> buildLongestStringChain(List<String> strings, Map<String, StringChainInfo> stringChains) {
        int maxChainLength = 0;
        String chainStartingString = "";
        for (String string : strings) {
            if (stringChains.get(string).maxChainLength > maxChainLength) {
                maxChainLength = stringChains.get(string).maxChainLength;
                chainStartingString = string;
            }
        }

        List<String> ourLongestStringChain = new ArrayList<>();
        String currentString = chainStartingString;
        while (!currentString.equals("")) {
            ourLongestStringChain.add(currentString);
            currentString = stringChains.get(currentString).nextString;
        }

        return ourLongestStringChain.size() == 1 ? new ArrayList<>() : ourLongestStringChain;
    }

    private static void findLongestStringChain(String string, Map<String, StringChainInfo> stringChains) {
        for (int i = 0; i < string.length(); i++) {
            String smallerString = getSmallerString(string, i);
            if (!stringChains.containsKey(smallerString)) {
                continue;
            }
            tryUpdateLongestStringChain(string, smallerString, stringChains);
        }
    }

    private static void tryUpdateLongestStringChain(String currentString, String smallerString,
                                                    Map<String, StringChainInfo> stringChains) {
        int smallerStringChainLength = stringChains.get(smallerString).maxChainLength;
        int currentStringChainLength = stringChains.get(currentString).maxChainLength;
        if (smallerStringChainLength + 1 > currentStringChainLength) {
            stringChains.remove(currentString);
            stringChains.put(currentString, new StringChainInfo(smallerString, smallerStringChainLength + 1));
        }
    }

    private static String getSmallerString(String string, int index) {
        return string.substring(0, index) + string.substring(index + 1);
    }

    static class StringChainInfo {
        String nextString;
        int maxChainLength;

        public StringChainInfo(String nextString, int maxChainLength) {
            this.nextString = nextString;
            this.maxChainLength = maxChainLength;
        }
    }
}
