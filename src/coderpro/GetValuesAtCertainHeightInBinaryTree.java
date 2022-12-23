package coderpro;

import java.util.ArrayList;
import java.util.List;

public class GetValuesAtCertainHeightInBinaryTree {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.right = new TreeNode(7);

        GetValuesAtCertainHeightInBinaryTree getValues = new GetValuesAtCertainHeightInBinaryTree();
        getValues.valuesAtLevel(node, 2);

    }

    // O(n) time | O(n) space
    public List<Integer> valuesAtLevel(TreeNode node, int depth) {
        List<Integer> result = new ArrayList<>();
        valuesAtLevelHelper(node, depth, result);
        return result;
    }

    private void valuesAtLevelHelper(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (depth == 1) {
            result.add(node.value);
        } else {
            valuesAtLevelHelper(node.left, depth - 1, result);
            valuesAtLevelHelper(node.right, depth - 1, result);
        }
    }


}
