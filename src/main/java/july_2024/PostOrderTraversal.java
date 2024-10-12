package july_2024;

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


    }

    // O(n) time | O(n) space
    public static List<Integer> postOrderTraversal(Node node) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.add(node);
        while (!s1.isEmpty()) {
            Node x = s1.peek();
            s1.pop();
            s2.push(x);
            if (x.left != null) {
                s1.push(x.left);
            }
            if (x.right != null) {
                s1.push(x.right);
            }
        }
        while (!s2.isEmpty()) {
            result.add(s2.pop().value);
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
