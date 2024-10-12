package whiteboard;

public class WaterfallStreamsNOT {

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

        WaterfallStreamsNOT streams = new WaterfallStreamsNOT();
        streams.waterfallStreams(array, 3);
    }

    public double[] waterfallStreams(double[][] array, int source) {
        // Write your code here.
        array[0][source] = -100;
        double[] rowAbove = new double[array[0].length];

        for (int row = 1; row < array.length; row++) {
            for (int i = 0; i < array[row - 1].length; i++) {
                rowAbove[i] = array[row - 1][i];
            }
            System.out.println();
            for (int col = 0; col < array[row].length; col++) {
                double current = array[row][col];
                if (rowAbove[col] < 0) {
                    if (current == 0) {
                        array[row][col] = rowAbove[col];
                    } else {
                        int toLeft = col - 1;
                        int toRight = col + 1;

                        if (toLeft < 0) {
                            continue;
                        }
                        if (toRight > array.length - 1) {
                            continue;
                        }

                        while (toLeft > 0 && rowAbove[toLeft] == 0 && array[row][toLeft] == 1) {
                            toLeft--;
                        }
                        if (array[row][toLeft] == 0 && rowAbove[toLeft] == 0) {
                            array[row][toLeft] = rowAbove[col] / 2;
                        }

                        while (toRight < array[row].length - 1 && rowAbove[toRight] == 0 && array[row][toRight] == 1) {
                            toRight++;
                        }
                        if (array[row][toRight] == 0 && rowAbove[toRight] == 0) {
                            array[row][toRight] = rowAbove[col] / 2;
                            System.out.println();
                        }
                    }
                }
            }
        }

        double[] lastRow = array[array.length - 1];
        for (int i = 0; i < lastRow.length; i++) {
            if (lastRow[i] < 0) {
                lastRow[i] *= -1;
            }
        }
        return lastRow;
    }

}
