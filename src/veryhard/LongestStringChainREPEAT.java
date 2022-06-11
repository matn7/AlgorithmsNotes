package veryhard;

import java.util.*;

public class LongestStringChainREPEAT {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef");

        longestStringChain(strings);
    }

    // OK - repeated 26/02/2022
    // O(n * m^2 + nlog(n)) time | O(nm) space
    public static List<String> longestStringChain(List<String> strings) {
        // Write your code here.
        Map<String, StringChainInfo> stringChains = new HashMap<>();

        // ["abde", "abc", "abd", "abcde", "ade", "ae", "1abde", "abcdef"]
        for (String string : strings) {
            stringChains.put(string, new StringChainInfo("", 1));
        }
        // {"abde": ("", 1), "abc": ("", 1), "abd": ("", 1), "abcde": (), "ade": ("", 1), "ae": ("", 1),
        // "1abde": ("", 1), "abcdef": ("", 1)}

        List<String> sortedStrings = new ArrayList<>(strings);
        sortedStrings.sort(Comparator.comparingInt(String::length));
        //                                          *
        // ["ae", "abc", "abd", "abde", "abcde", "1abde", "abcdef"]
        for (String string : sortedStrings) {
            // rec("abcdef", {})
            findLongestStringChain(string, stringChains);
        }

        return buildLongestStringChain(strings, stringChains);
    }

    //        *
    // rec("abcdef", {})
    private static void findLongestStringChain(String string, Map<String, StringChainInfo> stringChains) {
        for (int i = 0; i < string.length(); i++) {
            String smallerString = getSmallerString(string, i); // abcdef
            if (!stringChains.containsKey(smallerString)) {
                continue;
            }
            // rec("abcdef", "abcdef", {})
            tryUpdateLongestStringChain(string, smallerString, stringChains);
        }
    }
    // {"abde": ("abde", 4), "abc": ("abc", 2), "abd": ("abd", 2), "abcde": ("abcde", 4), "ade": ("", 1), "ae": ("ae", 2),
    // "1abde": ("", 1), "abcdef": ("abcde", 5)}
    private static void tryUpdateLongestStringChain(String currentString, String smallerString,
                                                    Map<String, StringChainInfo> stringChains) {
        // rec("abcdef", "abcdef", {})
        int currentStringChainLength = stringChains.get(currentString).maxChainLength; // 5
        int smallerStringChainLength = stringChains.get(smallerString).maxChainLength; // 5
        if (smallerStringChainLength + 1 > currentStringChainLength) {
            stringChains.remove(currentString);
            stringChains.put(currentString, new StringChainInfo(smallerString,
                    smallerStringChainLength + 1));
        }
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


    private static String getSmallerString(String string, int index) {
        return string.substring(0,index) + string.substring(index + 1);
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
