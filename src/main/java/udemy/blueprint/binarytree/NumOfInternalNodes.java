package udemy.blueprint.binarytree;

public class NumOfInternalNodes {

    // O(n) time | O(n) space
    public int numInternalNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        return 1 + numInternalNodes(root.left) + numInternalNodes(root.right);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }



}
