package april_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SerializeDeserialize {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.right.left = new Node(4);
        node.right.right = new Node(5);

        String serialized = serialize(null);
        Node deserialized = deserialize(serialized);
        System.out.println(deserialized);
    }

    // O(n) time | O(n) space
    public static String serialize(Node node) {
        if (node == null) {
            return "";
        }
        return preOrder(node);
    }

//    private static String preOrder(Node node) {
//        if (node == null) {
//            return "#";
//        }
//        return node.value + " " + preOrder(node.left) + " " + preOrder(node.right);
//    }

    private static String preOrder(Node node) {
        if (node == null) {
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(node.value).append(" ");
        sb.append(preOrder(node.left)).append(" ");
        sb.append(preOrder(node.right));

        return sb.toString();
    }

    // O(n) time | O(n) space
    public static Node deserialize(String str) {
        if (str.isEmpty()) {
            return null;
        }
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
        Node newNode = new Node(Integer.parseInt(next));
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
