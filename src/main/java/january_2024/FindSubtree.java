package january_2024;

public class FindSubtree {

    public static void main(String[] args) {
        Node n = new Node(1);
        n.left = new Node(4);
        n.right = new Node(5);
        n.left.left = new Node(3);
        n.left.right = new Node(2);
        n.right.left = new Node(4);
        n.right.right = new Node(1);

        Node b = new Node(4);
        b.left = new Node(3);
        b.right = new Node(2);

        boolean result = findSubtree(n, b);
        System.out.println(result);
    }

    // O(n*m) time | O(n*m) space
    public static boolean findSubtree(Node a, Node b) {
        if (a == null) {
            return false;
        }
        boolean isMatch = a.value == b.value;
        if (isMatch) {
            boolean isMatchLeft = (a.left == null || b.left == null) || findSubtree(a.left, b);
            if (isMatchLeft) {
                boolean isMatchRight = (a.right == null || b.right == null) || findSubtree(a.right, b);
                if (isMatchRight) {
                    return true;
                }
            }
        }

        return findSubtree(a.left, b) || findSubtree(a.right, b);
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
