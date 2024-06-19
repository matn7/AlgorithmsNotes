package april_2024;

import java.util.*;

public class ZigZagOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);
        node.right.right.right = new Node(10);
        node.right.right.left = new Node(11);
        node.right.left.right = new Node(12);
        node.right.left.left = new Node(13);

        List<List<Integer>> result = zigzagLevelOrder(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<List<Integer>> zigzagLevelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();

        queue.offer(root);
        boolean zigzag = false;

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int qSize = queue.size();

            for (int i = 0; i < qSize; i++) {
                if (zigzag) {
                    Node node = queue.pollFirst();
                    level.add(node.value);
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                } else {
                    Node node = queue.pollLast();
                    level.add(node.value);
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                }
            }
            result.add(level);
            zigzag = !zigzag;

        }


        return result;
    }

    // O(n) time | O(n) space
    public static List<List<Integer>> zigZagTraversal(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();

        boolean leftToRight = true;
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        currLevel.push(node);

        while (!currLevel.isEmpty()) {
            List<Integer> levelElements = new ArrayList<>();
            int count = currLevel.size();

            while (count > 0) {
                Node topElement = currLevel.pop();
                levelElements.add(topElement.value);
                if (leftToRight) {
                    if (topElement.left != null) {
                        nextLevel.push(topElement.left);
                    }
                    if (topElement.right != null) {
                        nextLevel.push(topElement.right);
                    }
                } else {
                    if (topElement.right != null) {
                        nextLevel.push(topElement.right);
                    }
                    if (topElement.left != null) {
                        nextLevel.push(topElement.left);
                    }
                }
                count--;
                if (count == 0) {
                    leftToRight = !leftToRight;
                    currLevel = nextLevel;
                    nextLevel = new Stack<>();
                }
            }

            result.add(levelElements);
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
