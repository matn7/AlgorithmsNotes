package november_2025;

public class MyCalendar {

    // O(log(n)) time | O(log(n)) space
    Node root;

    public MyCalendar() {
    }

    public boolean book(int startTime, int endTime) {
        if (root == null) {
            root = new Node(startTime, endTime);
            return true;
        }
        Node curr = root;
        return helper(curr, startTime, endTime);
    }

    private boolean helper(Node curr, int startTime, int endTime) {
        if (curr == null) {
            return false;
        }
        if (endTime <= curr.startTime) {
            if (curr.left == null) {
                curr.left = new Node(startTime, endTime);
                return true;
            }
            return helper(curr.left, startTime, endTime);
        } else if (startTime >= curr.endTime) {
            if (curr.right == null) {
                curr.right = new Node(startTime, endTime);
                return true;
            }
            return helper(curr.right, startTime, endTime);
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
