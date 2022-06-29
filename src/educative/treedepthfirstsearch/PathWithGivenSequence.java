package educative.treedepthfirstsearch;

public class PathWithGivenSequence {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }


    // O(n) time | O(n) space
    public static boolean findPath(TreeNode root, int[] sequence) {
        if (root == null) {
            return sequence.length == 0;
        }

        return findPathRecursive(root, sequence, 0);
    }

    private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIdx) {
        if (currentNode == null) {
            return false;
        }

        if (sequenceIdx >= sequence.length || currentNode.val != sequence[sequenceIdx]) {
            return false;
        }

        if (currentNode.left == null && currentNode.right == null && sequenceIdx == sequence.length - 1) {
            return true;
        }

        return findPathRecursive(currentNode.left, sequence, sequenceIdx + 1)
                || findPathRecursive(currentNode.right, sequence, sequenceIdx + 1);
    }

}
