package april_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

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
        if (node == null) {
            return result;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(node);

        while (!stack1.isEmpty()) {
            Node x = stack1.peek();
            stack1.pop();
            stack2.push(x);
            if (x.left != null) {
                stack1.push(x.left);
            }
            if (x.right != null) {
                stack1.push(x.right);
            }
        }

        while (!stack2.isEmpty()) {
            result.add(stack2.pop().value);
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
