package problems.other;

import java.util.ArrayList;
import java.util.List;

public class GetValues2 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(7);
        node.left.left.left = new Node(8);
        node.left.left.left.left = new Node(11);

        GetValues2 getValues2 = new GetValues2();
        getValues2.getValues(node, 3);

    }

    // O(n) time | O(n) space
    public List<Integer> getValues(Node node, int h) {
        if (node == null || h <= 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        getValuesHelper(node, 1, h, result);
        return result;
    }

    private void getValuesHelper(Node node, int currHeight, int height, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (currHeight == height) {
            result.add(node.val);
            return;
        }
        System.out.println(node.val);
        int newHeight = currHeight + 1;
        getValuesHelper(node.left, newHeight, height, result);
        getValuesHelper(node.right, newHeight, height, result);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
