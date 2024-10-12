package udemy.binarytree;


public class HasPathSum {

    public static void main(String[] args) {
        Tree.Node root = new Tree.Node(1);
        root.setLeftChild(new Tree.Node(2));
        root.setRightChild(new Tree.Node(3));
        root.getRightChild().setLeftChild(new Tree.Node(7));
        root.getRightChild().setRightChild(new Tree.Node(6));
        root.getRightChild().getLeftChild().setLeftChild(new Tree.Node(8));
        root.getRightChild().getLeftChild().setRightChild(new Tree.Node(5));
        root.getRightChild().getRightChild().setRightChild(new Tree.Node(4));

        boolean hasPathSum = hasPathSum(root, 19);
        boolean hasPathSumMy = hasPathSumMy(root, 19);
        System.out.println();
    }



    public static boolean hasPathSum(Tree.Node<Integer> root, int sum) {
        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return sum == root.getData();
        }

        int subSum = sum - root.getData();
        if (root.getLeftChild() != null) {
            boolean hasPathSum = hasPathSum(root.getLeftChild(), subSum);
            if (hasPathSum) {
                return true;
            }
        }
        if (root.getRightChild() != null) {
            boolean hasPathSum = hasPathSum(root.getRightChild(), subSum);
            if (hasPathSum) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasPathSumMy(Tree.Node<Integer> root, int sum) {
        return hasPathSumHelper(root, 0, sum);
    }

    private static boolean hasPathSumHelper(Tree.Node<Integer> node, int currSum, int sum) {
        // check leaf node
        if (currSum == sum) {
            return true;
        }

        if (node == null) {
            return false;
        }

        boolean hasLeftSum = hasPathSumHelper(node.getLeftChild(), currSum + node.getData(), sum);
        if (hasLeftSum) {
            return true;
        }

        boolean hasRightSum = hasPathSumHelper(node.getRightChild(), currSum + node.getData(), sum);
        return hasLeftSum || hasRightSum;
    }

}
