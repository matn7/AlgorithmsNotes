package may_2025;

public class KthSmallest {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k = 3;

//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(4);
//        root.left.right = new TreeNode(2);
//        int k = 1;

        KthSmallest kthSmallest = new KthSmallest();
        int result = kthSmallest.kthSmallest(root, k);
        System.out.println(result);
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeInfo info = new TreeInfo(0, 0);
        dfs(info, root, k);
        return info.value;
    }

    private void dfs(TreeInfo info, TreeNode node, int k) {
        if (node == null) {
            return;
        }
        if (info.pos == k) {
            return;
        }
        dfs(info, node.left, k);
        if (info.pos < k) {
            info.pos++;
            info.value = node.val;
            dfs(info, node.right, k);
        }
    }

    static class TreeInfo {
        int pos;
        int value;

        public TreeInfo(int pos, int value) {
            this.pos = pos;
            this.value = value;
        }
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
