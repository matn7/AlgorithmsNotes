package udemy.binarytree;

public class FindLeastCommonAncestor {

    public static void main(String[] args) {
        Tree.Node root = new Tree.Node(1);
        root.setLeftChild(new Tree.Node(2));
        root.setRightChild(new Tree.Node(3));
        root.getRightChild().setLeftChild(new Tree.Node(7));
        root.getRightChild().setRightChild(new Tree.Node(6));
        root.getRightChild().getLeftChild().setLeftChild(new Tree.Node(8));
        root.getRightChild().getLeftChild().setRightChild(new Tree.Node(5));
        root.getRightChild().getRightChild().setRightChild(new Tree.Node(4));

        Tree.Node one = root.getRightChild().getLeftChild().getLeftChild();
        Tree.Node two = root.getRightChild().getRightChild();
        findLeastCommonAncestorMy(root, one, two);
    }

    public static Tree.Node<Integer> leastCommonAncestor(Tree.Node<Integer> root, Tree.Node<Integer> a, Tree.Node<Integer> b) {
        // if we encounter a null root no ancestor was found
        if (root == null) {
            return null;
        }

        // if the current root is either of the two nodes, then return the root itself
        if (root == a || root == b) {
            return root;
        }

        // Find the lca for the left and right subtrees
        Tree.Node<Integer> leftLCA = leastCommonAncestor(root.getLeftChild(), a, b);
        Tree.Node<Integer> rightLCA = leastCommonAncestor(root.getRightChild(), a, b);

        // if both exists it means - either the node or it's ancestor exists in the left and right subtree so the current
        // node is the lca
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // if only one of the common ancestors is non null return that
        if (leftLCA != null) {
            return leftLCA;
        }

        return rightLCA;
    }

    private static Tree.Node<Integer> findLeastCommonAncestorMy(Tree.Node<Integer> root,
                                                              Tree.Node<Integer> one, Tree.Node<Integer> two) {
        TreeInfo info = new TreeInfo();
        findLeastCommonAncestorHelper(root, one, two, info, null);
        return info.node;
    }

    private static void findLeastCommonAncestorHelper(Tree.Node<Integer> node, Tree.Node<Integer> one,
                                                      Tree.Node<Integer> two, TreeInfo info, Tree.Node<Integer> cameFrom) {
        if (node == null) {
            return;
        }
        if (info.node != null) {
            return;
        }

        if (node.getData() == one.getData()) {
            info.oneFound = true;
        }

        if (node.getData() == two.getData()) {
            info.twoFound = true;
        }

        if (info.oneFound && info.twoFound) {
            info.node = cameFrom;
        }

        findLeastCommonAncestorHelper(node.getLeftChild(), one, two, info, node);
        findLeastCommonAncestorHelper(node.getRightChild(), one, two, info, node);
    }

    public static class TreeInfo {
        boolean oneFound;
        boolean twoFound;
        Tree.Node<Integer> node;
    }

}
