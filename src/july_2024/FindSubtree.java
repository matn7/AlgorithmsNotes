package july_2024;

public class FindSubtree {

    public static void main(String[] args) {
        Node a = new Node(1);
        a.left = new Node(4);
        a.right = new Node(5);
        a.left.left = new Node(3);
        a.left.right = new Node(2);
        a.right.left = new Node(4);
        a.right.right = new Node(5);

        Node b = new Node(4);
        b.left = new Node(3);
        b.right = new Node(2);

        boolean result = findSubtree(a, b);
        System.out.println(result);

        boolean result2 = finsSubtree2(a, b);
        System.out.println(result2);
    }

    // O(n*m) time | O(n*m) space
    public static boolean finsSubtree2(Node a, Node b) {
        if (a == null) {
            return false;
        }
        boolean is_match = a.value == b.value;
        if (is_match) {
            boolean is_match_left = (a.left == null || b.left == null) || finsSubtree2(a.left, b.left);
            if (is_match_left) {
                boolean is_match_right = (a.right == null || b.right == null) || finsSubtree2(a.right, b.right);
                if (is_match_right) {
                    return true;
                }
            }
        }
        return finsSubtree2(a.left, b) || finsSubtree2(a.right, b);
    }

    // O(n*m) time | O(n*m) space
    public static boolean findSubtree(Node a, Node b) {
        return pre(a).contains(pre(b));
    }

    private static String pre(Node n) {
        if (n == null) {
            return "#";
        }
        return n.value + pre(n.left) + pre(n.right);
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
