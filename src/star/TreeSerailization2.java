package star;

import udemy.binarytree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeSerailization2 {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(3);
        node.right = new Node(4);
        node.left.left = new Node(2);
        node.left.right = new Node(5);
        node.right.right = new Node(7);

        TreeSerailization2 treeSerailization2 = new TreeSerailization2();
        String result = treeSerailization2.serialize(node);
        System.out.println(result);

        Node deserialize = treeSerailization2.deserialize(result);
        System.out.println();

    }

    public String serialize(Node node) {
        StringBuilder builder = new StringBuilder();
        serializeHelper(node, builder);
        return builder.toString();
    }

    public Node deserialize(String serialized) {
        String[] elements = serialized.split(" ");
        List<String> elems = new ArrayList<>(Arrays.asList(elements));
        Iterator<String> iterator = elems.iterator();
        return deserializeHelper(iterator);
    }

    private Node deserializeHelper(Iterator<String> iterator) {
        String current = iterator.next();
        if (current.equals("#")) {
            return null;
        }
        Node node = new Node(Integer.parseInt(current));
        node.left = deserializeHelper(iterator);
        node.right = deserializeHelper(iterator);
        return node;
    }

    private void serializeHelper(Node node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            return;
        }
        builder.append(node.val + " ");
        serializeHelper(node.left, builder);
        builder.append(" ");
        serializeHelper(node.right, builder);
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
