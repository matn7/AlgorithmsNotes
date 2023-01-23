package coderpro;

import java.util.ArrayList;
import java.util.List;

public class FindSubtree {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(4);
        a.right = new TreeNode(5);
        a.left.left = new TreeNode(3);
        a.left.right = new TreeNode(2);
        a.right.left = new TreeNode(4);
        a.right.right = new TreeNode(5);

        TreeNode b = new TreeNode(4);
        b.left = new TreeNode(3);
        b.right = new TreeNode(2);

        FindSubtree findSubtree = new FindSubtree();
        boolean result = findSubtree.find_subtree2(a, b);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public boolean find_subtree2(TreeNode a, TreeNode b) {
        if (a == null) {
            return false;
        }

        boolean is_match = a.value == b.value;

        if (is_match) {
            boolean is_match_left = (a.left == null || b.left == null) || find_subtree2(a.left, b.left);
            if (is_match_left) {
                boolean is_right_match = (a.right == null || b.right == null) || find_subtree2(a.right, b.right);
                if (is_right_match) {
                    return true;
                }
            }
        }
        return find_subtree2(a.left, b) || find_subtree2(a.right, b);
    }

    // O(n*m) time | O(n*m) space
    public boolean find_subtree(TreeNode a, TreeNode b) {
        boolean contains = pre(a).contains(pre(b));
        return contains;
    }

    private String pre(TreeNode n) {
        if (n == null) {
            return "#";
        }
        return n.value + pre(n.left) + pre(n.right);
    }

    // ====================
    // O(n + m) time | O(n + m) space
    public boolean findSubtree2(TreeNode a, TreeNode b) {
        StringBuilder builderA = new StringBuilder();
        StringBuilder builderB = new StringBuilder();

        preOrderBuilder(a, builderA);
        preOrderBuilder(b, builderB);

        String strA = builderA.toString();
        String strB = builderB.toString();

        return strA.length() > strB.length() ? strA.contains(strB) : strB.contains(strA);
    }

    public boolean findSubtree(TreeNode a, TreeNode b) {
        List<String> elemsA = new ArrayList<>();
        List<String> elemsB = new ArrayList<>();
        preOrder(a, elemsA);
        preOrder(b, elemsB);

        String strA = populateString(elemsA);
        String strB = populateString(elemsB);

        return strA.length() > strB.length() ? strA.contains(strB) : strB.contains(strA);
    }

    private String populateString(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str : strs) {
            builder.append(str);
        }
        return builder.toString();
    }

    private void preOrder(TreeNode node, List<String> strs) {
        if (node == null) {
            strs.add("#");
            return;
        }
        strs.add(String.valueOf(node.value));
        preOrder(node.left, strs);
        preOrder(node.right, strs);
    }

    private void preOrderBuilder(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("#");
            return;
        }
        builder.append(node.value);
        preOrderBuilder(node.left, builder);
        preOrderBuilder(node.right, builder);
    }

}
