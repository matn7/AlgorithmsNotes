package april_2025;

public class CountUnivaledSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(0);
        root.right.left.left = new TreeNode(1);
        root.right.left.right = new TreeNode(1);

        CountUnivaledSubtrees countUnivaledSubtrees = new CountUnivaledSubtrees();
        int result = countUnivaledSubtrees.countUnivaledSubtrees(root);
        System.out.println(result);
    }

    private int count = 0; // Licznik univalue subtrees

    public int countUnivaledSubtrees(TreeNode root) {
        dfs(root);
        return count;
    }

    private boolean dfs(TreeNode node) {
        if (node == null) {
            return true; // Pusty węzeł traktujemy jako univalue
        }

        // Rekurencyjnie sprawdzamy lewe i prawe poddrzewo
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        // Jeśli którekolwiek dziecko jest nie-univalue, to to drzewo również nie jest univalue
        if (!left || !right) {
            return false;
        }

        // Sprawdzamy, czy wartość węzła jest zgodna z wartościami dzieci
        if ((node.left != null && node.val != node.left.val) || (node.right != null && node.val != node.right.val)) {
            return false;
        }

        // Zwiększamy licznik, jeśli to poddrzewo jest univalue
        count++;
        return true; // Zwracamy true, ponieważ poddrzewo jest univalue
    }

    // Definicja TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
