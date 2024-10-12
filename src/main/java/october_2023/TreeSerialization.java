package october_2023;

import java.util.ArrayList;
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
        Node deserialized = deserialize(serialized);

        System.out.println();

    }

    // O(n) time | O(n) space
    public static String serialize(Node node) {
        StringBuilder builder = new StringBuilder();
        preOrder(node, builder);
        return builder.toString();
    }

    private static void preOrder(Node node, StringBuilder builder) {
        if (node == null) {
            builder.append("# ");
            return;
        }
        builder.append(node.value + " ");
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }

    // O(n) time | O(n) space
    public static Node deserialize(String serialized) {
        String[] split = serialized.split(" ");
        List<String> array = new ArrayList<>(List.of(split));
        Iterator<String> iterator = array.iterator();
        return deserializeHelper(iterator);
    }

    private static Node deserializeHelper(Iterator<String> iterator) {
        String currentElement = iterator.next();
        if (currentElement.equals("#")) {
            return null;
        }
        Node newNode = new Node(Integer.valueOf(currentElement));
        newNode.left = deserializeHelper(iterator);
        newNode.right = deserializeHelper(iterator);
        return newNode;
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
