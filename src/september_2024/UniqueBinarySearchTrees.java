package september_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int result = uniqueBinarySearchTrees.numTrees(3);
        System.out.println(result);
    }

    // leetcode 96

    // O(n^2) time | O(n^2) space
    public int numTrees(int n) {
        // numTrees[4] = numTree[0] * numTree[3] +
        //             = numTree[1] * numTree[2] +
        //             = numTree[2] * numTree[1] +
        //             = numTree[3] * numTree[0]
        int[] numTree = new int[n + 1];
        Arrays.fill(numTree, 1);

        //  0  1  2  3
        // [1, 1, 1, 1]
        //        n
        //     r

        // 0 nodes = 1 tree
        // 1 nodes = 1 tree
        for (int nodes = 2; nodes < n + 1; nodes++) {
            int total = 0;
            for (int root = 1; root < nodes + 1; root++) {
                int left = root - 1; // 0
                int right = nodes - root; // 2 -
                total += numTree[left] * numTree[right];
            }
            numTree[nodes] = total;
        }
        return numTree[n];
    }


}
