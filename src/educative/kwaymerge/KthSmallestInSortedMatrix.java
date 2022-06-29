package educative.kwaymerge;

import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    // O(min(k,n) + klog(n)) time | O(n) space
    public static int findKthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node2> minHeap = new PriorityQueue<Node2>((n1, n2) -> matrix[n1.row][n1.col] - matrix[n2.row][n2.col]);

        for (int i = 0; i < matrix.length && i < k; i++) {
            minHeap.add(new Node2(i, 0));
        }

        int numberCount = 0;
        int result = 0;
        while (!minHeap.isEmpty()) {
            Node2 node = minHeap.poll();
            result = matrix[node.row][node.col];
            if (++numberCount == k) {
                break;
            }
            node.col++;
            if (matrix[0].length > node.col) {
                minHeap.add(node);
            }
        }
        return result;
    }

    // O(n*log(max - min)) time | O(1) space
    public static int findKthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0];
        int end = matrix[n-1][n-1];
        while (start < end) {
            int mid = start + (end - start) / 2;

            int[] smallLargePair = { matrix[0][0], matrix[n-1][n-1] };

            int count = countLessEqual(matrix, mid, smallLargePair);

            if (count == k) {
                return smallLargePair[0];
            }

            if (count < k) {
                start = smallLargePair[1];
            } else {
                end = smallLargePair[0];
            }
        }
        return start;
    }

    private static int countLessEqual(int[][] matrix, int mid, int[] smallLargePair) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;
        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                smallLargePair[1] = Math.min(smallLargePair[1], matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], matrix[row][col]);
                count += row + 1;
                col++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // FIRST VERSION
        int matrix0[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        int result0 = KthSmallestInSortedMatrix.findKthSmallest(matrix0, 5);
        System.out.println("Kth smallest number is: " + result0);


        int matrix[][] = { { 1, 4 }, { 2, 5 } };
        int result = KthSmallestInSortedMatrix.findKthSmallest2(matrix, 2);
        System.out.println("Kth smallest number is: " + result);

        int matrix1[][] = { { -5 } };
        result = KthSmallestInSortedMatrix.findKthSmallest2(matrix1, 1);
        System.out.println("Kth smallest number is: " + result);

        int matrix2[][] = { { 2, 6, 8 }, { 3, 7, 10 }, { 5, 8, 11 } };
        result = KthSmallestInSortedMatrix.findKthSmallest2(matrix2, 5);
        System.out.println("Kth smallest number is: " + result);

        int matrix3[][] = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        result = KthSmallestInSortedMatrix.findKthSmallest2(matrix3, 8);
        System.out.println("Kth smallest number is: " + result);

    }


}

class Node2 {
    int row;
    int col;

    public Node2(int row, int col) {
        this.row = row;
        this.col = col;
    }
}