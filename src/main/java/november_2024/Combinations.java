package november_2024;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;

        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(n, k);
        System.out.println(combine);
    }

    // O(k * n^k) time
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        backtrack(1, new ArrayList<>(), n, k, res);

        return res;
    }

    private void backtrack(int start, List<Integer> comb, int n, int k, List<List<Integer>> res) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for (int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(i + 1, comb, n, k, res);
            comb.remove(comb.size() - 1);
        }
    }

}



















