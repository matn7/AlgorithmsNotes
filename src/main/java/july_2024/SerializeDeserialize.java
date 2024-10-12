package july_2024;

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

        String serialize = serialize(node);
        Node deserialize = deserialize(serialize);
        System.out.println(deserialize);
    }

    // O(n) time | O(n) space
    public static String serialize(Node node) {
        if (node == null) {
            return "";
        }
        return preOrder(node);
    }

    private static String preOrder(Node node) {
        if (node == null){
            return "#";
        }
        return node.value + " " + preOrder(node.left) + " " + preOrder(node.right);
    }

    // O(n) time | O(n) space
    private static Node deserialize(String str) {
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
