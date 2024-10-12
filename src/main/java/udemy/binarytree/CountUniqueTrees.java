package udemy.binarytree;

public class CountUniqueTrees {

    public static int countTrees(int numNodes) {
        // when the number of nodes is 1 there is just one possible tree - this is the base case
        if (numNodes <= 1) {
            return 1;
        }

        int sum = 0;
        // consider that every node can be the root - the nodes before it will be on the left and the nodes after it on
        // the right
        // nodes on the left and right form their own subtrees
        for (int i = 1; i <= numNodes; i++) {
            int countLeftTrees = countTrees(i - 1);
            int countRightTrees = countTrees(numNodes - i);

            // this is the number of possible trees with this root - the combination of right and left subtrees
            sum = sum + (countLeftTrees * countRightTrees);
        }

        return sum;
    }

}
