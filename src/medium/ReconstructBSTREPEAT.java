package medium;

import java.util.ArrayList;
import java.util.Arrays;

public class ReconstructBSTREPEAT {

    public static void main(String[] args) {

        ArrayList<Integer> preOrderTraversalValues = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));

        ReconstructBSTREPEAT reconstructBSTREPEAT = new ReconstructBSTREPEAT();
        BST bst = reconstructBSTREPEAT.reconstructBst(preOrderTraversalValues);
        System.out.println();
    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(h) space
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    // rec(19, max,  [10, 4, 2, 1, 5, 17, 19, 18], (7)) - null
    // rec(18,  19,  [10, 4, 2, 1, 5, 17, 19, 18], (7)) - null
    // rec(17,  18,  [10, 4, 2, 1, 5, 17, 19, 18], (7)) - null
    // rec(17,  19,  [10, 4, 2, 1, 5, 17, 19, 18], (7)) - null
    // rec(17, max,  [10, 4, 2, 1, 5, 17, 19, 18], (6)) - null
    // rec(10,  17,  [10, 4, 2, 1, 5, 17, 19, 18], (5)) - null
    // rec(10, max,  [10, 4, 2, 1, 5, 17, 19, 18], (5))
    // OK - repeated 16/02/2022
    private BST reconstructBstFromRange(int lowerBound, int upperBound, ArrayList<Integer> preOrderTraversalValues,
                                        TreeInfo currentSubtreeInfo) {
        System.out.println(lowerBound + ":" + upperBound);
        // 8 == 8
        if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
            return null;
        }

        Integer rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx); // 18
        if (rootValue < lowerBound || rootValue >= upperBound) { // 18 < 17 || 18 >= max
            return null;
        }

        currentSubtreeInfo.rootIdx++; // 8
        BST leftSubtree = reconstructBstFromRange(lowerBound, rootValue, preOrderTraversalValues, currentSubtreeInfo);
        BST rightSubtree = reconstructBstFromRange(rootValue, upperBound, preOrderTraversalValues, currentSubtreeInfo);

        BST newBst = new BST(rootValue);
        newBst.left = leftSubtree;
        newBst.right = rightSubtree;
        return newBst;
    }
    //                    10
    //                  /    \
    //                4       17
    //              /   \       \
    //             2     5       19
    //           /  \   / \     /
    //          1    N N   N   18
    //         / \            /  \
    //        N   N          N    N

    static class TreeInfo {
        int rootIdx;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }

    // rec([]) - 19 right => null
    // rec([]) - 18 right => null
    // rec([]) - 18 left => null
    // rec([18]) - 19 left => 18
    // rec([19,18]) - 17 right => 18-19
    // rec([]) - 17 left => null
    // rec([17,19,18]) - 10 right => 18-19-17
    // rec([]) - 5 right => null
    // rec([]) - 5 left => null
    // rec([5]) - 4 right => 5
    // rec([]) - 2 right => null
    // rec([]) - 1 right => null
    // rec([]) - 1 left => null
    // rec([1])  => 1                    currentValue = 1
    // rec([2, 1]) => 1-2                currentValue = 2
    // rec([4, 2, 1, 5]) => 1-2-5-4      currentValue = 4
    // rec([10, 4, 2, 1, 5, 17, 19, 18]) currentValue = 10 *
    // O(n^2) time | O(h) space
    // OK - repeated 16/02/2022
//    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
//        // Write your code here.
//        if (preOrderTraversalValues.isEmpty()) {
//            return null;
//        }
//        //   0  1  2  3  4   5   6   7
//        // [10, 4, 2, 1, 5, 17, 19, 18]
//        //                   *
//        Integer currentValue = preOrderTraversalValues.get(0); // 19
//        int rightSubtreeRootIdx = preOrderTraversalValues.size(); // 2
//
//        for (int idx = 0; idx < preOrderTraversalValues.size(); idx++) {
//            Integer value = preOrderTraversalValues.get(idx); // 1
//            if (value > currentValue) { // 19 > 18
//                rightSubtreeRootIdx = idx;
//                break;
//            }
//        }
//
//        ArrayList<Integer> leftList = new ArrayList<>();
//        for (int i = 1; i < rightSubtreeRootIdx; i++) {
//            leftList.add(preOrderTraversalValues.get(i)); // [1]
//        }
//        BST leftSubtree = reconstructBst(leftList); // 1-2
//
//        ArrayList<Integer> rightList = new ArrayList<>();
//        for (int i = rightSubtreeRootIdx; i < preOrderTraversalValues.size(); i++) {
//            rightList.add(preOrderTraversalValues.get(i));
//        }
//        BST rightSubtree = reconstructBst(rightList); // 5
//
//        BST newBst = new BST(currentValue);
//        newBst.left = leftSubtree;
//        newBst.right = rightSubtree;
//        //                  10
//        //              /       \
//        //             4         17
//        //           /   \         \
//        //         2      5         19
//        //       /  \    / \       /  \
//        //      1    N  N   N    18    N
//        //    /  \              /  \
//        //   N    N            N    N
//
//        return newBst;
//    }


}
