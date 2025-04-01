package march_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Combinations {

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Combinations combinations = new Combinations();
        List<List<Integer>> result = combinations.combine(n, k);
        System.out.println(result);
    }

    // O(k*2^n) time | O(n) space
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
        combination.add(num);
        backtrack(n, k, num + 1, combination, result);
        combination.remove(combination.size() - 1);
        backtrack(n, k, num + 1, combination, result);
    }

}
