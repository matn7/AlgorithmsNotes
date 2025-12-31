package december_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Codec2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        Codec2 codec2 = new Codec2();
        String serialized = codec2.serialize(root);
        System.out.println(serialized);

        TreeNode deserialized = codec2.deserialize(serialized);
        System.out.println();
    }

    // O(n) time | O(n) space
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
        Iterator<String> iterator = new ArrayList<>(Arrays.asList(split)).iterator();

        return helper(iterator);
    }

    private TreeNode helper(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("#")) {
            return null;
        }
        TreeNode newNode = new TreeNode(Integer.parseInt(next));
        newNode.left = helper(iterator);
        newNode.right = helper(iterator);
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
