package udemy.blueprint.binarytree;

public class NumOfNodes {

    // O(n) time | O(n) space
    public int numOfNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + numOfNodes(root.left) + numOfNodes(root.right);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
