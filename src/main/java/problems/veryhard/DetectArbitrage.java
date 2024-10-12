package problems.veryhard;

import java.util.ArrayList;
import java.util.Arrays;

public class DetectArbitrage {

    public static void main(String[] args) {
        ArrayList<ArrayList<Double>> exchangeRates = new ArrayList<>();
        ArrayList<Double> row1 = new ArrayList<>();
        row1.add(1.0);
        row1.add(0.8631);
        row1.add(0.5903);

        ArrayList<Double> row2 = new ArrayList<>();
        row2.add(1.1586);
        row2.add(1.0);
        row2.add(0.6849);

        ArrayList<Double> row3 = new ArrayList<>();
        row3.add(1.6939);
        row3.add(1.46);
        row3.add(1.0);

        exchangeRates.add(row1);
        exchangeRates.add(row2);
        exchangeRates.add(row3);

        DetectArbitrage detectArbitrage = new DetectArbitrage();
        boolean result = detectArbitrage.detectArbitrage(exchangeRates);
        System.out.println(result);
    }

    //          0:USD   1:CAD   2:GBP
    //  0:USD [   1.0,   1.27,  0.718 ]
    //  1:CAD [  0.74,    1.0,   0.56 ]
    //  2:GBP [  1.39,   1.77,    1.0 ]

    // OK - repeated 22/02/2022
    // O(n^3) time | O(n^2) space
    public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
        // Write your code here.
        // log(a*b) = log(a) + log(b)
        ArrayList<ArrayList<Double>> logExchangesRates = convertToLogMatrix(exchangeRates);
        return foundNegativeWeightCycle(logExchangesRates, 0);
    }

    // rec([[-0.0, 0.06, 0.22],[-0.06,-0.0,0.16],[-0.22,-0.16,-0.0]], 0)
    private boolean foundNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int start) {
        Double[] distancesFromStart = new Double[graph.size()];
        Arrays.fill(distancesFromStart, Double.MAX_VALUE);
        distancesFromStart[start] = 0.0;
        // distancesFromStart = [0.0, 999.9, 999.9]

        for (int i = 0; i < graph.size() - 1; i++) {
            if (!relaxEdgesAndUpdateDistances(graph, distancesFromStart)) {
                return false;
            }
        }
        return relaxEdgesAndUpdateDistances(graph, distancesFromStart);
    }
    //                                  *
    // rec([[-0.0, 0.06, 0.22],[-0.06,-0.0,0.16],[-0.22,-0.16,-0.0]], [0.0, 999.9, 999.9])
    private boolean relaxEdgesAndUpdateDistances(ArrayList<ArrayList<Double>> graph, Double[] distances) {
        boolean updated = false;
        for (int sourceIdx = 0; sourceIdx < graph.size(); sourceIdx++) { // 1
            //              *
            // [0.0, 0.0, 0.22]
            //    *
            // [-0.22,-0.16,-0.0]
            ArrayList<Double> edges = graph.get(sourceIdx);
            for (int destinationIdx = 0; destinationIdx < edges.size(); destinationIdx++) {
                Double edgeWeight = edges.get(destinationIdx); // -0.22
                double newDistanceToDestination = distances[sourceIdx] + edgeWeight; // 0.22 - 0.22 = 0
                if (newDistanceToDestination < distances[destinationIdx]) { // 0 < 0.06
                    updated = true;
                    distances[destinationIdx] = newDistanceToDestination;
                }
            }
        }
        return updated;
    }

    //          0:USD   1:CAD   2:GBP
    //  0:USD [   1.0,   1.27,  0.718 ]
    //  1:CAD [  0.74,    1.0,   0.56 ]
    //  2:GBP [  1.39,   1.77,    1.0 ]
    private ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> newMatrix = new ArrayList<>();
        for (int row = 0; row < matrix.size(); row++) {
            newMatrix.add(new ArrayList<>());
            ArrayList<Double> rates = matrix.get(row);
            for (Double rate : rates) {
                newMatrix.get(row).add(-1 * Math.log10(rate));
            }
        }
        return newMatrix;
    }

}


















