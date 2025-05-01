package april_2025;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    // O(n*2^n) time | O(n*2^n) space
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();

        dfs(s, 0, part, res);

        return res;
    }

    private void dfs(String s, int i, List<String> part, List<List<String>> res) {
        if (i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPali(s, i, j)) {
                part.add(s.substring(i, j + 1));
                dfs(s, j + 1, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r) {
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
