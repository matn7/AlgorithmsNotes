package april_2024;

public class SymmetricTree {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

//        boolean result = symmetricTree(root);
//        System.out.println(result);
//
//        boolean result2 = symmetricTree2(root);
//        System.out.println(result2);

        boolean result3 = isSymmetric(root);
        System.out.println(result3);
    }

    // O(n) time | O(n) space
    public static boolean isSymmetric(Node root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private static boolean isMirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.value == t2.value && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
    }

    // O(n) time | O(n) space
    public static boolean symmetricTree(Node root) {
        Node right = mirror(root.right);

        String leftInOrder = inOrder(root.left);
        String rightInOrder = inOrder(right);

        return leftInOrder.equals(rightInOrder);
    }

    public static boolean symmetricTree2(Node root) {
        Node right = mirror(root.right);

        return inOrderComp(root.left, right);
    }

    private static boolean inOrderComp(Node a, Node b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.value != b.value) {
            return false;
        }
        boolean leftCheck = inOrderComp(a.left, b.left);
        boolean rightCheck = inOrderComp(a.right, b.right);
        return leftCheck && rightCheck;
    }

    private static String inOrder(Node node) {
        if (node == null) {
            return "";
        }
        return node.value + inOrder(node.left) + inOrder(node.right);
    }

    private static Node mirror(Node node) {
        if (node == null) {
            return null;
        }
        if (isLeft(node)) {
            return node;
        }
        Node left = mirror(node.left);
        Node right = mirror(node.right);

//        Node temp = node.left;
        node.left = right;
        node.right = left;

        return node;
    }

    private static boolean isLeft(Node node) {
        return node.left == null && node.right == null;
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
