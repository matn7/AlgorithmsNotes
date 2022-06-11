package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleUnderSkylineREPEAT {

    public static void main(String[] args) {
        ArrayList<Integer> buildings = new ArrayList<>(Arrays.asList(1, 3, 3, 2, 4, 1, 5, 3, 2));
        LargestRectangleUnderSkylineREPEAT largestRectangleUnderSkylineREPEAT = new LargestRectangleUnderSkylineREPEAT();
        largestRectangleUnderSkylineREPEAT.largestRectangleUnderSkyline(buildings);
    }

    //
    //                          #
    //                  #       #
    //      #   #       #       #   #
    //      #   #   #   #       #   #   #
    //  #   #   #   #   #   #   #   #   #
    // ---------------------------------------
    //  0   1   2   3   4   5   6   7   8   9

    // O(n) time | O(n) space
    // OK - repeated 30/01/2022
    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        // ----------------------------
        // 0 3 5 9
        // ----------------------------
        Stack<Integer> pillarIndices = new Stack<>();
        int maxArea = 0; // 6
        //                                               *
        buildings.add(0); // [1, 3, 3, 2, 4, 1, 5, 3, 2, 0]

        for (int idx = 0; idx < buildings.size(); idx++) { // 9
            int height = buildings.get(idx); // 0
            while (!pillarIndices.isEmpty() && buildings.get(pillarIndices.peek()) >= height) {
                Integer pillarHeight = buildings.get(pillarIndices.pop()); // 2
                int width = pillarIndices.isEmpty() ? idx : idx - pillarIndices.peek() - 1; // 9 - 5 - 1 = 3
                maxArea = Math.max(width * pillarHeight, maxArea); // max(6, 6)
            }
            pillarIndices.add(idx);
        }

        return maxArea;
    }

    //
    //                          #
    //                  #       #
    //      #   #       #       #   #
    //      #   #   #   #       #   #   #
    //  #   #   #   #   #   #   #   #   #
    // ------------------------------------
    //  0   1   2   3   4   5   6   7   8

    //       idx =  0  1  2  3  4  5  6  7  8
    // buildings = [1, 3, 3, 2, 4, 1, 5, 3, 2]
    //                                      *
    // O(n^2) time | O(1) space
//    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
//        // Write your code here.
//        if (buildings.isEmpty()) {
//            return 0;
//        }
//        int maxArea = 0;
//        for (int pillarIdx = 0; pillarIdx < buildings.size(); pillarIdx++) { // 8
//            Integer currentHeight = buildings.get(pillarIdx); // 2
//
//            int furthestLeft = pillarIdx; // 8
//            while (furthestLeft > 0 && buildings.get(furthestLeft - 1) >= currentHeight) {
//                furthestLeft--; // 6
//            }
//            int furthestRight = pillarIdx; // 8
//            while (furthestRight < buildings.size() - 1 && buildings.get(furthestRight + 1) >= currentHeight) {
//                furthestRight++; // 8
//            }
//
//            int areaWithCurrentBuilding = (furthestRight - furthestLeft + 1) * currentHeight; // 3 * 2 = 6
//            maxArea = Math.max(areaWithCurrentBuilding, maxArea); // max(6, 9) = 9
//        }
//        return maxArea; // 9
//    }

}
