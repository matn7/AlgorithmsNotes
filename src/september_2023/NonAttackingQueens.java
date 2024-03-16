package september_2023;

import java.util.HashSet;
import java.util.Set;

public class NonAttackingQueens {

    // Upper Bound O(n!) | O(n) space
    public int nonAttackingQueens(int n) {
        // Write your code here.
        Set<Integer> blockedColumns = new HashSet<>();
        Set<Integer> blockedUpDiagonals = new HashSet<>();
        Set<Integer> blockedDownDiagonals = new HashSet<>();
        return getNumberOfNonAttackingQueenPlacements(0, blockedColumns, blockedUpDiagonals, blockedDownDiagonals, n);
    }

    private int getNumberOfNonAttackingQueenPlacements(int row,
                                                       Set<Integer> blockedColumns,
                                                       Set<Integer> blockedUpDiagonals,
                                                       Set<Integer> blockedDownDiagonals,
                                                       int boardSize) {
        if (row == boardSize) {
            return 1;
        }

        int validPlacements = 0;
        for (int col = 0; col < boardSize; col++) {
            if (isNonAttackingPlacement(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals)) {
                placeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
                validPlacements += getNumberOfNonAttackingQueenPlacements(row + 1,
                        blockedColumns, blockedUpDiagonals, blockedDownDiagonals, boardSize);
                removeQueen(row, col, blockedColumns, blockedUpDiagonals, blockedDownDiagonals);
            }
        }
        return validPlacements;
    }

    private void placeQueen(int row, int col, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals) {
        blockedColumns.add(col);
        blockedUpDiagonals.add(row + col);
        blockedDownDiagonals.add(row - col);
    }

    private void removeQueen(int row, int col, Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals) {
        blockedColumns.remove(col);
        blockedUpDiagonals.remove(row + col);
        blockedDownDiagonals.remove(row - col);
    }

    private boolean isNonAttackingPlacement(int row, int col,
                Set<Integer> blockedColumns, Set<Integer> blockedUpDiagonals, Set<Integer> blockedDownDiagonals) {
        if (blockedColumns.contains(col)) {
            return false;
        }
        if (blockedUpDiagonals.contains(row + col)) {
            return false;
        }
        if (blockedDownDiagonals.contains(row - col)) {
            return false;
        }
        return true;
    }

    // Lower Bound O(n!) time | O(n) space
//    public int nonAttackingQueens(int n) {
//        // Write your code here.
//        int[] columnPlacements = new int[n];
//        return getNumberOfNonAttackingQueenPlacements(0, columnPlacements, n);
//    }
//
//    private int getNumberOfNonAttackingQueenPlacements(int row, int[] columnPlacements, int boardSize) {
//        if (row == boardSize) {
//            return 1;
//        }
//
//        int validPlacements = 0;
//        for (int col = 0; col < boardSize; col++) {
//            if (isNonAttackingPlacement(row, col, columnPlacements)) {
//                columnPlacements[row] = col;
//                validPlacements += getNumberOfNonAttackingQueenPlacements(row + 1, columnPlacements, boardSize);
//            }
//        }
//        return validPlacements;
//    }
//
//    private boolean isNonAttackingPlacement(int row, int col, int[] columnPlacements) {
//        for (int previousRow = 0; previousRow < row; previousRow++) {
//            int columnToCheck = columnPlacements[previousRow];
//            boolean sameColumn = columnToCheck == col;
//            boolean onDiagonal = Math.abs(columnToCheck - col) == row - previousRow;
//            if (sameColumn || onDiagonal) {
//                return false;
//            }
//        }
//        return true;
//    }

}
