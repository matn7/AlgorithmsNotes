package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleUnderSkyLineV2 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 4, 1, 5, 3, 9};
        List<Integer> buildings = new ArrayList<>();
        for (int num : nums) {
            buildings.add(num);
        }

        int result = largestRectangle(buildings);
        System.out.println(result);
    }

    // O(n) time | O(n) space
    public static int largestRectangle(List<Integer> buildings) {
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

}
