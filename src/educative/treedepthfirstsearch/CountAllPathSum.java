package educative.treedepthfirstsearch;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }

    // O(n^2) time | O(n) space
    public static int countPaths(TreeNode root, int s) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathRecursive(root, s, currentPath);
    }

    private static int countPathRecursive(TreeNode currentNode, int s, List<Integer> currentPath) {
        if (currentNode == null) {
            return 0;
        }

        currentPath.add(currentNode.val);
        int pathCount = 0;
        int pathSum = 0;

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == s) {
                pathCount++;
            }
        }

        pathCount += countPathRecursive(currentNode.left, s, currentPath);
        pathCount += countPathRecursive(currentNode.right, s, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return pathCount;
    }

}
