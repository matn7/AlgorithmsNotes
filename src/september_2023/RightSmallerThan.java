package september_2023;

import java.util.ArrayList;
import java.util.List;

public class RightSmallerThan {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        int[] arr = {8, 5, 11, -1, 3, 4, 2};
        for (int a : arr) {
            array.add(a);
        }

        rightSmallerThan2(array);
    }

    // O(nlog(n)) time | O(n) space
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) {
            return new ArrayList<>();
        }

        int lastIdx = array.size() - 1;
        SpecialBST bst = new SpecialBST(array.get(lastIdx), lastIdx, 0);
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, 0);
        }
        List<Integer> rightSmallerCounts = new ArrayList<>(array);
        getRightSmallerCounts(bst, rightSmallerCounts);
        return rightSmallerCounts;
    }

    private static void getRightSmallerCounts(SpecialBST bst, List<Integer> rightSmallerCounts) {
        if (bst == null) {
            return;
        }
        rightSmallerCounts.set(bst.idx, bst.numSmallerAtInsertTime);
        getRightSmallerCounts(bst.left, rightSmallerCounts);
        getRightSmallerCounts(bst.right, rightSmallerCounts);
    }

    static class SpecialBST {
        int value;
        int idx;
        int numSmallerAtInsertTime;
        int leftSubtreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int value, int idx, int numSmallerAtInsertTime) {
            this.value = value;
            this.idx = idx;
            this.numSmallerAtInsertTime = numSmallerAtInsertTime;
            this.leftSubtreeSize = 0;
        }

        void insert(int value, int idx, int numSmallerAtInsertTime) {
            if (value < this.value) {
                leftSubtreeSize++;
                if (left == null) {
                    left = new SpecialBST(value, idx, numSmallerAtInsertTime);
                } else {
                    left.insert(value, idx, numSmallerAtInsertTime);
                }
            } else {
                numSmallerAtInsertTime += leftSubtreeSize;
                if (value > this.value) {
                    numSmallerAtInsertTime++;
                }
                if (right == null) {
                    right = new SpecialBST(value, idx, numSmallerAtInsertTime);
                } else {
                    right.insert(value, idx, numSmallerAtInsertTime);
                }
            }
        }
    }

    // O(n^2) time | O(n) space
    public static List<Integer> rightSmallerThan2(List<Integer> array) {
        // Write your code here.
        List<Integer> rightSmallerCounts = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int curr = array.get(i);
            int counter = 0;
            for (int j = i + 1; j < array.size(); j++) {
                if (curr > array.get(j)) {
                    counter++;
                }
            }
            rightSmallerCounts.add(counter);
        }
        return rightSmallerCounts;
    }

}
