package hard;

import java.util.*;

public class MaxPathSum3 {

    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree(1);
//        binaryTree.left = new BinaryTree(-10);
//        binaryTree.left.left = new BinaryTree(30);
//        binaryTree.left.left.left = new BinaryTree(5);
//        binaryTree.left.left.right = new BinaryTree(1);
//        binaryTree.left.right = new BinaryTree(45);
//        binaryTree.left.right.left = new BinaryTree(3);
//        binaryTree.left.right.right = new BinaryTree(-3);
//        binaryTree.right = new BinaryTree(-5);
//        binaryTree.right.left = new BinaryTree(-20);
//        binaryTree.right.left.left = new BinaryTree(100);
//        binaryTree.right.left.right = new BinaryTree(2);
//        binaryTree.right.right = new BinaryTree(-21);
//        binaryTree.right.right.left = new BinaryTree(100);
//        binaryTree.right.right.right = new BinaryTree(1);

//        BinaryTree binaryTree = new BinaryTree(1);
//        binaryTree.left = new BinaryTree(-5);
//        binaryTree.right = new BinaryTree(3);
//        binaryTree.left.left = new BinaryTree(6);

        BinaryTree binaryTree = new BinaryTree(1);
        binaryTree.left = new BinaryTree(2);
        binaryTree.right = new BinaryTree(3);

        int result = maxPathSum(binaryTree);

        System.out.println(result);
    }

    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.

        List<TreePath> treePaths = preOrder(tree);

        int max = -9999;

        for (TreePath element : treePaths) {
            if (element.value > max) {
                max = element.value;
            }
        }

        return max;
    }

    public static List<TreePath> preOrder(BinaryTree tree) {

        List<TreePath> results = new ArrayList<>();
        List<TreePath> resultsLeft = new ArrayList<>();
        List<TreePath> resultsRight = new ArrayList<>();

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(tree);

        List<TreePath> fullPath = new ArrayList<>();

        while (!queue.isEmpty()) {
            BinaryTree poll = queue.poll();

            System.out.print(poll.value + " ");
            results.add(new TreePath(poll.value, Side.ROOT));
            inOrder(poll, 0, results, Side.ROOT);

            if (poll.left != null) {
                inOrder(poll.left, 0, resultsLeft, Side.LEFT);
                queue.add(poll.left);
            }

            if (poll.right != null) {
                inOrder(poll.right, 0, resultsRight, Side.RIGHT);
                queue.add(poll.right);
            }

            System.out.println("Compute max full path here");
            // max left (no singleNode)
            int leftMax = 0;
            if (!resultsLeft.isEmpty()) {
                for (TreePath element : resultsLeft) {
                    if (!element.singleNode) {
                        if (element.value > leftMax) {
                            leftMax = element.value;
                        }
                    }
                }
            }

            // max right (no singleNode)
            int rightMax = 0;
            if (!resultsRight.isEmpty()) {
                for (TreePath element : resultsRight) {
                    if (!element.singleNode) {
                        if (element.value > rightMax) {
                            rightMax = element.value;
                        }
                    }
                }
            }

            // max left + max right - root
            TreePath fullPathNode = new TreePath(leftMax + rightMax + poll.value, Side.ROOT);
            fullPath.add(fullPathNode);
            System.out.println();

            resultsLeft.clear();
            resultsRight.clear();
        }

        results.addAll(fullPath);

        return results;
    }

    public static void inOrder(BinaryTree root, int sum, List<TreePath> results, Side side) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            sum = sum + root.value;
            if (root.value > sum) {
                TreePath singleNode = new TreePath(root.value, side);
                singleNode.singleNode = true;
                results.add(singleNode);
            }
            results.add(new TreePath(sum, side));
        }

        sum = sum + root.value;
        inOrder(root.left, sum, results, Side.LEFT);
        inOrder(root.right, sum, results, Side.RIGHT);
    }

    private static boolean isLeaf(BinaryTree binaryTree) {
        return binaryTree.left == null && binaryTree.right == null;
    }

    static class TreePath implements Comparable<TreePath> {
        public int value;
        public boolean singleNode;
        public boolean singleSubTree;
        public Side side; // left - right

        public TreePath(int value, Side side) {
            this.value = value;
            this.singleNode = false;
            this.singleSubTree = false;
            this.side = side;
        }

        public void setSide(Side side) {
            this.side = side;
        }

        @Override
        public int compareTo(TreePath o) {
            return value = o.value;
        }
    }

    enum Side {
        ROOT, LEFT, RIGHT
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

}
