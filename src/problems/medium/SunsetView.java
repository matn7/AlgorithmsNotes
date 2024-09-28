package problems.medium;

import java.util.ArrayList;
import java.util.Stack;

public class SunsetView {

    public static void main(String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};

        SunsetView sunsetView = new SunsetView();
        sunsetView.sunsetViews(buildings, "EAST");
    }
    //
    //              #
    //              #   #   #
    //          #   #   #   #   #       #
    //          #   #   #   #   #       #   #
    //  :)      #   #   #   #   #   #   #   #      :) EAST
    //          ------------------------------
    //          0   1   2   3   4   5   6   7

    // O(n) time | O(n) space
    // OK - repeated 13/02/2022
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        Stack<Integer> candidateBuildings = new Stack<>();

        int startIdx;
        int step;
        if (direction.equals("EAST")) {
            startIdx = 0;
            step = 1;
        } else {
            startIdx = buildings.length - 1;
            step = -1;
        }
        //              0  1  2  3  4  5  6  7
        // buildings = [3, 5, 4, 4, 3, 1, 3, 2]
        //              *
        int idx = startIdx; // 7
        while (idx >= 0 && idx < buildings.length) { // 0
            int buildingHeight = buildings[idx]; // 3

            // 5 <= 3
            while (!candidateBuildings.isEmpty() && buildings[candidateBuildings.peek()] <= buildingHeight) {
                candidateBuildings.pop();
            }

            candidateBuildings.add(idx);

            idx += step; // 1
        }
        // --------------------------
        // | 1 0                          idx
        // --------------------------
        // | 5 3                       height
        // --------------------------
        ArrayList<Integer> buildingsWithSunsetViews = new ArrayList<>();

        while (!candidateBuildings.isEmpty()) {
            buildingsWithSunsetViews.add(candidateBuildings.pop());
        }
        // [7,6,3,1] [0,1]

        if (direction.equals("EAST")) {
            ArrayList<Integer> result = new ArrayList<>();
            int counter = buildingsWithSunsetViews.size() - 1; // 3
            for (Integer element : buildingsWithSunsetViews) {
                result.add(buildingsWithSunsetViews.get(counter)); // [1,3,6,7]
                counter--;
            }
            return result;
        }
        return buildingsWithSunsetViews; // [1,3,6,7] | [0,1]
    }

    //
    //              #
    //              #   #   #
    //          #   #   #   #   #       #
    //          #   #   #   #   #       #   #
    //  :)      #   #   #   #   #   #   #   #      :) EAST
    //          ------------------------------
    //          0   1   2   3   4   5   6   7

//    // O(n) time | O(n) space
//    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
//        ArrayList<Integer> buildingsWithSunsetViews = new ArrayList<>();
//
//        int startIdx;
//        int step;
//        if (direction.equals("WEST")) {
//            startIdx = 0;
//            step = 1;
//        } else {
//            startIdx = buildings.length - 1;
//            step = -1;
//        }
//
//        //  0  1  2  3  4  5  6  7      idx
//        // ------------------------
//        // [3, 5, 4, 4, 3, 1, 3, 2]     buildings
//        //                       *
//        int idx = startIdx; // 0
//        int runningMaxHeight = 0;
//        while (idx >= 0 && idx < buildings.length) {
//            int buildingsHeight = buildings[idx]; // 2
//
//            if (buildingsHeight > runningMaxHeight) { // 2 > 5
//                buildingsWithSunsetViews.add(idx); // [0, 1]
//            }
//
//            runningMaxHeight = Math.max(runningMaxHeight, buildingsHeight); // max(5, 2) = 5
//            idx += step;
//        }
//        if (direction.equals("EAST")) {
//            ArrayList<Integer> result = new ArrayList<>();
//            int counter = buildingsWithSunsetViews.size() - 1;
//            for (Integer element : buildingsWithSunsetViews) {
//                result.add(buildingsWithSunsetViews.get(counter)); // [1, 3, 6, 7]
//                counter--;
//            }
//            return result;
//        }
//        return buildingsWithSunsetViews; // [1,3,6,7] | [0,1]
//    }

}
