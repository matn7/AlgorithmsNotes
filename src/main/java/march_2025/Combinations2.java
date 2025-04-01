package march_2025;

import java.util.ArrayList;
import java.util.List;

public class Combinations2 {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations2 combinations = new Combinations2();
        List<List<Integer>> result = combinations.combine(n, k);
        System.out.println(result);
    }

    // O(n!/(k!*(n-k)!)) time | O(n) space
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        backtrack(n, k, 1, combination, result);
        return new ArrayList<>(result);
    }

    private void backtrack(int n, int k, int num, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == k) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (num > n) {
            return;
        }
        for (int j = num; j <= n; j++) {
            combination.add(j);
            backtrack(n, k, j + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }

}
