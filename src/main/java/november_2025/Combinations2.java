package november_2025;

import java.util.ArrayList;
import java.util.List;

public class Combinations2 {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations2 combinations2 = new Combinations2();
        List<List<Integer>> result = combinations2.combine(n, k);
        System.out.println(result);
    }

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        backtrack(1, n, k, part, res);
        return res;
    }

    private void backtrack(int j, int n, int k, List<Integer> part, List<List<Integer>> res) {
        if (part.size() == k) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int i = j; i <= n; i++) {
            part.add(i);
            backtrack(i + 1, n, k, part, res);
            part.remove(part.size() - 1);
        }
    }

}
