package january_2024;

import java.util.ArrayList;
import java.util.List;

public class ValueAtHeight {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(7);
        node.right.right.left = new Node(17);

        valuesAtHeight(node, 2);
    }

    // O(n) time | O(n) space
    public static List<Integer> valuesAtHeight(Node node, int height) {
        if (height <= 0) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        dfs(node, 1, height, result);
        return result;
    }

    private static void dfs(Node node, int currHeight, int targetHeight, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (currHeight == targetHeight) {
            result.add(node.value);
        }
        dfs(node.left, currHeight + 1, targetHeight, result);
        dfs(node.right, currHeight + 1, targetHeight, result);
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
