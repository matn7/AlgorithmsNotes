package veryhard;

import java.util.*;

public class LongestStringChain {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("abcdef");
        strings.add("abcde");
        strings.add("abde");
        strings.add("ade");
        strings.add("ae");

        longestStringChain(strings);
    }

    // O(n * m^2 + nlog(n)) time | O(n * m) space
    public static List<String> longestStringChain(List<String> strings) {
        // Write your code here.
        Map<String, StringChainInfo> stringChains = new HashMap<>();
        for (String string : strings) {
            stringChains.put(string, new StringChainInfo("", 1));
        }

        Collections.sort(strings, Comparator.comparingInt(String::length));

        for (String string : strings) {
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
        while (currentString != "") {
            ourLongestStringChain.add(currentString);
            currentString = stringChains.get(currentString).nextString;
        }
        if (ourLongestStringChain.size() == 1) {
            return new ArrayList<>();
        }
        return ourLongestStringChain;
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
