package udemy.recursion;

public class SameBinaryTrees {

    public static void main(String[] args) {
        Node tree1 = new Node(1);
        tree1.addChildren(new Node(2), new Node(3));
        tree1.right.addChildren(new Node(4), new Node(5));
        tree1.right.left.addChildren(new Node(6), new Node(7));
        tree1.right.right.addChildren(null, new Node(8));

        Node tree2 = new Node(1);
        tree2.addChildren(new Node(2), new Node(3));
        tree2.right.addChildren(new Node(4), new Node(5));
        tree2.right.left.addChildren(new Node(6), new Node(7));
        tree2.right.right.addChildren(new Node(12), new Node(8));

        boolean result = sameTrees(tree1, tree2);
        System.out.println();
    }

    // O(n) time
    public static boolean sameTrees(Node tree1, Node tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null && tree2 != null || tree1 != null && tree2 == null) {
            return false;
        }

        boolean leftSame = sameTrees(tree1.left, tree2.left);
        boolean rightSame = sameTrees(tree1.right, tree2.right);

        if (leftSame && rightSame) {
            return tree1.id == tree2.id;
        }
        return false;
    }

    public static class Node {
        private int id;
        private Node left;
        private Node right;

        public Node(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void addChildren(Node left, Node right) {
            this.left = left;
            this.right = right;
        }
    }

}
