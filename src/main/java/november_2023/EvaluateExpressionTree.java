package november_2023;

public class EvaluateExpressionTree {

    public static void main(String[] args) {
        Node node = new Node(-1);
        node.left = new Node(-2);
        node.right = new Node(-3);
        node.left.left = new Node(-4);
        node.left.right = new Node(2);
        node.right.left = new Node(8);
        node.right.right = new Node(3);
        node.left.left.left = new Node(2);
        node.left.left.right = new Node(3);

        System.out.println(evaluateExpression(node));
    }

    // O(n) time | O(h) space
    public static int evaluateExpression(Node node) {
        if (node.value >= 0) {
            return node.value;
        }
        int left = evaluateExpression(node.left);
        int right = evaluateExpression(node.right);

        if (node.value == -1) {
            return left + right;
        }
        if (node.value == -2) {
            return left - right;
        }
        if (node.value == -3) {
            return left / right;
        }
        return left * right;
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
