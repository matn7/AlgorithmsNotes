package whiteboard;

import java.util.ArrayList;
import java.util.Stack;

public class LargestRectangleUnderSkyline {

    // O(n) time | O(n) space
    public int largestRectangleUnderSkyline(ArrayList<Integer> buildings) {
        // Write your code here.
        if (buildings.isEmpty()) {
            return 0;
        }
        Stack<Integer> pillarIndicies = new Stack<>();
        buildings.add(0);
        int maxArea = 0;
        for (int idx = 0; idx < buildings.size(); idx++) {
            int height = buildings.get(idx);
            while (!pillarIndicies.isEmpty() && buildings.get(pillarIndicies.peek()) >= height) {
                int pillarHeight = buildings.get(pillarIndicies.pop());
                int width;
                if (pillarIndicies.isEmpty()) {
                    width = idx;
                } else {
                    width = idx - pillarIndicies.peek() - 1;
                }
                maxArea = Math.max(width * pillarHeight, maxArea);
            }
            pillarIndicies.push(idx);
        }
        return maxArea;
    }

}
