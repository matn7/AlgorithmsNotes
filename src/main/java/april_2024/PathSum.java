package april_2024;

public class PathSum {

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(6);
        node.right = new Node(9);
        node.left.left = new Node(15);
        node.right.left = new Node(11);
        node.right.right = new Node(3);
        node.left.left.left = new Node(2);
        node.left.left.right = new Node(9);
        node.right.right.right = new Node(2);
        node.right.right.right.right = new Node(15);
//        node.right.right.right.right.right = new Node(1);

        int target = 34;

        boolean result = hasPathSum(node, target);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        return hasSum(root, sum, 0);
    }

    private static boolean hasSum(Node root, int sum, int curr) {
        curr += root.value;
        if (curr == sum && root.left == null && root.right == null) {
            return true;
        }

        if (root.left != null) {
            if (hasSum(root.left, sum, curr)) {
                return true;
            }
        }

        if (root.right != null) {
            if (hasSum(root.right, sum, curr)) {
                return true;
            }
        }
        return false;
    }


    // O(n) time | O(n) space
    public static boolean pathSum(Node node, int target) {
        return pathSumHelper(node, 0, target);
    }

    private static boolean pathSumHelper(Node node, int currSum, int target) {
        if (node == null) {
            return false;
        }
        currSum += node.value;
        if (currSum == target && isLeaf(node)) {
            System.out.println("FOUND: " + node.value);
            return true;
        }
        boolean leftSum = pathSumHelper(node.left, currSum, target);
        if (leftSum) {
            return true;
        }
        return pathSumHelper(node.right, currSum, target);
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
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
