package problems.other;

public class InorderSuccessor {

    public static void main(String[] args) {
        TreeNodeParent node = new TreeNodeParent(4);
        node.parent = null;
        node.left = new TreeNodeParent(2);
        node.left.parent = node;
        node.right = new TreeNodeParent(8);
        node.right.parent = node;
        node.left.left = new TreeNodeParent(1);
        node.left.left.parent = node.left;
        node.right.left = new TreeNodeParent(5);
        node.right.left.parent = node.right;
        node.right.right = new TreeNodeParent(9);
        node.right.right.parent = node.right;
        node.right.left.right = new TreeNodeParent(7);
        node.right.left.right.parent = node.right.left;
        node.right.left.right.right = new TreeNodeParent(7);
        node.right.left.right.right.parent =  node.right.left.right;

        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        TreeNodeParent case1 = inorderSuccessor.findSuccessor(node.left.left);
        System.out.println(case1);
        TreeNodeParent case2 = inorderSuccessor.findSuccessor(node.right);
        System.out.println(case2);
        TreeNodeParent case3 = inorderSuccessor.findSuccessor(node.right.left.right.right);
        System.out.println(case3);
        TreeNodeParent case4 = inorderSuccessor.findSuccessor(node);
        System.out.println(case4);

        // *
        // 1 2 4 5 7 8 9
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(1) space
    public TreeNodeParent in_order_successor(TreeNodeParent node) {
        if (node.right != null) {
            TreeNodeParent curr = node.right;
            while (curr.left != null) {
                curr = curr.left;
            }
            return curr;
        }

        TreeNodeParent curr = node;
        TreeNodeParent parent = curr.parent;

        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = parent.parent;
        }
        return parent;
    }

    // O(n) time | O(1) space
    public TreeNodeParent findSuccessor(TreeNodeParent node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findLeftMost(node.right);
        }
        TreeNodeParent curr = node;
        TreeNodeParent parent = curr.parent;

        while (parent != null && parent.left != curr) {
            curr = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private TreeNodeParent findLeftMost(TreeNodeParent node) {
        TreeNodeParent current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

}

class TreeNodeParent {
    TreeNodeParent parent;
    TreeNodeParent left;
    TreeNodeParent right;
    int value;

    public TreeNodeParent(int value) {
        this.value = value;
    }
}
