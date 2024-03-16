package october_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BranchSums {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(8);
        root.left.right.left = new Node(10);
        root.left.left.right = new Node(9);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> result = branchSumsIterative(root);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> branchSumsIterative(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<NodeElement> stack = new Stack<>();
        stack.push(new NodeElement(root, 0));
        while (!stack.isEmpty()) {
            NodeElement topElement = stack.pop();
            Node node = topElement.node;
            int sum = topElement.sum;
            if (isLeaf(node)) {
                result.add(sum + node.val);
            }
            if (node.right != null) {
                stack.push(new NodeElement(node.right, sum + node.val));
            }
            if (node.left != null) {
                stack.push(new NodeElement(node.left, sum + node.val));
            }
        }

        return result;
    }

    // O(n) time | O(n) space
    public static List<Integer> branchSums(Node root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(Node node, int sum, List<Integer> result) {
        if (node == null) {
            return;
        }
        dfs(node.left, sum + node.val, result);
        if (isLeaf(node)) {
            result.add(sum + node.val);
        }
        dfs(node.right, sum + node.val, result);
    }

    private static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    static class NodeElement {
        Node node;
        int sum;

        public NodeElement(Node node, int sum) {
            this.node = node;
            this.sum = sum;
        }
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
