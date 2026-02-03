package january_2026;

import java.util.Arrays;
import java.util.Iterator;

public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        System.out.println(serialized);

        TreeNode deserialized = codec.deserialize(serialized);

        System.out.println(deserialized);

    }

    // Encodes a tree to a single string.
    // O(n) time | O(h) space
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    private void preOrder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            return;
        }
        builder.append(node.val);
        builder.append(" ");
        preOrder(node.left, builder);
        builder.append(" ");
        preOrder(node.right, builder);
    }

    // Decodes your encoded data to tree.
    // O(n) time | O(n) space
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        Iterator<String> iterator = Arrays.asList(split).iterator();

        return buildTree(iterator);
    }

    private TreeNode buildTree(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("#")) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(next));
        newNode.left = buildTree(iterator);
        newNode.right = buildTree(iterator);
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
