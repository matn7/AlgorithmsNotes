package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;

public class ReconstructBST {

    public static void main(String[] args) {

        ArrayList<Integer> preOrderTraversalValues = new ArrayList<>(Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18));

        ReconstructBST reconstructBST = new ReconstructBST();
        BST bst = reconstructBST.reconstructBst(preOrderTraversalValues);
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

    static class TreeInfo {
        int rootIdx;

        public TreeInfo(int rootIdx) {
            this.rootIdx = rootIdx;
        }
    }

    // O(n^2) time | O(h) space
    // OK - repeated 16/02/2022
    public BST reconstructBst2(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        if (preOrderTraversalValues.isEmpty()) {
            return null;
        }
        //   0  1  2  3  4   5   6   7
        // [10, 4, 2, 1, 5, 17, 19, 18]
        //                   *
        Integer currentValue = preOrderTraversalValues.get(0); // 19
        int rightSubtreeRootIdx = preOrderTraversalValues.size(); // 2

        for (int idx = 0; idx < preOrderTraversalValues.size(); idx++) {
            Integer value = preOrderTraversalValues.get(idx); // 1
            if (value > currentValue) { // 19 > 18
                rightSubtreeRootIdx = idx;
                break;
            }
        }

        ArrayList<Integer> leftList = new ArrayList<>();
        for (int i = 1; i < rightSubtreeRootIdx; i++) {
            leftList.add(preOrderTraversalValues.get(i)); // [1]
        }
        BST leftSubtree = reconstructBst2(leftList); // 1-2

        ArrayList<Integer> rightList = new ArrayList<>();
        for (int i = rightSubtreeRootIdx; i < preOrderTraversalValues.size(); i++) {
            rightList.add(preOrderTraversalValues.get(i));
        }
        BST rightSubtree = reconstructBst2(rightList); // 5

        BST newBst = new BST(currentValue);
        newBst.left = leftSubtree;
        newBst.right = rightSubtree;
        return newBst;
    }


}
