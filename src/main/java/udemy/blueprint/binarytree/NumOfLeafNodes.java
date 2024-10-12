package udemy.blueprint.binarytree;

public class NumOfLeafNodes {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(7);
        node.left.right = new Node(8);
        node.left.right.left = new Node(11);
        node.right = new Node(3);
        node.right.right = new Node(9);

        NumOfLeafNodes numOfLeafNodes = new NumOfLeafNodes();
        int result = numOfLeafNodes.numOfLeafNodes(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public int numOfLeafNodes(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
//        if (root.left != null && root.right == null) {
//            return numOfLeafNodes(root.left);
//        }
//        if (root.left == null && root.right != null) {
//            return numOfLeafNodes(root.right);
//        }

        return numOfLeafNodes(root.left) + numOfLeafNodes(root.right);
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
