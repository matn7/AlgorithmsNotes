package whiteboard;

import java.util.Stack;

public class CompareLeafTraversal {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    // O(n + m) time | O(h1 + h2) space
    public boolean compareLeafTraversal(BinaryTree tree1, BinaryTree tree2) {
        // Write your code here.
        Stack<BinaryTree> stack1 = new Stack<>();
        Stack<BinaryTree> stack2 = new Stack<>();

        stack1.push(tree1);
        stack2.push(tree2);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            BinaryTree leaf1 = findLeaf(stack1);
            BinaryTree leaf2 = findLeaf(stack2);

            if (leaf1 == null || leaf2 == null || leaf1.value != leaf2.value) {
                return false;
            }
        }
        return true;
    }

    private BinaryTree findLeaf(Stack<BinaryTree> stack) {
        while (!stack.isEmpty()) {
            BinaryTree element = stack.pop();
            if (isLeaf(element)) {
                return element;
            }
            if (element.right != null) {
                stack.push(element.right);
            }
            if (element.left != null) {
                stack.push(element.left);
            }
        }
        return null;
    }

    private boolean isLeaf(BinaryTree node) {
        return node.left == null && node.right == null;
    }

}
