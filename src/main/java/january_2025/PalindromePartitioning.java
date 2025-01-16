package january_2025;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String s = "aab";
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        List<List<String>> result = palindromePartitioning.partition(s);
        System.out.println(result);
    }

    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        backtrack(0, part, s);
        return res;
    }

    private void backtrack(int i, List<String> part, String s) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j, s)) {
                part.add(s.substring(i, j + 1));
                backtrack(j + 1, part, s);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

}
