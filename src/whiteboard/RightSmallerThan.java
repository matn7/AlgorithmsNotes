package whiteboard;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {

    public static void main(String[] args) {
        int[] elements = {8, 5, 11, -1, 3, 4, 2};
        List<Integer> array = new ArrayList<>();
        for (int element : elements) {
            array.add(element);
        }

        rightSmallerThan(array);
    }

    // Average: O(nlog(n)) time | O(n) space
    // Worst: O(n^2) time | O(1) space
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        // Write your code here.
        if (array.size() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            result.add(0);
        }

        int lastIdx = array.size() - 1;

        SpecialBST bst = new SpecialBST(array.get(lastIdx));
        result.set(lastIdx, 0);

        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, result, 0);
        }

        return result;
    }

    static class SpecialBST {
        int val;
        int leftSubtreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int val) {
            this.val = val;
            this.leftSubtreeSize = 0;
            this.left = null;
            this.right = null;
        }

        public void insert(int val, int idx, List<Integer> result, int numSmallerAtInsertTime) {
            if (val < this.val) {
                leftSubtreeSize++;
                if (this.left == null) {
                    this.left = new SpecialBST(val);
                    result.set(idx, numSmallerAtInsertTime);
                } else {
                    this.left.insert(val, idx, result, numSmallerAtInsertTime);
                }
            } else {
                numSmallerAtInsertTime += leftSubtreeSize;
                if (val > this.val) {
                    numSmallerAtInsertTime++;
                }
                if (this.right == null) {
                    this.right = new SpecialBST(val);
                    result.set(idx,numSmallerAtInsertTime);
                } else {
                    this.right.insert(val, idx, result, numSmallerAtInsertTime);
                }
            }

        }
    }

}
