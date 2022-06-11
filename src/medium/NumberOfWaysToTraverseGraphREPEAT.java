package medium;

public class NumberOfWaysToTraverseGraphREPEAT {

    public static void main(String[] args) {
        NumberOfWaysToTraverseGraphREPEAT ways = new NumberOfWaysToTraverseGraphREPEAT();
        int result = ways.numberOfWaysToTraverseGraph(4, 3);
        System.out.println(result);
    }

    // O(n + m) time | O(1) space
    // OK - repeated 16/02/2022
    public int numberOfWaysToTraverseGraph(int width, int height) {
        int xDistanceToCorner = width - 1;
        int yDistanceToCorner = height - 1;

        int numerator = factorial(xDistanceToCorner + yDistanceToCorner);
        int denominator = factorial(xDistanceToCorner) * factorial(yDistanceToCorner);
        return numerator / denominator;
        // (xDistanceToCorner + yDistanceToCorner)!
        // ----------------------------------------
        // (xDistanceToCorner)! * (yDistanceToCorner)!
    }

    private int factorial(int num) {
        int result = 1;
        for (int n = 2; n < num + 1; n++) {
            result *= n;
        }
        return result;
    }

//    // O(n*m) time | O(n*m) space
//    public int numberOfWaysToTraverseGraph(int width, int height) {
//        int[][] numberOfWays = new int[height + 1][width + 1];
//        //             *
//        //     0 1 2 3 4
//        // --+----------
//        // 0 | 0 0 0 0 0
//        // 1 | 0 1 1 1 1  *
//        // 2 | 0 1 2 3 4
//        // 3 | 0 1 3 6 10
//
//        for (int i = 0; i < width; i++) {
//            numberOfWays[0][i] = 0;
//        }
//
//        for (int i = 0; i < height; i++) {
//            numberOfWays[i][0] = 0;
//        }
//
//        for (int widthIdx = 1; widthIdx < width + 1; widthIdx++) { // width = col
//            for (int heightIdx = 1; heightIdx < height + 1; heightIdx++) { // height = row
//                if (widthIdx == 1 || heightIdx == 1) {
//                    numberOfWays[heightIdx][widthIdx] = 1;
//                } else {
//                    int waysLeft = numberOfWays[heightIdx][widthIdx - 1]; // 1
//                    int waysUp = numberOfWays[heightIdx - 1][widthIdx]; // 2
//                    numberOfWays[heightIdx][widthIdx] = waysLeft + waysUp;
//                }
//            }
//        }
//        return numberOfWays[height][width];
//    }

//    // O(2^(n+m)) time | O(n + m) space
//    public int numberOfWaysToTraverseGraph(int width, int height) {
//        if (width == 1 || height == 1) {
//            return 1;
//        }
//
//        return numberOfWaysToTraverseGraph(width - 1, height)
//                + numberOfWaysToTraverseGraph(width, height - 1);
//    }

}
