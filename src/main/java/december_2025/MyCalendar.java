package december_2025;

public class MyCalendar {

    // O(log(n)) time | O(n) space
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
        if (node == null) {
            return false;
        }
        if (node.startTime >= endTime) {
            if (node.left == null) {
                node.left = new Node(startTime, endTime);
                return true;
            }
            return addNode(node.left, startTime, endTime);
        } else if (node.endTime <= startTime) {
            if (node.right == null) {
                node.right = new Node(startTime, endTime);
                return true;
            }
            return addNode(node.right, startTime, endTime);
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
