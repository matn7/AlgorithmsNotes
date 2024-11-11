package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxProduct {

    public int maxProduct(String s) {
        int N = s.length();

        // Find all palindromic subsequences using DP
        List<Integer> palindromes = new ArrayList<>();

        for (int mask = 1; mask < 1 << N; mask++) {
            StringBuilder subseq = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) {
                    subseq.append(s.charAt(i));
                }
            }

            // Check if the subsequence is a palindrome
            if (isPalindrome(subseq.toString())) {
                palindromes.add(mask);
            }
        }

        int res = 0;
        // Check pairs of palindromes for the maximum product
        for (int i = 0; i < palindromes.size(); i++) {
            for (int j = i + 1; j < palindromes.size(); j++) {
                if ((palindromes.get(i) & palindromes.get(j)) == 0) { // Check if disjoint
                    int product = Integer.bitCount(palindromes.get(i)) * Integer.bitCount(palindromes.get(j));
                    res = Math.max(res, product);
                }
            }
        }

        return res;
    }

    // Helper function to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
