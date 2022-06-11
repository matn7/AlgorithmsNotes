package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHeightBstREPEAT {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,5,7,10,13,14,15,22));

        BST bst = minHeightBst(array);
        System.out.println();
    }

    // O(n) time  | O(n) space
    public static BST minHeightBst(List<Integer> array) {
        // Write your code here.
        return constructMinHeightBst(array, 0, array.size() - 1);
    }
    //                       10
    //                      /   \
    //                     2     14
    //                    / \    / \
    //                   1   5  13  15
    //                        \      \
    //                         7     22

    // rec([],9,8) -> null
    // rec([],8,7) -> null
    // rec([],8,8) -> 22
    // rec([],7,6) -> null
    // rec([],7,8) -> 15
    // rec([],6,5) -> null
    // rec([],5,4) -> null
    // rec([],5,5) -> 13
    // rec([],5,8) -> 14
    // rec([],4,3) -> null
    // rec([],3,2) -> null
    // rec([],3,3) -> 7
    // rec([],2,1) -> null
    // rec([],2,3) -> 5
    // rec([],1,0) -> null
    // rec([],0,-1) -> null
    // rec([],0,0) -> 1
    // rec([],0,3) -> 2
    // rec([],0,8) -> 10
    private static BST constructMinHeightBst(List<Integer> array, int startIdx, int endIdx) {
        //  0  1  2  3   4   5   6   7   8
        // [1, 2, 5, 7, 10, 13, 14, 15, 22]
        //  *  *  *  *   *   m   *
        if (endIdx < startIdx) {
            return null;
        }
        int midIdx = (startIdx + endIdx) / 2; // (8 + 8) / 2 = 8
        BST bst = new BST(array.get(midIdx)); // (22)

        bst.left = constructMinHeightBst(array, startIdx, midIdx - 1);
        bst.right = constructMinHeightBst(array, midIdx + 1, endIdx);
        return bst;
    }


    // O(n) time  | O(n) space
    // OK - repeated 14/02/2022
//    public static BST minHeightBst(List<Integer> array) {
//        // Write your code here.
//        return constructMinHeightBst(array, null, 0, array.size() - 1);
//    }
    //                  10
    //                 /   \
    //                2*    14
    //               / \    / \
    //              1   5  13  15
    //                   \      \
    //                    7     22

    // rec([], (22), 9, 8) -> null
    // rec([], (22), 8, 7) -> null
    // rec([], (15), 8, 8) -> 22
    // rec([], (15), 7, 6) -> null
    // rec([], (14), 7, 8) -> 15
    // rec([], (13), 6, 5) -> null
    // rec([], (13), 5, 4) -> null
    // rec([], (14), 5, 5) -> 13
    // rec([], (10), 5, 8) -> 14
    // rec([], (7), 4, 3) -> null
    // rec([], (7), 3, 2) -> null
    // rec([], (5), 3, 3) -> 7
    // rec([], (5), 2, 1) -> null
    // rec([], (2), 2, 3) -> 5
    // rec([], (1), 1, 0) -> null
    // rec([], (1), 0, -1) -> null
    // rec([], (2), 0, 0) -> 1
    // rec([], (10), 0, 3) -> 2
    // rec([], null, 0, 8) -> 10
//    private static BST constructMinHeightBst(List<Integer> array, BST bst, int startIdx, int endIdx) {
//        //  0  1  2  3   4   5   6   7   8
//        // [1, 2, 5, 7, 10, 13, 14, 15, 22]
//        //  *  *  *  *  *    *   *   m
//        if (endIdx < startIdx) {
//            return null;
//        }
//        int midIdx = (startIdx + endIdx) / 2; // (8 + 8) / 2 = 8
//        BST newBstNode = new BST(array.get(midIdx)); // (22)
//        if (bst == null) {
//            bst = newBstNode; //
//        } else {
//            if (array.get(midIdx) < bst.value) { // 22 < 15
//                bst.left = newBstNode;
//                bst = bst.left;
//            } else {
//                bst.right = newBstNode;
//                bst = bst.right;
//            }
//        }
//
//        // rec([], (22), 8, 7)
//        constructMinHeightBst(array, bst, startIdx, midIdx - 1);
//        // rec([], (22), 9, 8)
//        constructMinHeightBst(array, bst, midIdx + 1, endIdx);
//        return bst;
//    }

//    // O(nlog(n)) time  | O(n) space
//    public static BST minHeightBst(List<Integer> array) {
//        // Write your code here.
//        return constructMinHeightBst(array, null, 0, array.size() - 1);
//    }
//
//    private static BST constructMinHeightBst(List<Integer> array, BST bst, int startIdx, int endIdx) {
//        if (endIdx < startIdx) {
//            return null;
//        }
//        int midIdx = (startIdx + endIdx) / 2;
//        int valueToAdd = array.get(midIdx);
//        if (bst == null) {
//            bst = new BST(valueToAdd);
//        } else {
//            bst.insert(valueToAdd);
//        }
//        constructMinHeightBst(array, bst, startIdx, midIdx - 1);
//        constructMinHeightBst(array, bst, midIdx + 1, endIdx);
//        return bst;
//    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

}
