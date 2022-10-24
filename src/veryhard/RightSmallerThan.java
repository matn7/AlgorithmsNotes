package veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RightSmallerThan {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(8, 5, 11, -1, 3, 4, 2));
        rightSmallerThan(array);
    }

    // OK - repeated 19/02/2022
    // O(nlog(n)) time | O(n) space
    public static List<Integer> rightSmallerThan(List<Integer> array) {
        if (array.size() == 0) {
            return new ArrayList<>();
        }

        List<Integer> rightSmallerCounts = new ArrayList<>(array);
        int lastIdx = array.size() - 1; // 6
        SpecialBST bst = new SpecialBST(array.get(lastIdx));
        rightSmallerCounts.set(lastIdx, 0);
        for (int i = array.size() - 2; i >= 0; i--) {
            bst.insert(array.get(i), i, rightSmallerCounts, 0);
        }

        return rightSmallerCounts; // [5, 4, 4, 0, 1, 1, 0]
    }

    //        2:1
    //       /  \
    //     1:0   4:1
    //          /   \
    //         3:0  11:2
    //              /
    //             5:0 *
    //               \
    //               8:0

    static class SpecialBST {
        int value;
        int leftSubtreeSize;
        SpecialBST left;
        SpecialBST right;

        public SpecialBST(int value) {
            this.value = value;
            this.leftSubtreeSize = 0;
            this.left = null;
            this.right = null;
        }

        public void insert(Integer value, int idx,  List<Integer> rightSmallerCounts,
                           int numSmallerAtInsertTime) {
            if (value < this.value) { // 8 < 5
                leftSubtreeSize++; // 1
                if (this.left == null) {
                    this.left = new SpecialBST(value);
                    rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                } else {
                    // rec( 8, 0, [8, 4, 4, 0, 1, 1, 0], 4)
                    this.left.insert(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            } else {
                numSmallerAtInsertTime += leftSubtreeSize; // 4
                if (value > this.value) { // 8 > 5
                    numSmallerAtInsertTime++; // 5
                }
                if (this.right == null) {
                    this.right = new SpecialBST(value);
                    rightSmallerCounts.set(idx, numSmallerAtInsertTime);
                } else {
                    // rec( 8, 0, [8, 4, 4, 0, 1, 1, 0], 4)
                    // rec( 8, 0, [8, 4, 4, 0, 1, 1, 0], 2)
                    // rec( 5, 1, [8, 5, 4, 0, 1, 1, 0], 4)
                    // rec( 5, 1, [8, 5, 4, 0, 1, 1, 0], 2)
                    // rec(11, 2, [8, 5, 11, 0, 1, 1, 0], 2)
                    // rec( 3, 4, [8, 5, 11, -1, 3, 1, 0], 1)
                    this.right.insert(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            }
        }
    }

    // O(n^2) time | O(n) space
    public static List<Integer> rightSmallerThan2(List<Integer> array) {
        // Write your code here.
        List<Integer> rightSmallerCounts = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            int rightSmallerCount = 0;
            for (int j = i + 1; j < array.size(); j++) {
                if (array.get(j) < array.get(i)) {
                    rightSmallerCount++; // 1
                }
            }
            rightSmallerCounts.add(rightSmallerCount);
        }
        return rightSmallerCounts; // [5,4,4,0,1,1,0]
    }

}
