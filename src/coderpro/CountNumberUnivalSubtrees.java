package coderpro;

public class CountNumberUnivalSubtrees {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        node.left = new TreeNode(1);
        node.right = new TreeNode(0);
        node.right.left = new TreeNode(1);
        node.right.left.left = new TreeNode(1);
        node.right.left.right = new TreeNode(1);
        node.right.right = new TreeNode(0);

        CountNumberUnivalSubtrees count = new CountNumberUnivalSubtrees();
        int result = count.countUnivalSubtrees(node);
        System.out.println(result);
    }

    public int countUnivalSubtrees(TreeNode node) {
        UnivalInfo info = countUnivalSubtreesHelper(node);
        return info.count;
    }

    private UnivalInfo countUnivalSubtreesHelper(TreeNode node) {
        if (node == null) {
            return new UnivalInfo(0, true);
        }

        UnivalInfo left = countUnivalSubtreesHelper(node.left);
        UnivalInfo right = countUnivalSubtreesHelper(node.right);

        if (left.is_unival && right.is_unival
                && (node.left == null || node.value == node.left.value)
                && (node.right == null || node.value == node.right.value)) {
            return new UnivalInfo(left.count + right.count + 1, true);
        }
        return new UnivalInfo(left.count + right.count, false);
    }

}

class UnivalInfo {
    int count;
    boolean is_unival;

    public UnivalInfo(int count, boolean is_unival) {
        this.count = count;
        this.is_unival = is_unival;
    }
}
