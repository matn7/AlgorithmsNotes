package november_2025;

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
        TreeNode deserialize = codec.deserialize(serialized);
        System.out.println(deserialize);
    }

    // Encodes a tree to a single string.
    // O(n) time | O(h) space
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    private void dfs(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            return;
        }
        builder.append(node.val);
        builder.append(" ");
        dfs(node.left, builder);
        builder.append(" ");
        dfs(node.right, builder);
    }

    // Decodes your encoded data to tree.
    // O(n) time | O(n) space
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        List<String> arr = new ArrayList<>(Arrays.asList(split));
        Iterator<String> iterator = arr.iterator();
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
