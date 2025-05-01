package april_2025;

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

  // O(k * n^k) time | O(k * n^k) time
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> oneRes = new ArrayList<>();
    backtrack(n, k, 1, oneRes, result);
    return result;
  }

  private void backtrack(int n, int k, int start, List<Integer> oneRes, List<List<Integer>> result) {
    if (oneRes.size() == k) {
      result.add(new ArrayList<>(oneRes));
      return;
    }
    if (start > n) {
      return;
    }

    for (int i = start; i <= n; i++) {
      oneRes.add(i);
      backtrack(n, k, i + 1, oneRes, result);
      oneRes.remove(oneRes.size() - 1);
    }

  }

}
