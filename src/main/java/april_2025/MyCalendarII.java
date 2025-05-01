package april_2025;

public class MyCalendarII {

    public static void main(String[] args) {
        MyCalendarII myCalendarII = new MyCalendarII();
        System.out.println(myCalendarII.book(10, 20));
        System.out.println(myCalendarII.book(15, 25));
        System.out.println(myCalendarII.book(20, 30));
        System.out.println(myCalendarII.book(5, 8));
        System.out.println();
    }

    Node root;

    // O(n) time | O(n) space
    public MyCalendarII() {
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
        if (node.start >= endTime) {
            if (node.left == null) {
                node.left = new Node(startTime, endTime);
                return true;
            }
            return helper(node.left, startTime, endTime);
        } else if (node.end <= startTime) {
            if (node.right == null) {
                node.right = new Node(startTime, endTime);
                return true;
            }
            return helper(node.right, startTime, endTime);
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
