package march_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(2);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(1);
        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(6);

        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        List<Integer> integers = postOrderTraversal.postOrderTraversal(node);
        System.out.println(integers);
    }

    public List<Integer> postOrderTraversal(TreeNode node) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(node);

        while (!s1.isEmpty()) {
            TreeNode peek = s1.peek();
            s1.pop();
            s2.add(peek);
            if (peek.left != null) {
                s1.add(peek.left);
            }
            if (peek.right != null) {
                s1.add(peek.right);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!s2.isEmpty()) {
            result.add(s2.pop().val);
        }
        return result;
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
