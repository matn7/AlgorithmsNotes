package may_2025;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.combine(n, k);
        System.out.println(result);
    }

    // O(k * n^k) time | O(k * n^k) space
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> oneRes = new ArrayList<>();
        backtrack(1, n, k, oneRes, result);
        return result;
    }

    private void backtrack(int i, int n, int k, List<Integer> oneRes, List<List<Integer>> result) {
        if (oneRes.size() == k) {
            result.add(new ArrayList<>(oneRes));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = i; j <= n; j++) {
            oneRes.add(j);
            backtrack(j + 1, n, k, oneRes, result);
            oneRes.remove(oneRes.size() - 1);
        }
    }

}
