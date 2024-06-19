package april_2024;

public class MaxPathSum {

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(4);
        node.right = new Node(20);
        node.left.left = new Node(-6);
        node.left.right = new Node(-10);
        node.right.right = new Node(-28);
        node.left.left.left = new Node(22);
        node.left.left.right = new Node(-30);
        node.right.right.left = new Node(2);
        node.right.right.right = new Node(7);

        MaxPathSum maxPathSum = new MaxPathSum();
        int result = maxPathSum.maxPathSum(node);
        System.out.println(result);
    }


    int ans = Integer.MIN_VALUE;
    // O(n) time | O(n) space
    public int maxPathSum(Node root) {
        solution(root);
        return ans;
    }

    private int solution(Node node) {
        if (node == null) {
            return 0;
        }
        int left = solution(node.left);
        int right = solution(node.right);

        int maxSide = Math.max(node.value, node.value + Math.max(left, right));
        int maxCurrent = Math.max(maxSide, node.value + left + right);

        ans = Math.max(ans, maxCurrent);
        return maxSide;
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
