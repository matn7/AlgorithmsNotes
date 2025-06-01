package may_2025;

import java.util.Arrays;
import java.util.Iterator;

public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        TreeNode deserialized = codec.deserialize(serialized);
        System.out.println(deserialized);

    }

    // Encodes a tree to a single string.
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
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        Iterator<String> iterator = Arrays.asList(split).iterator();
        return helper(iterator);
    }

    private TreeNode helper(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(next));
        root.left = helper(iterator);
        root.right = helper(iterator);
        return root;
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
