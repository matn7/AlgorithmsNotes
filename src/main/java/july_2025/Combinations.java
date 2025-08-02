package july_2025;

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

    // O(k * 2^n) time | O(k) space
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        backtrack(n, k, 1, part, result);

        return result;
    }

    private void backtrack(int n, int k, int i, List<Integer> part, List<List<Integer>> result) {
        if (part.size() == k) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j <= n; j++) {
            part.add(j);
            backtrack(n, k, j + 1, part, result);
            part.remove(part.size() - 1);
        }
    }


}
