package july_2025;

class MyCalendar {

    Node root;
    public MyCalendar() {
        this.root = null;
    }

    // O(log(n)) time | O(n) space
    // O(n) time - for un balanced tree
    public boolean book(int startTime, int endTime) {
        if (this.root == null) {
            this.root = new Node(startTime, endTime);
            return true;
        }
        return bookHelper(this.root, startTime, endTime);
    }

    // [startTime, endTime]    [curr.startTime, curr.endTime]   [startTime, endTime]

    private boolean bookHelper(Node curr, int startTime, int endTime) {
        if (endTime <= curr.startTime) {
            if (curr.left == null) {
                curr.left = new Node(startTime, endTime);
                return true;
            }
            return bookHelper(curr.left, startTime, endTime);
        } else if (startTime >= curr.endTime) {
            if (curr.right == null) {
                curr.right = new Node(startTime, endTime);
                return true;
            }
            return bookHelper(curr.right, startTime, endTime);
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
