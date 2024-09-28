package august_2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRectangleUnderSkylineV4 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 3, 2, 4, 1, 5, 3, 9};

        int result = largestRectangle(nums);
        System.out.println(result);

        List<Integer> buildings = new ArrayList<>();
        for (int num : nums) {
            buildings.add(num);
        }
        int result1 = largestRectangleV2(buildings);
        System.out.println(result1);
    }

    // O(n^2) time | O(1) space
    public static int largestRectangle(int[] nums) {
        int maxArea = 0;

        for (int i = 0; i < nums.length; i++) {
            int pillar = nums[i];
            int left = i - 1;
            int right = i + 1;
            int width = 1;
            while (left >= 0 && nums[left] >= pillar) {
                left--;
                width++;
            }
            while (right <= nums.length - 1 && nums[right] >= pillar) {
                right++;
                width++;
            }
            maxArea = Math.max(maxArea, pillar * width);
        }

        return maxArea;
    }

    // O(n) time | O(n) space
    public static int largestRectangleV2(List<Integer> buildings) {
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
