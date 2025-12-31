package december_2025;

import java.util.ArrayDeque;
import java.util.List;

public class NestedListWeightSumII2 {

    public static void main(String[] args) {

    }

    // O(n) time | O(n) space
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweightedSum = 0;
        int weightedSum = 0;

        ArrayDeque<NestedInteger> queue = new ArrayDeque<>();
        for (NestedInteger nestedInteger : nestedList) {
            queue.addLast(nestedInteger);
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            System.out.println("size: " + size);
            for (int i = 0; i < size; i++) {
                NestedInteger curr = queue.removeFirst();
                if (curr.isInteger()) {
                    unweightedSum += curr.getInteger();
                } else {
                    List<NestedInteger> neighbors = curr.getList();
                    for (NestedInteger nei : neighbors) {
                        queue.addLast(nei);
                    }
                }
            }
            System.out.println(unweightedSum);
            weightedSum += unweightedSum;
        }
        return weightedSum;
    }



}
interface NestedInteger {
//    public NestedInteger();

//    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
