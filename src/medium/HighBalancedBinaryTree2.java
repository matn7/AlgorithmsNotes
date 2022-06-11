package medium;

import java.util.ArrayList;
import java.util.List;

public class HighBalancedBinaryTree2 {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.right = new BinaryTree(3);
        tree.left.left = new BinaryTree(4);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(7);
        tree.left.right.right = new BinaryTree(8);
        tree.right.right = new BinaryTree(6);

//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.left.left = new BinaryTree(4);
//        tree.left.right = new BinaryTree(3);

//        BinaryTree tree = new BinaryTree(1);
//        tree.left = new BinaryTree(2);
//        tree.left.left = new BinaryTree(4);
//        tree.left.left.left = new BinaryTree(6);
//        tree.right = new BinaryTree(3);
//        tree.right.right = new BinaryTree(5);

        HighBalancedBinaryTree2 highBalancedBinaryTree = new HighBalancedBinaryTree2();
        boolean result = highBalancedBinaryTree.heightBalancedBinaryTree(tree);
        System.out.println(result);
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public boolean heightBalancedBinaryTree(BinaryTree tree) {
        // Write your code here.
        List<Integer> resultLeft = new ArrayList<>();
        List<Integer> resultRight = new ArrayList<>();
        List<Node> resultArray = new ArrayList<>();
        int counter = 0;
        int numberOfElements = 0;

        inOrder(tree.left, counter, resultLeft, resultArray, Direction.LEFT);
        inOrder(tree.right, counter, resultRight, resultArray, Direction.RIGHT);


        int numOfLeft = 0;
        int numOfRight = 0;
        int leftSum = 0;
        int rightSum = 0;
        for (Node element : resultArray) {
            if (element.direction == Direction.LEFT) {
                numOfLeft++;
                leftSum += element.counter;
            }
            if (element.direction == Direction.RIGHT) {
                numOfRight++;
                rightSum += element.counter;
            }
        }
        if (numOfLeft == 1 && numOfRight == 1) {
            return false;
        }

        return leftSum == rightSum && numOfLeft == numOfRight;
    }

    private void inOrder(BinaryTree tree, int counter, List<Integer> result,
                         List<Node> resultArray, Direction direction) {
        if (tree == null) {
            return;
        }

        counter++;
        if (isLeaf(tree)) {
            resultArray.add(new Node(direction, counter));
            result.add(counter);
        }

        inOrder(tree.left, counter, result, resultArray, Direction.LEFT);

        inOrder(tree.right, counter, result, resultArray, Direction.RIGHT);
    }

    enum Direction {
        LEFT, RIGHT
    }

    class Node {
        Direction direction;
        int counter; // distance from root

        public Node(Direction direction, int counter) {
            this.direction = direction;
            this.counter = counter;
        }
    }

    private boolean isLeaf(BinaryTree tree) {
        return tree.left == null && tree.right == null;
    }

}
