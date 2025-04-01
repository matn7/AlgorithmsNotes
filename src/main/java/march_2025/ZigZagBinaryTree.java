package march_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);

        ZigZagBinaryTree zigZagBinaryTree = new ZigZagBinaryTree();
        List<Integer> result = zigZagBinaryTree.zigZagOrder(node);
        System.out.println(result);
    }

    public List<Integer> zigZagOrder(TreeNode node) {
        Stack<TreeNode> currLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        List<Integer> result = new ArrayList<>();
        currLevel.add(node);
        boolean leftRight = false;

        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = currLevel.pop();
                result.add(currNode.val);
                if (leftRight) {
                    if (currNode.left != null) {
                        nextLevel.push(currNode.left);
                    }
                    if (currNode.right != null) {
                        nextLevel.push(currNode.right);
                    }
                } else {
                    if (currNode.right != null) {
                        nextLevel.push(currNode.right);
                    }
                    if (currNode.left != null) {
                        nextLevel.push(currNode.left);
                    }
                }
            }
            currLevel = nextLevel;
            nextLevel = new Stack<>();
            leftRight = !leftRight;
        }
        return result;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
