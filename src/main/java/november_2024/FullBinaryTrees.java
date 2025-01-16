package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int n) {
        Map<Integer, List<TreeNode>> dp = new HashMap<>();
        return backtrack(n, dp);
    }

    private List<TreeNode> backtrack(int n, Map<Integer, List<TreeNode>> dp) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 1) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>();
            treeNodes.add(new TreeNode());
            return treeNodes;
        }
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        for (int l = 0; l < n; l++) {
            int r = n - 1 - l;
            List<TreeNode> leftTrees = backtrack(l, dp);
            List<TreeNode> rightTrees = backtrack(r, dp);

            for (TreeNode t1 : leftTrees) {
                for (TreeNode t2 : rightTrees) {
                    res.add(new TreeNode(0, t1, t2));
                }
            }
        }
        dp.put(n, res);
        return res;
    }


  static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
