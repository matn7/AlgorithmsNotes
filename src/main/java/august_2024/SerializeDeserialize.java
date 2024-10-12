package august_2024;

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
        System.out.println(serialize);

        Node deserialize = deserialize(serialize);
        System.out.println(deserialize);
    }

    public static String serialize(Node node) {
        StringBuilder sb = new StringBuilder();
        preOrder(node, sb);
        return sb.toString();
    }

    private static void preOrder(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("# ");
            return;
        }
        sb.append(node.value).append(" ");
        preOrder(node.left, sb);
        preOrder(node.right, sb);
    }

    public static Node deserialize(String serialized) {
        String[] split = serialized.split(" ");
        List<String> splitted = new ArrayList<>(Arrays.asList(split));
        Iterator<String> iterator = splitted.iterator();
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
