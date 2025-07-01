package june_2025;

public class MyCalendar {

    Node root;
    public MyCalendar() {
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
        if (end <= node.startTime) {
            if (node.left == null) {
                node.left = new Node(start, end);
                return true;
            }
            return insert(node.left, start, end);
        } else if (start >= node.endTime) {
            if (node.right == null) {
                node.right = new Node(start, end);
                return true;
            }
            return insert(node.right, start, end);
        }
        return false;
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
