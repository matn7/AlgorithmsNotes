package educative.treebreadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

    public static void main(String[] args) {
        TreeNode2 root = new TreeNode2(12);
        root.left = new TreeNode2(7);
        root.right = new TreeNode2(1);
        root.left.left = new TreeNode2(9);
        root.right.left = new TreeNode2(10);
        root.right.right = new TreeNode2(5);
        ConnectLevelOrderSiblings.connect(root);
        System.out.println("Level order traversal using 'next' pointer: ");
        root.printLevelOrder();
    }

    // O(n) time | O(n) space
    public static void connect(TreeNode2 root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode2> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode2 previousNode = null;
            int levelSize = queue.size();

            // connect all nodes of this level
            for (int i = 0; i < levelSize; i++) {
                TreeNode2 currentNode = queue.poll();
                if (previousNode != null) {
                    previousNode.next = currentNode;
                }
                previousNode = currentNode;

                // insert the children of current node in the queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
    }

}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;
    TreeNode2 next;

    public TreeNode2(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.next = null;
    }

    // Level order traversal using 'next' pointer
    void printLevelOrder() {
        TreeNode2 nextLevelRoot = this;
        while (nextLevelRoot != null) {
            TreeNode2 current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
