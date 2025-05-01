package april_2025;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeAndDeserializeBinaryTree serialize = new SerializeAndDeserializeBinaryTree();
        String serialized = serialize.serialize(root);
        TreeNode deserialized = serialize.deserialize(serialized);
        System.out.println(deserialized);
    }

    // O(n) time | O(n) space
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        dfs(root, builder);
        return builder.toString();
    }

    // Encodes a tree to a single string.
    public void dfs(TreeNode root, StringBuilder builder) {
        if (root == null) {
            builder.append("#");
            builder.append(" ");
            return;
        }
        builder.append(root.val);
        builder.append(" ");
        dfs(root.left, builder);
        dfs(root.right, builder);
    }

    // O(n) time | O(n) space
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        List<String> array = new ArrayList<>(Arrays.asList(split));
        Iterator<String> iterator = array.iterator();

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
