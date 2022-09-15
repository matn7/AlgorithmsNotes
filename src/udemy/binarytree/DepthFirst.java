package udemy.binarytree;

public class DepthFirst <T> {

    public static void preOrder(Tree.Node root) {
        if (root == null) {
            return;
        }
        print(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public static void inOrder(Tree.Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftChild());
        print(root);
        inOrder(root.getRightChild());
    }

    public static void postOrder(Tree.Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        print(root);

    }

    public static void print(Tree.Node node) {
        System.out.println(node.getData());
    }

}
