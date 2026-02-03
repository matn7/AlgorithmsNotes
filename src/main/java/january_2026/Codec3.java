package january_2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Codec3 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec3 codec3 = new Codec3();
        String serialized = codec3.serialize(root);
        TreeNode deserialized = codec3.deserialize(serialized);
        System.out.println(deserialized);
    }

    // O(n) time | O(n) space
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        inOrder(root, builder);
        return builder.toString();
    }

    private void inOrder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            return;
        }
        builder.append(node.val);
        builder.append(" ");
        inOrder(node.left, builder);
        builder.append(" ");
        inOrder(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        Iterator<String> iterator = new ArrayList<>(Arrays.asList(split)).iterator();
        return build(iterator);
    }

    private TreeNode build(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("#")) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(next));
        newNode.left = build(iterator);
        newNode.right = build(iterator);
        return newNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
