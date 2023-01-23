package coderpro;

import java.util.ArrayList;
import java.util.List;

public class NumberOfCousins {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(6);
        node.right.right = new TreeNode(5);

        NumberOfCousins numberOfCousins = new NumberOfCousins();
        numberOfCousins.list_cousins(node, node.right.right);
    }

    // O(n) time | O(n) space
    public List<TreeNode> list_cousins(TreeNode node, TreeNode target) {
        CousinTree treeInfo = find_node(node, target, null, 0);
        List<TreeNode> result = new ArrayList<>();
        nodes_at_height(node, treeInfo.height, treeInfo.parent, result);
        return result;
    }

    private void nodes_at_height(TreeNode node, int height, TreeNode exclude, List<TreeNode> result) {
        if (node == null || node == exclude) {
            return;
        }
        if (height == 0) {
            result.add(node);
        }
        nodes_at_height(node.left, height - 1, exclude, result);
        nodes_at_height(node.right, height - 1, exclude, result);
    }


    private CousinTree find_node(TreeNode node, TreeNode target, TreeNode parent, int height) {
        if (node == null) {
            return null;
        }
        if (node == target) {
            return new CousinTree(height, parent);
        }
        CousinTree left = find_node(node.left, target, node, height + 1);
        if (left != null) {
            return left;
        }

        return  find_node(node.right, target, node, height + 1);
    }

}

class CousinTree {
    int height;
    TreeNode parent;

    public CousinTree(int height, TreeNode parent) {
        this.height = height;
        this.parent = parent;
    }
}
