package september_2023;

import java.util.ArrayList;
import java.util.function.Predicate;

public class ReconstructBst {

    public static void main(String[] args) {
        int[] arr = {10, 4, 2, 1, 5, 17, 19, 18};
        ArrayList<Integer> preOrderTraversalValues = new ArrayList<>();

        for (int a : arr) {
            preOrderTraversalValues.add(a);
        }

        ReconstructBst reconstructBst = new ReconstructBst();
        reconstructBst.reconstructBst(preOrderTraversalValues);
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

    // O(n^2) time | O(n) space
    public BST reconstructBst(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        BST tree = new BST(preOrderTraversalValues.get(0));
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            int value = preOrderTraversalValues.get(i);
            reconstructBstHelper(tree, value);
        }
        return tree;
    }

    private BST reconstructBstHelper(BST node, int value) {
        if (node.value > value) {
            if (node.left == null) {
                node.left = new BST(value);
                return node;
            }
            return reconstructBstHelper(node.left, value);
        } else {
            if (node.right == null) {
                node.right = new BST(value);
                return node;
            }
            return reconstructBstHelper(node.right, value);
        }
    }

    // O(n^2) time | O(n) space
    public BST reconstructBst2(ArrayList<Integer> preOrderTraversalValues) {
        // Write your code here.
        if (preOrderTraversalValues.isEmpty()) {
            return null;
        }
        return reconstructBstHelper2(preOrderTraversalValues);
    }

    private BST reconstructBstHelper2(ArrayList<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.isEmpty()) {
            return null;
        }
        Integer currentRoot = preOrderTraversalValues.remove(0);

        ArrayList<Integer> smaller = getElements(preOrderTraversalValues, a -> a < currentRoot);
        ArrayList<Integer> larger = getElements(preOrderTraversalValues, a -> a >= currentRoot);

        BST left = reconstructBstHelper2(smaller);
        BST right = reconstructBstHelper2(larger);

        BST currNode = new BST(currentRoot);
        if (left != null) {
            currNode.left = left;
        }
        if (right != null) {
            currNode.right = right;
        }
        return currNode;
    }

    private ArrayList<Integer> getElements(ArrayList<Integer> preOrderTraversalValues,
                                           Predicate<Integer> predicate) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer element : preOrderTraversalValues) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    // O(n) time | O(n) space
    public BST reconstructBst3(ArrayList<Integer> preOrderTraversalValues) {
        TreeInfo treeInfo = new TreeInfo(0);
        return reconstructBstFromRange(Integer.MIN_VALUE, Integer.MAX_VALUE, preOrderTraversalValues, treeInfo);
    }

    private BST reconstructBstFromRange(int lowerBound, int upperBound, ArrayList<Integer> preOrderTraversalValues,
                                        TreeInfo currentSubtreeInfo) {
        if (currentSubtreeInfo.rootIdx == preOrderTraversalValues.size()) {
            return null;
        }
        Integer rootValue = preOrderTraversalValues.get(currentSubtreeInfo.rootIdx);
        if (rootValue < lowerBound || rootValue >= upperBound) {
            return null;
        }
        currentSubtreeInfo.rootIdx++;
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


}
