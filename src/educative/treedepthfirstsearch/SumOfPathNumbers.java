package educative.treedepthfirstsearch;

public class SumOfPathNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }

    // O(n) time | O(n) space
    public static int findSumOfPathNumbers(TreeNode root) {
        return findRootToLeafPathNumbers(root, 0);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (currentNode == null) {
            return 0;
        }
        pathSum = 10 * pathSum + currentNode.val;

        if (currentNode.left == null && currentNode.right == null) {
            return pathSum;
        }

        return findRootToLeafPathNumbers(currentNode.left, pathSum) +
                findRootToLeafPathNumbers(currentNode.right, pathSum);
    }

}
