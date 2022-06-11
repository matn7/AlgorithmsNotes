package veryhard;

import java.util.*;

public class RightSmallerThan {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(8, 5, 11, -1, 3, 4, 2));

        rightSmallerThan(array);
    }

    public static List<Integer> rightSmallerThan(List<Integer> array) {
        // Write your code here.
        List<Integer> result = new ArrayList<>();

        List<Integer> treeArray = new ArrayList<>();
        treeArray.addAll(array);

        while (!treeArray.isEmpty()) {
            // create tree
            BST bst = new BST(treeArray.get(0));
            for (Integer innerElement : treeArray) {
                bst.insert(innerElement);
            }
            breadthFirst(bst, result);
            treeArray.remove(0);
        }

        return result;
    }

    private static void breadthFirst(BST bst, List<Integer> result) {
        Queue<BST> queue = new LinkedList<>();
        queue.add(bst);
        int currentValue = bst.value;
        int counter = 0;
        while (!queue.isEmpty()) {
            BST poll = queue.poll();
            if (poll.value < currentValue) {
                counter++;
            }
            System.out.println(poll.value);
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        result.add(counter);
    }

    static class BST {
        private int value;
        private BST left;
        private BST right;

        public BST(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public void insert(int value) {
            BST previous = null;
            BST current = this;
            while (current != null) {
                if (current.value > value) {
                    if (current.left == null) {
                        previous = current;
                        previous.left = new BST(value);
                        break;
                    }
                    current = current.left;
                } else  {
                    if (current.right == null) {
                        previous = current;
                        previous.right = new BST(value);
                        break;
                    }
                    current = current.right;
                }
            }
        }
    }

}
