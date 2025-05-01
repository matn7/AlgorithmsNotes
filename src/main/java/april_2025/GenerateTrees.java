package april_2025;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> result = generateTrees.generateTrees(3);
        System.out.println(result);
    }

    // O(2^n*n) time | O(2^n*n) space
    public List<TreeNode> generateTrees(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        List<TreeNode> treeNodes = genTree(nums);
        return treeNodes;
    }

    private List<TreeNode> genTree(List<Integer> nums) {
        if (nums.isEmpty()) {
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
            List<TreeNode> lefts = genTree(lNums);

            List<Integer> rNums = new ArrayList<>();
            for (int i = n + 1; i < nums.get(nums.size() - 1) + 1; i++) {
                rNums.add(i);
            }
            List<TreeNode> rights = genTree(rNums);

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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
