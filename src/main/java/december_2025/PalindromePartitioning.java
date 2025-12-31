package december_2025;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> partition = palindromePartitioning.partition(s);
        System.out.println(partition);
    }

    // O(n * 2^n) time | O(n * 2^n) space
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        List<String> oneRes = new ArrayList<>();
        backtrack(s, 0, oneRes, result);

        return result;
    }

    private void backtrack(String s, int i, List<String> oneRes, List<List<String>> result) {
        if (i == s.length()) {
            result.add(new ArrayList<>(oneRes));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                oneRes.add(s.substring(i, j + 1));
                backtrack(s, j + 1, oneRes, result);
                oneRes.remove(oneRes.size() - 1);
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
