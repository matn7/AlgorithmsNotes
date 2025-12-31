package december_2025;

import java.util.*;

public class PalindromePermutationII {

    public static void main(String[] args) {
        PalindromePermutationII palindromePermutationII = new PalindromePermutationII();
        String s = "aabbccc";
        List<String> result = palindromePermutationII.generatePalindromes(s);
        System.out.println(result);
    }

    // O(n!) time | O(n) space
    public List<String> generatePalindromes(String s) {
        List<String> result = new ArrayList<>();
        if (s.isEmpty()) {
            return result;
        }

        // palindrome?
        // aabb -> a:2, b:2 -> no odd OK
        // aacbb -> a:2, b:2, c:1 -> one odd OK
        // abcdba -> not OK
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character> elements = new ArrayList<>();
        char oddChar = ' ';
        for (Map.Entry<Character, Integer> elem : freqMap.entrySet()) {
            if (elem.getValue() % 2 == 1) {
                if (oddChar != ' ') {
                    return new ArrayList<>();
                }
                oddChar = elem.getKey();
                for (int i = 0; i < elem.getValue() / 2; i++) {
                    elements.add(elem.getKey());
                }
            } else {
                for (int i = 0; i < elem.getValue() / 2; i++) {
                    elements.add(elem.getKey());
                }
            }
        }
        if (oddChar != ' ' && elements.isEmpty()) {
            result.add(s);
            return result;
        }

        return permutations(elements, oddChar);
    }

    private List<String> permutations(List<Character> chars, char oddChar) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean[] pick = new boolean[chars.size()];
        backtrack(chars, pick, builder, result);

        Set<String> palindromes = new HashSet<>();
        for (String res : result) {
            String reversed = new StringBuilder(res).reverse().toString();
            String potentialPalindrome = oddChar != ' ' ? res + oddChar + reversed : res + reversed;
            if (isPalindrome(potentialPalindrome)) {
                palindromes.add(potentialPalindrome);
            }
        }
        return new ArrayList<>(palindromes);
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

    private void backtrack(List<Character> nums, boolean[] pick, StringBuilder builder, List<String> result) {
        if (builder.length() == nums.size()) {
            result.add(builder.toString());
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!pick[i]) {
                pick[i] = true;
                builder.append(nums.get(i));

                backtrack(nums, pick, builder, result);

                pick[i] = false;
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

}
