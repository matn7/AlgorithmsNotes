package august_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Codec {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String serialized = codec.serialize(root);
        System.out.println(serialized);
    }

    // O(n) time | O(n) space
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    private void dfs(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            builder.append(" ");
            return;
        }
        builder.append(node.val);
        builder.append(" ");
        dfs(node.left, builder);
        dfs(node.right, builder);
    }

    // O(n) time | O(n) space
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        Iterator<String> iterator = new ArrayList<>(Arrays.stream(split).toList()).iterator();
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
