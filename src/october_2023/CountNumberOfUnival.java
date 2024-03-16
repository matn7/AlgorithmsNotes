package october_2023;

public class CountNumberOfUnival {

    public static void main(String[] args) {
        Node node = new Node(0);
        node.left = new Node(1);
        node.right = new Node(0);
        node.right.left = new Node(0);
        node.right.left.left = new Node(1);
        node.right.left.left.left = new Node(1);
        node.right.left.left.right = new Node(1);
        node.right.right = new Node(0);

        System.out.println(countUnival(node));
        System.out.println(countUnivalSubtrees(node));

    }

    public static int countUnivalSubtrees(Node node) {
        return countUnivalSubtreesHelper(node).count;
    }

    private static UnivalInfo countUnivalSubtreesHelper(Node node) {
        if (node == null) {
            return new UnivalInfo(0, true);
        }

        UnivalInfo left = countUnivalSubtreesHelper(node.left);
        UnivalInfo right = countUnivalSubtreesHelper(node.right);

        if (left.isUnival && right.isUnival
                && (node.left == null || node.val == node.left.val)
                && (node.right == null || node.val == node.right.val)) {
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

    // O(n) time | O(n) space
    public static int countUnival(Node node) {
        if (node == null) {
            return 0;
        }
        if (isLeaf(node)) {
            return 1;
        }

        int count = 0;
        int left = countUnival(node.left); // 1
        int right = countUnival(node.right); // 1

        count += (left + right);

        if (node.val == node.left.val && node.val == node.right.val) {
            count++;
        }

        return count;
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
