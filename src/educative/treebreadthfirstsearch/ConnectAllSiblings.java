package educative.treebreadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);
        root.printTree();
    }

    // O(n) time | O(n) space
    public static void connect(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode currentNode = null;
        TreeNode previousNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (previousNode != null) {
                previousNode.next = currentNode;
            }
            previousNode = currentNode;

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.next = null;
        }

        public void printTree() {
            TreeNode current = this;
            System.out.print("Traversal using 'next' pointer: ");
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
        }
    }

}
