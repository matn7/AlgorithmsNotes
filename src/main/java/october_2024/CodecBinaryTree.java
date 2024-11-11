package october_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CodecBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CodecBinaryTree codecBinaryTree = new CodecBinaryTree();
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
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(" ");
        List<String> splitArr = new ArrayList<>(Arrays.asList(split));
        Iterator<String> iterator = splitArr.iterator();
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
