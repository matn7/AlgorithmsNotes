package may_2025;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning2 {

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning2 palindromePartitioning2 = new PalindromePartitioning2();
        List<List<String>> result = palindromePartitioning2.partition(s);
        System.out.println(result);
    }

    // O(n*2^n) time | O(n) space
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(s, 0, curr, result);
        return result;
    }

    private void backtrack(String s, int i, List<String> curr, List<List<String>> result) {
        if (i == s.length()) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                curr.add(s.substring(i, j + 1));
                backtrack(s, j + 1, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int i, int j) {
        if (i > j) {
            return false;
        }
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
