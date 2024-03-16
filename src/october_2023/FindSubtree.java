package october_2023;

import java.util.Stack;

public class FindSubtree {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(4);
        a.right = new Node(5);
        a.left.left = new Node(3);
        a.left.right = new Node(2);
        a.right.left = new Node(4);
        a.right.right = new Node(5);

        Node b = new Node(4);
        b.left = new Node(3);
        b.right = new Node(2);

        boolean result = findSubtree2(a, b);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public static boolean findSubtree2(Node a, Node b) {
        StringBuilder builder = new StringBuilder();
        preOrder(a, builder);
        String nodeA = builder.toString();
        builder.setLength(0);
        preOrder(b, builder);
        String nodeB = builder.toString();
        return nodeA.contains(nodeB);
    }

    private static void preOrder(Node node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            return;
        }
        builder.append(node.val);
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }


    // O(n*m) time | O(n*m) space
    public static boolean findSubtree(Node a, Node b) {
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            boolean leftFound = a.left == null || b.left == null || findSubtree(a.left, b.left);
            if (leftFound) {
                boolean rightFound = a.right == null || b.right == null || findSubtree(a.right, b.right);
                if (rightFound) {
                    return true;
                }
            }
        }
        boolean goLeft = findSubtree(a.left, b);
        boolean goRight = findSubtree(a.right, b);
        return goLeft || goRight;
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
