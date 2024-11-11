package october_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CodecBinaryTree2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CodecBinaryTree2 codecBinaryTree = new CodecBinaryTree2();
        String serialize = codecBinaryTree.serialize(root);
        TreeNode deserialize = codecBinaryTree.deserialize(serialize);
        System.out.println(deserialize);
    }

//    // O(n) time | O(n) space
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "#";
//        }
//        return root.val + " " + serialize(root.left) + " " + serialize(root.right);
//    }

    Integer i = 0;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("# ");
            return;
        }
        sb.append(node.val).append(" ");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // O(n) time | O(n) space
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        List<String> vals = new ArrayList<>(Arrays.asList(split));
        i = 0;
        return dfs(vals);
    }

    private TreeNode dfs(List<String> vals) {
        if (vals.contains("#")) {
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals.get(i)));
        i++;
        node.left = dfs(vals);
        node.right = dfs(vals);
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
