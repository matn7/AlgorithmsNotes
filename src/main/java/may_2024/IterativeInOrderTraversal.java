package may_2024;

import java.util.*;

public class IterativeInOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.left.left = new Node(4);
        node.left.left.right = new Node(9);
        node.right = new Node(3);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        List<Integer> result = iterativeInOrderTraversal(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> iterativeInOrderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> seen = new HashSet<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            while (stack.peek().left != null && !seen.contains(stack.peek().left)) {
                Node left = stack.peek().left;
                stack.push(left);
            }
            Node top = stack.pop();
            seen.add(top);
            result.add(top.value);
            if (top.right != null) {
                stack.push(top.right);
            }
        }

        return result;
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
