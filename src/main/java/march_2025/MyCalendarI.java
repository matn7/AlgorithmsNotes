package march_2025;

public class MyCalendarI {

    TreeNode root;

    public MyCalendarI() {
        root = null;
    }

    // O(log(n)) time | O(n) spacce
    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new TreeNode(startTime, endTime);
            return true;
        }
        return insert(root, startTime, endTime);
    }

    private boolean insert(TreeNode node, int startTime, int endTime) {
        if (endTime <= node.start) {
            // insert left
            if (node.left == null) {
                node.left = new TreeNode(startTime, endTime);
                return true;
            }
            return insert(node.left, startTime, endTime);
        } else if (startTime >= node.end) {
            // insert right
            if (node.right == null) {
                node.right = new TreeNode(startTime, endTime);
                return true;
            }
            return insert(node.right, startTime, endTime);
        }
        return false;
    }

    static class TreeNode {
        int start;
        int end;
        TreeNode left;
        TreeNode right;

        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
