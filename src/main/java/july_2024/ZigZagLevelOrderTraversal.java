package july_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagLevelOrderTraversal {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(9);
        node.right = new Node(20);
        node.right.left = new Node(15);
        node.right.right = new Node(7);
        node.right.left.left = new Node(13);
        node.right.left.right = new Node(12);
        node.right.right.left = new Node(11);
        node.right.right.right = new Node(10);

        List<List<Integer>> result = zigZagLevelOrderTraversal(node);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static List<List<Integer>> zigZagLevelOrderTraversal(Node node) {
        if (node == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> newLevel = new Stack<>();
        currLevel.add(node);
        while (!currLevel.isEmpty()) {
            int size = currLevel.size();
            List<Integer> currElems = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node topElem = currLevel.pop();
                currElems.add(topElem.value);
                if (leftToRight) {
                    if (topElem.left != null) {
                        newLevel.push(topElem.left);
                    }
                    if (topElem.right != null) {
                        newLevel.push(topElem.right);
                    }
                } else {
                    if (topElem.right != null) {
                        newLevel.push(topElem.right);
                    }
                    if (topElem.left != null) {
                        newLevel.push(topElem.left);
                    }
                }
                if (currLevel.isEmpty()) {
                    currLevel = newLevel;
                    newLevel = new Stack<>();
                    leftToRight = !leftToRight;
                }
            }
            result.add(currElems);
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
