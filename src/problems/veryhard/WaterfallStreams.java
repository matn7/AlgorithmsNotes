package problems.veryhard;

public class WaterfallStreams {

    public static void main(String[] args) {
        double[][] array = {
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0}
        };
        WaterfallStreams waterfallStreams = new WaterfallStreams();
        waterfallStreams.waterfallStreams(array, 3);
    }

//                 *
//     0  1  2  3  4  5  6
//    ----------------------
//    [0, 0, 0, 0, 0, 0, 0],
//    [1, 0, 0, 0, 0, 0, 0],
//    [0, 0, 1, 1, 1, 0, 0],    *
//    [0, 0, 0, 0, 0, 0, 0],
//    [1, 1, 1, 0, 0, 1, 0],
//    [0, 0, 0, 0, 0, 0, 1],
//    [0, 0, 0, 0, 0, 0, 0]

    // O(w^2 * h) time | O(w) space
    public double[] waterfallStreams(double[][] array, int source) {
        // Write your code here.
        double[] rowAbove = new double[array[0].length];
        for (int i = 0; i < array[0].length; i++) {
            rowAbove[i] = array[0][i];
        }
        rowAbove[source] = -1;

        for (int row = 1; row < array.length; row++) {
            double[] currentRow = new double[array[row].length];
            for (int i = 0; i < array[row].length; i++) {
                currentRow[i] = array[row][i];
            }

            for (int idx = 0; idx < rowAbove.length; idx++) {
                double valueAbove = rowAbove[idx];

                boolean hasWaterAbove = valueAbove < 0;
                boolean hasBlock = currentRow[idx] == 1;

                if (!hasWaterAbove) {
                    continue;
                }

                if (!hasBlock) {
                    currentRow[idx] += valueAbove;
                    continue;
                }

                double splitWater = valueAbove / 2;

                int rightIdx = idx;
                while (rightIdx + 1 < rowAbove.length) {
                    rightIdx++;
                    if (rowAbove[rightIdx] == 1) {
                        break;
                    }
                    if (currentRow[rightIdx] != 1) {
                        currentRow[rightIdx] += splitWater;
                        break;
                    }
                }

                int leftIdx = idx;
                while (leftIdx -1 >= 0) {
                    leftIdx--;
                    if (rowAbove[leftIdx] == 1) {
                        break;
                    }
                    if (currentRow[leftIdx] != 1) {
                        currentRow[leftIdx] += splitWater;
                        break;
                    }
                }
            }

            rowAbove = currentRow;
        }

        double[] finalPercentages = new double[rowAbove.length];
        for (int i = 0; i < rowAbove.length; i++) {
            finalPercentages[i] = rowAbove[i] * (-100);
        }

        return finalPercentages;
    }

}
