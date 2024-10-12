package star;


public class FindSubtree {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(4);
        a.right = new Node(5);
        a.left.left = new Node(3);
        a.left.right = new Node(2);
        a.right.left = new Node(4);
        a.right.right = new Node(5);
        a.right.left.left = new Node(3);
        a.right.left.right = new Node(7);
        a.right.left.left.left = new Node(13);
        a.right.left.right.right = new Node(11);
        a.right.left.right.left = new Node(12);


        Node b = new Node(4);
        b.left = new Node(3);
        b.right = new Node(7);

        FindSubtree findSubtree = new FindSubtree();
        boolean result = findSubtree.findSubtree(a, b);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public boolean findSubtree(Node a, Node b) {
        if (a == null) {
            return false;
        }

        if (a.val == b.val) {
            boolean left = findSubtreeHelper(a.left, b.left);
            boolean right = findSubtreeHelper(a.right, b.right);
            return left && right;
        }
        boolean foundLeft = findSubtree(a.left, b);
        if (foundLeft) {
            return true;
        }
        return findSubtree(a.right, b);
    }

    private boolean findSubtreeHelper(Node a, Node b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        System.out.println(a.val + ":" + b.val);
        if (a.val != b.val) {
            return false;
        }
        boolean left = findSubtreeHelper(a.left, b.left);
        return left && findSubtreeHelper(a.right, b.right);
    }

    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

}
