package october_2023;

import java.util.ArrayList;
import java.util.List;

public class GetValuesAtCertainHeight {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(7);
        node.right.right.left = new Node(9);

        valuesAtHeight(node, 1);
    }

    // O(n) time | O(n) space
    public static List<Integer> valuesAtHeight(Node node, int depth) {
        List<Integer> result = new ArrayList<>();
        valuesAtHeightHelper(node, depth, 1, result);
        return result;
    }

    private static void valuesAtHeightHelper(Node node, int depth, int currDepth, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (currDepth == depth) {
            result.add(node.val);
        } else {
            int newDepth = currDepth + 1;
            valuesAtHeightHelper(node.left, depth, newDepth, result);
            valuesAtHeightHelper(node.right, depth, newDepth, result);
        }
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
