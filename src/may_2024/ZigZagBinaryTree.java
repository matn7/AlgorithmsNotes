package may_2024;

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

        List<Integer> integers = zigZagTraverse(node);
        System.out.println(integers);
    }

    // O(n) time | O(n) space
    public static List<Integer> zigZagTraverse(Node node) {
        List<Integer> result = new ArrayList<>();
        boolean rightToLeft = true;
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        currLevel.push(node);

        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            for (int i = 0; i < size; i++) {
                Node top = currLevel.pop();
                result.add(top.value);

                if (rightToLeft) {
                    if (top.right != null) {
                        nextLevel.push(top.right);
                    }
                    if (top.left != null) {
                        nextLevel.push(top.left);
                    }
                } else {
                    if (top.left != null) {
                        nextLevel.push(top.left);
                    }
                    if (top.right != null) {
                        nextLevel.push(top.right);
                    }
                }
            }
            currLevel = nextLevel;
            nextLevel = new Stack<>();
            rightToLeft = !rightToLeft;
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
