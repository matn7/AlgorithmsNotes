package april_2025;


import java.util.Stack;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(33);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaxDepthOfBinaryTree maxDepthOfBinaryTree = new MaxDepthOfBinaryTree();
        int result = maxDepthOfBinaryTree.maxDepth(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(0, root));
        int maxDepth = 0;
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            TreeNode node = top.node;
            int newDepth = top.depth + 1;
            maxDepth = Math.max(maxDepth, newDepth);
            if (node.left != null) {
                stack.push(new Node(newDepth, node.left));
            }
            if (node.right != null) {
                stack.push(new Node(newDepth, node.right));
            }
        }
        return maxDepth;
    }

    static class Node {
        int depth;
        TreeNode node;

        public Node(int depth, TreeNode node) {
            this.depth = depth;
            this.node = node;
        }
    }

    // O(n) time | O(n) space
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
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
