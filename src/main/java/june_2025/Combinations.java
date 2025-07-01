package june_2025;

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

    // O(n * 2^n) time | O(n) space
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();
        backtrack(n, k, 1, part, result);
        return result;
    }

    private void backtrack(int n, int k, int s, List<Integer> part, List<List<Integer>> result) {
        if (part.size() == k) {
            result.add(new ArrayList<>(part));
            return;
        }

        for (int i = s; i <= n; i++) {
            part.add(i);
            backtrack(n, k, i + 1, part, result);
            part.remove(part.size() - 1);
        }
    }


}
