package july_2024;

public class CountNumberOfUnival {

    public static void main(String[] args) {
        Node node = new Node(0);
        node.left = new Node(1);
        node.right = new Node(0);
        node.right.left = new Node(1);
        node.right.right = new Node(0);
        node.right.left.left = new Node(1);
        node.right.left.right = new Node(1);

        int result = countUnivalSubtrees(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int countUnivalSubtrees(Node node) {
        return countUnivalSubtreesHelper(node).count;
    }

    private static UnivalInfo countUnivalSubtreesHelper(Node node) {
        if (node == null) {
            return new UnivalInfo(0, true);
        }
        UnivalInfo left = countUnivalSubtreesHelper(node.left);
        UnivalInfo right = countUnivalSubtreesHelper(node.right);

        if (left.isUnival && right.isUnival && (node.left == null || node.value == node.left.value)
                && (node.right == null || node.value == node.right.value)) {
            return new UnivalInfo(left.count + right.count + 1, true);
        }
        return new UnivalInfo(left.count + right.count, false);
    }

    static class UnivalInfo {
        int count;
        boolean isUnival;

        public UnivalInfo(int count, boolean isUnival) {
            this.count = count;
            this.isUnival = isUnival;
        }
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
