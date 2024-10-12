package may_2024;

public class NumberOfNodesInCompleteTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        root.right.left.left = new Node(12);

        int result = countNodes(root);
        System.out.println(result);
    }

    // O(h^2 + h) time | O(1) space -> O(h) -> O(log(n))
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int height = getTreeHeight(root); // O(h)
        if (height == 0) {
            return 1;
        }
        int upperCount = (int) Math.pow(2, height) - 1;
        int left = 0;
        int right = upperCount;
        while (left < right) { // O(h^2)
            int idxToFind = (int) Math.ceil((left + right) / 2.0);
            if (nodeExists(idxToFind, height, root)) {
                left = idxToFind;
            } else {
                right = idxToFind - 1;
            }
        }
        return upperCount + left + 1;
    }

    private static int getTreeHeight(Node root) {
        int height = 0;
        while (root.left != null) {
            height++;
            root = root.left;
        }
        return height;
    }

    private static boolean nodeExists(int idxToFind, int height, Node node) {
        int left = 0;
        int right = (int) Math.pow(2, height) - 1;
        int count = 0;
        while (count < height) {
            int midOfNode = (int) Math.ceil((left + right) / 2.0);
            if (idxToFind >= midOfNode) {
                node = node.right;
                left = midOfNode;
            } else {
                node = node.left;
                right = midOfNode - 1;
            }
            count++;
        }
        return node != null;
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
