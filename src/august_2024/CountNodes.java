package august_2024;

public class CountNodes {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        tree.left.left.left = new Node(8);
        tree.left.left.right = new Node(9);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(11);
        tree.right.left.left = new Node(12);

        int result = countNodes(tree);
        System.out.println(result);
    }

    // O(h^2) time | O(1) space
    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int height = getTreeHeight(root);
        if (height == 0) {
            return 1;
        }
        int upperCount = (int) Math.pow(2, height) - 1;
        int left = 0;
        int right = upperCount;
        while (left < right) {
            int indexToFind = (int) Math.ceil((left + right) / 2.0);
            if (nodeExists(indexToFind, height, root)) {
                left = indexToFind;
            } else {
                right = indexToFind - 1;
            }
        }
        return upperCount + left + 1;
    }

    private static boolean nodeExists(int indexToFind, int height, Node node) {
        int left = 0;
        int right = (int) Math.pow(2, height) - 1;
        int count = 0;
        while (count < height) {
            int midOfNode = (int) Math.ceil((left + right) / 2.0);
            if (indexToFind >= midOfNode) {
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

    private static int getTreeHeight(Node root) {
        int height = 0;
        while (root.left != null) {
            root = root.left;
            height++;
        }
        return height;
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
