package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(2);
        node.right = new Node(5);
        node.left.left = new Node(1);
        node.right.left = new Node(4);
        node.right.right = new Node(6);

        List<Integer> integers = postOrderTraversal(node);
        System.out.println(integers);
    }

    // O(n) time | O(n) space
    public static List<Integer> postOrderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(node);

        while (!stack1.isEmpty()) {
            Node pop = stack1.pop();
            stack2.push(pop);

            if (pop.left != null) {
                stack1.push(pop.left);
            }
            if (pop.right != null) {
                stack1.push(pop.right);
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
