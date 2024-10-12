package september_2023;


import java.util.Stack;

public class MergeBinaryTrees {

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1);
        tree1.left = new BinaryTree(3);
        tree1.right = new BinaryTree(2);
        tree1.left.left = new BinaryTree(7);
        tree1.left.right = new BinaryTree(4);

        BinaryTree tree2 = new BinaryTree(1);
        tree2.left = new BinaryTree(5);
        tree2.right = new BinaryTree(9);
        tree2.left.left = new BinaryTree(2);
        tree2.right.left = new BinaryTree(7);
        tree2.right.right = new BinaryTree(6);

        MergeBinaryTrees mergeBinaryTrees = new MergeBinaryTrees();
        BinaryTree result = mergeBinaryTrees.mergeBinaryTrees2(tree1, tree2);

        System.out.println();
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n) time | O(n) space
    public BinaryTree mergeBinaryTrees(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        if (tree1 == null) {
            return tree2;
        }
        if (tree2 == null) {
            return tree1;
        }
        BinaryTree newNode = new BinaryTree(tree1.value + tree2.value);
        newNode.left = mergeBinaryTrees(tree1.left, tree2.left);
        newNode.right = mergeBinaryTrees(tree1.right, tree2.right);
        return newNode;
    }

    // O(n) time | O(n) space
    public BinaryTree mergeBinaryTrees2(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        if (tree1 == null) {
            return tree2;
        }
        if (tree2 == null) {
            return tree1;
        }
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();
        stack1.push(tree1);
        stack2.push(tree2);


        while (!stack1.isEmpty()) {
            BinaryTree node1 = stack1.pop();
            BinaryTree node2 = stack2.pop();

            if (node2 == null) {
                continue;
            }

            node1.value = node1.value + node2.value;
            if (node1.left == null) {
                node1.left = node2.left;
            } else {
                stack1.push(node1.left);
                stack2.push(node2.left);
            }
            if (node1.right == null) {
                node1.right = node2.right;
            } else {
                stack1.push(node1.right);
                stack2.push(node2.right);
            }
        }

        return tree1;
    }


}
