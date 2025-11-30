package november_2025;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";

        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> result = palindromePartitioning.partition(s);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> part = new ArrayList<>();
        backtrack(s, 0, part, result);
        return result;
    }

    private void backtrack(String s, int i, List<String> part, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                part.add(s.substring(i, j + 1));
                backtrack(s, j + 1, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


}
