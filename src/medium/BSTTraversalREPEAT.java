package medium;

import java.util.ArrayList;
import java.util.List;

public class BSTTraversalREPEAT {

    public static void main(String[] args) {

        BST tree = new BST(10);
        tree.left = new BST(5);
        tree.right = new BST(15);
        tree.left.left = new BST(2);
        tree.left.right = new BST(5);
        tree.left.left.left = new BST(1);
        tree.right.right = new BST(22);

        List<Integer> array = new ArrayList<>();
        inOrderTraverse(tree, array);
        System.out.println();

    }

    // rec(null) -> 22 right
    // rec(null) -> 22 left
    // rec(22) => [1,2,5,5,10,15,22]
    // rec(null) -> 15 left
    // rec(15) => [1,2,5,5,10,15]
    // rec(null) -> 5 right
    // rec(null) -> 5 left
    // rec(5) => [1,2,5,5]
    // rec(null) -> 2 right
    // rec(null) -> 1 right
    // rec(null) -> 1 left
    // rec(1) => [1]
    // rec(2) => [1,2]
    // rec(5) => [1,2,5]
    // rec(10) => [1,2,5,5,10]
    // O(n) time | O(n) space
    // OK - repeated 12/02/2022
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree != null) {
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array; // [1,2,5,5,10,15,22]
    }

    // rec(null) -> 22 right
    // rec(null) -> 22 left
    // rec(22) => [10,5,2,1,5,15,22]
    // rec(null) -> 15 left
    // rec(15) => [10,5,2,1,5,15]
    // rec(null) -> 5 right
    // rec(null) -> 5 left
    // rec(5) => [10,5,2,1,5]
    // rec(null) -> 2 right
    // rec(null) -> 1 right
    // rec(null) -> 1 left
    // rec(1) => [10,5,2,1]
    // rec(2) => [10,5,2]
    // rec(5) => [10,5]
    // rec(10) => [10]
    // O(n) time | O(n) space
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree != null) {
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array; // [10,5,2,1,5,15,22]
    }

    //              10
    //             /  \
    //            5    15
    //           / \    \
    //          2   5    22
    //         /
    //        1

    // rec(null) -> 22 right
    // rec(null) -> 22 left
    // rec(22) => [1,2,5,5,22]
    // rec(null) -> 15 left
    // rec(15) => [1,2,5,5,22,15]
    // rec(null) -> 5 right
    // rec(null) -> 5 left
    // rec(5) => [1,2,5]
    // rec(null) -> 2 right
    // rec(null) -> 1 right
    // rec(null) -> 1 left
    // rec(1) => [1]
    // rec(2) => [1,2]
    // rec(5) => [1,2,5,5]
    // rec(10) => [1,2,5,5,22,15,10]
    // O(n) time | O(n) space
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        // Write your code here.
        if (tree != null) {
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);
        }
        return array; // [1,2,5,5,22,15,10]
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
