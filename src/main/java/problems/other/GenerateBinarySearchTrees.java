package problems.other;

import java.util.ArrayList;
import java.util.List;

public class GenerateBinarySearchTrees {

    public static void main(String[] args) {
        int input = 3;

        GenerateBinarySearchTrees generate = new GenerateBinarySearchTrees();
        generate.generateTrees(input);
    }

    // O(n*2^n) time | O(n*2^n) space
    public List<TreeNode> generateTrees(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<TreeNode> result = gen_tree(nums);
        for (TreeNode node : result) {
            preOrder(node);
            System.out.println();
        }
        return result;
    }

    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    private List<TreeNode> gen_tree(List<Integer> nums) {
        if (nums.size() == 0) {
            List<TreeNode> elemList = new ArrayList<>();
            elemList.add(null);
            return elemList;
        }
        if (nums.size() == 1) {
            TreeNode element = new TreeNode(nums.get(0));
            List<TreeNode> elemList = new ArrayList<>();
            elemList.add(element);
            return elemList;
        }
        List<TreeNode> bsts = new ArrayList<>();

        for (int n : nums) {
            List<Integer> lNums = new ArrayList<>();
            for (int i = nums.get(0); i < n; i++) {
                lNums.add(i);
            }
            List<TreeNode> lefts = gen_tree(lNums);

            List<Integer> rNums = new ArrayList<>();
            for (int i = n + 1; i < nums.get(nums.size() - 1) + 1; i++) {
                rNums.add(i);
            }
            List<TreeNode> rights = gen_tree(rNums);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode tree = new TreeNode(n);
                    tree.left = left;
                    tree.right = right;

                    bsts.add(tree);
                }
            }
        }
        return bsts;
    }
}


