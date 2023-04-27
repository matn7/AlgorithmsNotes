package coderpro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TreeSerialization {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(4);
        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(7);

        TreeSerialization treeSerialization = new TreeSerialization();
        String result = treeSerialization.serialize(node);
        System.out.println(result);

        TreeNode deserialize = treeSerialization.deserialize(result);
        System.out.println();
        treeSerialization.preOrder(deserialize);
    }

    // ********
    // * STAR *
    // ********

    // O(n) time | O(n) space
    public String serialize(TreeNode node) {
        if (node == null) {
            return "#";
        }
        return node.value + " " + serialize(node.left) + " " + serialize(node.right);
    }

    // O(n) time | O(n) space
    public TreeNode deserialize(String str) {
        String[] s = str.split(" ");
        List<String> elements = new ArrayList<>(Arrays.asList(s));
        Iterator<String> values = elements.iterator();

        TreeNode result = deserialize_helper(values);
        return result;
    }

    private TreeNode deserialize_helper(Iterator<String> values) {
        String value = values.next();
        if (value.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = deserialize_helper(values);
        node.right = deserialize_helper(values);
        return node;
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

}
