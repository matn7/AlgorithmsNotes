package january_2026;

public class MyCalendar {

    Node root;

    public MyCalendar() {

    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }
        return addNode(root, startTime, endTime);
    }

    private boolean addNode(Node node, int startTime, int endTime) {
        if (endTime <= node.start) {
            if (node.left == null) {
                node.left = new Node(startTime, endTime);
                return true;
            }
            return addNode(node.left, startTime, endTime);
        } else if (startTime >= node.end) {
            if (node.right == null) {
                node.right = new Node(startTime, endTime);
                return true;
            }
            return addNode(node.right, startTime, endTime);
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
