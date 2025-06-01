package may_2025;

public class MyCalendar {

    Node root;

    public MyCalendar() {

    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }
        return add(root, startTime, endTime);
    }

    private boolean add(Node node, int startTime, int endTime) {
        if (endTime <= node.startTime) {
            if (node.left == null) {
                node.left = new Node(startTime, endTime);
                return true;
            }
            return add(node.left, startTime, endTime);
        } else if (startTime >= node.endTime) {
            if (node.right == null) {
                node.right = new Node(startTime, endTime);
                return true;
            }
            return add(node.right, startTime, endTime);
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
