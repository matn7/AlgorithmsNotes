package whiteboard;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleUnderSkyline {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 4, 1, 5, 3, 2};
        ArrayList<Integer> buildings = new ArrayList<>();
        for (int n : nums) {
            buildings.add(n);
        }

        LargestRectangleUnderSkyline largestRectangleUnderSkyline = new LargestRectangleUnderSkyline();
        largestRectangleUnderSkyline.largestRectangleUnderSkyline(buildings);
    }

    // ********
    // * STAR - G *
    // ********

    // O(n) time | O(n) space
    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        // Write your code here.
        if (buildings.isEmpty()) {
            return 0;
        }
        Stack<Integer> pillarIndices = new Stack<>();
        buildings.add(0);
        int maxArea = 0;
        for (int idx = 0; idx < buildings.size(); idx++) {
            int height = buildings.get(idx);
            while (!pillarIndices.isEmpty() && buildings.get(pillarIndices.peek()) >= height) {
                int pillarHeight = buildings.get(pillarIndices.pop());
                int width;
                if (pillarIndices.isEmpty()) {
                    width = idx;
                } else {
                    width = idx - pillarIndices.peek() - 1;
                }
                maxArea = Math.max(width * pillarHeight, maxArea);
            }
            pillarIndices.push(idx);
        }
        return maxArea;
    }

    // O(n^2) time | O(1) space
    public int largestRectangleUnderSkyline2(ArrayList<Integer> buildings) {
        if (buildings.isEmpty()) {
            return 0;
        }
        int maxArea = 0;
        for (int pillarIdx = 0; pillarIdx < buildings.size(); pillarIdx++) {
            int currentHeight = buildings.get(pillarIdx);

            int furthestLeft = pillarIdx;
            while (furthestLeft > 0 && buildings.get(furthestLeft - 1) >= currentHeight) {
                furthestLeft--;
            }
            int furthestRight = pillarIdx;
            while (furthestRight < buildings.size() - 1 && buildings.get(furthestRight + 1) >= currentHeight) {
                furthestRight++;
            }

            int areaWithCurrentBuilding = (furthestRight - furthestLeft + 1) * currentHeight;
            maxArea = Math.max(maxArea, areaWithCurrentBuilding);
        }
        return maxArea;
    }

}
