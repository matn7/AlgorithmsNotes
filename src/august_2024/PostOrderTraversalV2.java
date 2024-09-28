package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalV2 {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.right = new Node(5);
        node.right.left = new Node(4);
        node.right.right = new Node(6);

        List<Integer> result = postOrderTraversal(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<Integer> postOrderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();

        // left - right - node
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(node);

        while (!stack1.isEmpty()) {
            Node current = stack1.pop();
            stack2.push(current);
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        while (!stack2.isEmpty()) {
            Node res = stack2.pop();
            result.add(res.value);
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
