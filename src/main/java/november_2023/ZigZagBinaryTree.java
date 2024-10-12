package november_2023;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagBinaryTree {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        List<Integer> result = zigZagTraverse(node);
        System.out.println(result);

    }

    // O(n) time | O(n) space
    public static List<Integer> zigZagTraverse(Node tree) {

        List<Integer> result = new ArrayList<>();
        Stack<Node> currLevel = new Stack<>();
        currLevel.add(tree);
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = false;

        while (currLevel.size() > 0) {
            Node node = currLevel.pop();
            result.add(node.value);
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            if (!leftToRight) {
                if (node.right != null) {
                    nextLevel.add(node.right);
                }
                if (node.left != null) {
                    nextLevel.add(node.left);
                }
            }
            if (currLevel.size() == 0) {
                leftToRight = !leftToRight;
                currLevel = nextLevel;
                nextLevel = new Stack<>();
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
