package veryhard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectArbitrage {

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

        DirectArbitrage directArbitrage = new DirectArbitrage();
        directArbitrage.detectArbitrage(exchangeRates);
    }

    public boolean detectArbitrage(ArrayList<ArrayList<Double>> exchangeRates) {
        // Write your code here.
        // Bellman Ford
        ArrayList<ArrayList<Double>> logExchangeRates = convertToLogMatrix(exchangeRates);
        return foundNegativeWeightCycle(logExchangeRates, 0);
    }

    private boolean foundNegativeWeightCycle(ArrayList<ArrayList<Double>> graph, int start) {
        ArrayList<Double> distancesFromStart = new ArrayList<>();
        for (ArrayList<Double> element : graph) {
            distancesFromStart.add(9999.0);
        }
        distancesFromStart.set(start, 0.0);

        for (int i = 0; i < graph.size() - 1; i++) {
            if (!relaxEdgesAndUpdateDistances(graph, distancesFromStart)) {
                return false;
            }
        }
        return relaxEdgesAndUpdateDistances(graph, distancesFromStart);
    }

    private boolean relaxEdgesAndUpdateDistances(ArrayList<ArrayList<Double>> graph, ArrayList<Double> distances) {
        boolean updated = false;
        for (int sourceIdx = 0; sourceIdx < graph.size(); sourceIdx++) {
            ArrayList<Double> edges = graph.get(sourceIdx);
            for (int destinationIdx = 0; destinationIdx < edges.size(); destinationIdx++) {
                Double edgeWeight = edges.get(destinationIdx);
                double newDistanceToDestination = distances.get(sourceIdx) + edgeWeight;
                if (newDistanceToDestination < distances.get(destinationIdx)) {
                    updated = true;
                    distances.set(destinationIdx, newDistanceToDestination);
                }
            }
        }
        return updated;
    }

    private ArrayList<ArrayList<Double>> convertToLogMatrix(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> newMatrix = new ArrayList<>();
        for (int row = 0; row < matrix.size(); row++) {
            ArrayList<Double> rates = matrix.get(row);
            newMatrix.add(new ArrayList<>());
            for (Double rate : rates) {
                newMatrix.get(row).add(-Math.log10(rate));
            }
        }
        return newMatrix;
    }

}
