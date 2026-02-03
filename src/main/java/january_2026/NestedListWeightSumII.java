package january_2026;


import java.util.LinkedList;
import java.util.List;

public class NestedListWeightSumII {

    // O(n) time | O(n) space
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int unweightedSum = 0;
        int weightedSum = 0;
        LinkedList<NestedInteger> queue = new LinkedList<>(nestedList);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger curr = queue.removeFirst();
                if (curr.isInteger()) {
                    unweightedSum += curr.getInteger();
                } else {
                    for (NestedInteger ni : curr.getList()) {
                        queue.addLast(ni);
                    }
                }
            }
            weightedSum += unweightedSum;
        }

        return weightedSum;
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

}
