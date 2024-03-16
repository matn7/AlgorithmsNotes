package january_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeSerialization {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(4);
        node.left.left = new Node(2);
        node.left.right = new Node(5);
        node.right.right = new Node(7);

        String serialized = serialize(node);
        System.out.println(serialized);

        Node deserialized = deserialize(serialized);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static String serialize(Node node) {
        if (node == null) {
            return "#";
        }
        return node.val + " " + serialize(node.left) + " " + serialize(node.right);
    }

    // O(n) time | O(n) space
    public static Node deserialize(String str) {
        String[] split = str.split(" ");
        List<String> arr = new ArrayList<>(Arrays.asList(split));
        Iterator<String> iterator = arr.iterator();
        return deserializeHelper(iterator);
    }

    private static Node deserializeHelper(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("#")) {
            return null;
        }
        Node node = new Node(Integer.parseInt(next));
        node.left = deserializeHelper(iterator);
        node.right = deserializeHelper(iterator);
        return node;
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
