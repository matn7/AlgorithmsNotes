package november_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeSerialization {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(3);
        tree.right = new Node(4);
        tree.left.left = new Node(2);
        tree.left.right = new Node(5);
        tree.right.right = new Node(7);

        String result = serialize(tree);
        System.out.println(result);
        Node deserialize = deserialize(result);
        System.out.println();
    }

    // O(n) time | O(n) space
    public static String serialize(Node tree) {
        if (tree == null) {
            return "#";
        }
        return tree.value + " " + serialize(tree.left) + " " + serialize(tree.right);
    }

    // O(n) time | O(n) space
    public static Node deserialize(String string) {
        String[] split = string.split(" ");
        List<String> elements = new ArrayList<>(Arrays.asList(split));
        Iterator<String> iterator = elements.iterator();
        return deserializeHelper(iterator);
    }

    private static Node deserializeHelper(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("#")) {
            return null;
        }
        Node node = new Node(Integer.valueOf(next));
        node.left = deserializeHelper(iterator);
        node.right = deserializeHelper(iterator);
        return node;
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
