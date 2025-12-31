package december_2025;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class NestedListWright2 {
    // O(n) time | O(n) space
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int totalSum = 0;
        int weightedSum = 0;

        ArrayDeque<NestedInteger> queue = new ArrayDeque<>();
        for (NestedInteger nestedInteger : nestedList) {
            queue.addLast(nestedInteger);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = queue.removeFirst();
                if (curr.isInteger()) {
                    weightedSum += curr.getInteger();
                } else {
                    List<NestedInteger> neighbors = curr.getList();
                    for (NestedInteger nei : neighbors) {
                        queue.addLast(nei);
                    }
                }
            }
            totalSum += weightedSum;
        }
        return totalSum;
    }
}
