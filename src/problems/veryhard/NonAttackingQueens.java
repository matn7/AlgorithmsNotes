package problems.veryhard;

import java.util.HashSet;
import java.util.Set;

public class NonAttackingQueens {

    public static void main(String[] args) {
        NonAttackingQueens nonAttackingQueens = new NonAttackingQueens();
        int result = nonAttackingQueens.nonAttackingQueens(4); // n x n
        System.out.println(result);
    }

    // OK - repeated 22/02/2022
    // Upper Bound: O(n!) time | O(n) space
    public int nonAttackingQueens(int n) {
        // Write your code here.
        Set<Integer> blockedColumns = new HashSet<>(); // []
        Set<Integer> blockedUpDiagonals = new HashSet<>(); // []
        Set<Integer> blockedDownDiagonals = new HashSet<>(); // []
        // rec(0, [], [], [], 4)
        return getNumberOfNonAttackingQueenPlacement(0, blockedColumns,
                blockedUpDiagonals, blockedDownDiagonals, n);
    }

    // rec(3,[0,1,3],[0,2,5],[0,1],4)
    private int getNumberOfNonAttackingQueenPlacement(int row, Set<Integer> blockedColumns,
            Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals, int boardSize) {
        if (row == boardSize) { // 3 == 4
            return 1;
        }

        int validPlacement = 0;
        for (int col = 0; col < boardSize; col++) {
            // rec(3, 0, [0,1,3],[0,2,5],[0,1])
            if (isNonAttackingPlacement(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals)) {
                // rec(2,3,[0,1],[0,2],[0])
                placeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
                // rec(3,[0,1,3],[0,2,5],[0,1])
                validPlacement += getNumberOfNonAttackingQueenPlacement(row + 1, blockedColumns,
                        blockedUpDiagonals, blockedDownDiagonals, boardSize);
                removeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
            }
        }
        return validPlacement;
    }

    // rec(2,3,[0,1,3],[0,2,5],[0,1])
    private void placeQueen(int row, int col, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals,
                            Set<Integer> blockedDownDiagonals) {
        blockedColumns.add(col); // [0,1,3]
        blockedUpDiagonals.add(row + col); // [0,2,5]
        blockedDownDiagonals.add(row - col); // [0,1]
    }

    private void removeQueen(int row, int col, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals,
                            Set<Integer> blockedDownDiagonals) {
        blockedColumns.remove(col);
        blockedUpDiagonals.remove(row + col);
        blockedDownDiagonals.remove(row - col);
    }

    // rec(3, 4, [0,1,3],[0,2,5],[0,1])
    private boolean isNonAttackingPlacement(int row, int col, Set<Integer> blockedColumns,
                                            Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals) {
        if (blockedColumns.contains(col)) {
            return false; // *
        }
        if (blockedUpDiagonals.contains(row + col)) {
            return false;
        }
        if (blockedDownDiagonals.contains(row - col)) {
            return false;
        }
        return true;
    }

//    // Lower Bound: O(n!) time | O(n) space
//    public int nonAttackingQueens(int n) {
//        // Write your code here.
//        int[] columnPlacements = new int[n];
//        // columnPlacements = [0, 0, 0, 0]
//        // rec(0, [0, 0, 0, 0], 4)
//        return getNumberOfNonAttackingQueenPlacement(0, columnPlacements, n);
//    }
//
//    // rec(0, [0, 0, 0, 0], 4)
//    private int getNumberOfNonAttackingQueenPlacement(int row, int[] columnPlacements, int boardSize) {
//        if (row == boardSize) { // 1 == 4
//            return 1;
//        }
//
//        int validPlacement = 0;
//        for (int col = 0; col < boardSize; col++) {
//            // rec(0, 0, [0, 0, 0, 0])
//            if (isNonAttackingPlacement(row, col, columnPlacements)) {
//                columnPlacements[row] = col;
//                // rec(1, [0, 0, 0, 0], 4)
//                validPlacement += getNumberOfNonAttackingQueenPlacement(row + 1,
//                        columnPlacements, boardSize);
//            }
//        }
//        return validPlacement;
//    }
//
//    // rec(1, 0, [0, 0, 0, 0])
//    private boolean isNonAttackingPlacement(int row, int col, int[] columnPlacements) {
//        for (int previousRow = 0; previousRow < row; previousRow++) {
//            int columnToCheck = columnPlacements[previousRow]; // 0
//            boolean sameColumn = columnToCheck == col; // 0 == 1
//            boolean onDiagonal = Math.abs(columnToCheck - col) == row - previousRow; // 1 == 1 - 0
//            if (sameColumn || onDiagonal) {
//                return false;
//            }
//        }
//        return true;
//    }

}
