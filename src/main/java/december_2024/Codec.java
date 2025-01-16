package december_2024;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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
        serializeHelper(root, builder);
        return builder.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            builder.append(" ");
            return;
        }
        builder.append(node.val);
        builder.append(" ");
        serializeHelper(node.left, builder);
        serializeHelper(node.right, builder);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        List<String> arr = Arrays.stream(split).toList();
        Iterator<String> iterator = arr.iterator();

        return deserializeHelper(iterator);
    }

    private TreeNode deserializeHelper(Iterator<String> iterator) {
        String next = iterator.next();
        if (next.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(next));
        node.left = deserializeHelper(iterator);
        node.right = deserializeHelper(iterator);
        return node;
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
