package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagBinaryTreeV2 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        List<Integer> integers = zigZag(node);
        System.out.println(integers);
    }

    // O(n) time | O(n) space
    public static List<Integer> zigZag(Node node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean rightToLeft = true;
        currLevel.add(node);
        while (!currLevel.isEmpty()) {
            Node current = currLevel.pop();
            result.add(current.value);
            if (rightToLeft) {
                if (current.right != null) {
                    nextLevel.push(current.right);
                }
                if (current.left != null) {
                    nextLevel.push(current.left);
                }
            } else {
                if (current.left != null) {
                    nextLevel.push(current.left);
                }
                if (current.right != null) {
                    nextLevel.push(current.right);
                }
            }
            if (currLevel.isEmpty()) {
                currLevel = nextLevel;
                nextLevel = new Stack<>();
                rightToLeft = !rightToLeft;
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
