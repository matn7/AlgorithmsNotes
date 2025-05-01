package april_2025;

public class MyCalendar3 {

    Node root;

    public MyCalendar3() {
        root = null;
    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }
        return helper(root, startTime, endTime);
    }

    private boolean helper(Node node, int startTime, int endTime) {
        if (endTime <= node.startTime) {
            // left
            if (node.left == null) {
                node.left = new Node(startTime, endTime);
                return true;
            }
            return helper(node.left, startTime, endTime);
        } else if (startTime >= node.endTime) {
            // right
            if (node.right == null) {
                node.right = new Node(startTime, endTime);
                return true;
            }
            return helper(node.right, startTime, endTime);
        } else {
            return false;
        }
    }

    static class Node {
        int startTime;
        int endTime;
        Node left;
        Node right;

        public Node(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

}
