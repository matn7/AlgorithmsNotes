package april_2025;

public class MyCalendarV2 {

    Node root;

    public MyCalendarV2() {
        root = null;
    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }
        return insert(root, startTime, endTime);
    }

    private boolean insert(Node node, int start, int end) {
        if (end <= node.start) {
            if (node.left == null) {
                node.left = new Node(start, end);
                return true;
            }
            return insert(node.left, start, end);
        } else if (start >= node.end) {
            if (node.right == null) {
                node.right = new Node(start, end);
                return true;
            }
            return insert(node.right, start, end);
        }
        return false;
    }

    static class Node {
        int start;
        int end;

        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
