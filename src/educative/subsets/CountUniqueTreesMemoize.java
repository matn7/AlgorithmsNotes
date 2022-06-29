package educative.subsets;

import java.util.HashMap;
import java.util.Map;

public class CountUniqueTreesMemoize {

    public static void main(String[] args) {
        CountUniqueTreesMemoize ct = new CountUniqueTreesMemoize();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }

    Map<Integer, Integer> map = new HashMap<>();

    // O(n^2) time | O(n) space
    public int countTrees(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n <= 1) {
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        map.put(n, count);
        return count;
    }

}
