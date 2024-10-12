package august_2024;

public class FindSubtree {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(4);
        a.right = new Node(5);
        a.left.left = new Node(3);
        a.left.right = new Node(2);
        a.right.left = new Node(4);
        a.right.right = new Node(5);
        a.left.left.left = new Node(8);
        a.left.left.right = new Node(12);

        Node b = new Node(4);
        b.left = new Node(3);
        b.right = new Node(2);

        boolean result = findSubtree(a, b);
        System.out.println(result);
    }

    public static boolean findSubtree(Node a, Node b) {
        if (a == null) {
            return false;
        }
        if (b == null) {
            return true;
        }
        if (areIdentical(a, b)) {
            return true;
        }
        return findSubtree(a.left, b) || findSubtree(a.right, b);
    }

    private static boolean areIdentical(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        return a.value == b.value && areIdentical(a.left, b.left) && areIdentical(a.right, b.right);
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
