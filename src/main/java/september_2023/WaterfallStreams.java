package september_2023;

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

    public double[] waterfallStreams(double[][] array, int source) {
        // Write your code here.
        //          0,  0, 0,  100,    0,  0,  0
        //          1,  0, 0,  100,    0,  0,  0
        //          0, 50, 1,    1,    1, 50,  0
        //          0, 50, 0,    0,    0, 50,  0
        //          1,  1, 1,   25,   25,  1, 25        <--- rowAbove
        //          0,  0, 0,   25,   25,  0,  1        <--- array[row][col]
        //          0,  0, 0,   25,   25,  0,  0
        //              l             *           r

        for (int row = 1; row < array.length; row++) {
            double[] rowAbove = new double[array[row].length]; // 0, 50, 0, 0,   0, 50, 0
            for (int col = 0; col < array[row].length; col++) {
                rowAbove[col] = array[row - 1][col];
            }
            for (int col = 0; col < array[row].length; col++) {
                if (array[row][col] == 1) {
                    if (rowAbove[col] == 0) {
                        continue;
                    }
                    double split = rowAbove[col] / 2; // 25
                    int leftIdx = col - 1;
                    int rightIdx = col + 1;
                    while (leftIdx >= 0 && array[row][leftIdx] == 1) {
                        leftIdx--;
                    }
                    if (array[row][leftIdx] != 1 && rowAbove[leftIdx] != 1) {
                        array[row][leftIdx] = split;
                    }
                    while (rightIdx < array[row].length - 1 && array[row][rightIdx] == 1) {
                        rightIdx++;
                    }
                    if (array[row][rightIdx] != 1 && rowAbove[leftIdx] != 1) {
                        array[row][rightIdx] = split;
                    }
                    col = rightIdx;
                } else if (array[row][col] == 0 && rowAbove[col] != 1) {
                    array[row][col] = rowAbove[col];
                }
            }
        }

        double[] doubles = array[array.length - 1];
        return doubles;
    }


}
