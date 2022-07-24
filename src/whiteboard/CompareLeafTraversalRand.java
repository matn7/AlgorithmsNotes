package whiteboard;

import java.util.Stack;

public class CompareLeafTraversalRand {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

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
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private BinaryTree findLeaf(Stack<BinaryTree> stack) {
        while (!stack.isEmpty()) {
            BinaryTree top = stack.pop();
            if (isLeaf(top)) {
                return top;
            }
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return null;
    }

    private boolean isLeaf(BinaryTree node) {
        return node.left == null && node.right == null;
    }

}
