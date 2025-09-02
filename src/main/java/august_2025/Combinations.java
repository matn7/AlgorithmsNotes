package august_2025;

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

    // O(k * n^k) time | O(n) space
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> part = new ArrayList<>();

        backtrack(1, n, k, part, result);

        return result;
    }

    private void backtrack(int i, int n, int k, List<Integer> part, List<List<Integer>> result) {
        if (part.size() == k) {
            result.add(new ArrayList<>(part));
            return;
        }
        if (i > n) {
            return;
        }

        part.add(i);
        backtrack(i + 1, n, k, part, result);
        part.remove(part.size() - 1);
        backtrack(i + 1, n, k, part, result);
    }

}
