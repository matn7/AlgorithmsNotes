package star;

import educative.fastandslowpointers.HappyNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeSerialization {

    // O(n) time | O(n) space
    public String serialize(Node node) {
        if (node == null) {
            return "#";
        }
        return node.val + " " + serialize(node.left) + " " + serialize(node.right);
    }

    // O(n) time | O(n) space
    public Node deserialize(String str) {
        String[] split = str.split(" ");
        List<String> array = new ArrayList<>();
        array.addAll(Arrays.asList(split));

        Iterator<String> iterator = array.iterator();

        return deserializeHelper(iterator);
    }

    private Node deserializeHelper(Iterator<String> iterator) {
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
