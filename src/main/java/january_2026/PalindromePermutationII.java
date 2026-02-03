package january_2026;

import star.MultiStringSearch;

import java.util.*;

public class PalindromePermutationII {

    public static void main(String[] args) {
        PalindromePermutationII palindromePermutationII = new PalindromePermutationII();
        // String s = "aabb";
        String s = "aabbccc";
        List<String> strings = palindromePermutationII.generatePalindromes(s);
        System.out.println(strings);
    }

    // O(n!) time | O(n) space
    public List<String> generatePalindromes(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // check we can generate palindromes
        char oneOdd = ' ';
        List<Character> elements = new ArrayList<>();
        for (Map.Entry<Character, Integer> element : freqMap.entrySet()) {
            if (element.getValue() % 2 == 1) {
                if (oneOdd != ' ') {
                    return new ArrayList<>();
                }
                oneOdd = element.getKey();
                for (int i = 0; i < element.getValue() / 2; i++) {
                    elements.add(element.getKey());
                }
            } else {
                for (int i = 0; i < element.getValue() / 2; i++) {
                    elements.add(element.getKey());
                }
            }
        }
        Set<String> result = new HashSet<>();
        if (oneOdd != ' ' && elements.isEmpty()) {
            result.add(s);
            return new ArrayList<>(result);
        }
        List<String> permutations = permute(elements);
        for (String permute : permutations) {
            StringBuilder oneRes = new StringBuilder();
            oneRes.append(permute);
            if (oneOdd != ' ') {
                oneRes.append(oneOdd);
            }
            oneRes.append(new StringBuilder(permute).reverse());
            String candidate = oneRes.toString();
            if (isPalindrome(candidate)) {
                result.add(candidate);
            }
        }

        return new ArrayList<>(result);
    }

    private boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private List<String> permute(List<Character> chars) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean[] used = new boolean[chars.size()];

        backtrack(chars, used, builder, result);
        return result;
    }

    private void backtrack(List<Character> chars, boolean[] used, StringBuilder builder, List<String> result) {
        if (builder.length() == chars.size()) {
            result.add(builder.toString());
            return;
        }
        for (int i = 0; i < chars.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                builder.append(chars.get(i));
                backtrack(chars, used, builder, result);
                used[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }

        }
    }

}
