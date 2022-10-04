package udemy.faang;

public class TrappingRainwater {

    public static void main(String[] args) {
        TrappingRainwater trappingRainwater = new TrappingRainwater();

        int[] height = {0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2};

        trappingRainwater.trapOptimal(height);
    }

    // O(n^2) time | O(1) space
    public int trap(int[] height) {
        int total = 0;
        int maxL = 0;
        int maxR = 0;
        for (int p = 0; p < height.length; p++) {
            int left = p;
            while (left >= 0) {
                maxL = Math.max(maxL, height[left]);
                left--;
            }
            int right = p;
            while (right < height.length) {
                maxR = Math.max(maxR, height[right]);
                right++;
            }
            int currentWater = Math.min(maxL, maxR) - height[p];
            if (currentWater < 0) {
                currentWater = 0;
            }
            total += currentWater;
            maxL = 0;
            maxR = 0;
        }
        return total;
    }

    // O(n) time | O(1) space
    public int trapOptimal(int[] height) {
        int total = 0;
        int leftP = 0;
        int rightP = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (leftP < rightP) {
            int leftVal = height[leftP];
            int rightVal = height[rightP];
            if (leftVal <= rightVal) {
                // either update leftMax or add water to total
                if (leftVal >= leftMax) {
                    leftMax = leftVal;
                } else {
                    int currWater = leftMax - leftVal;
                    total += currWater;
                }
                leftP++;
            } else {
                if (rightVal >= rightMax) {
                    rightMax = rightVal;
                } else {
                    int currWater = rightMax - rightVal;
                    total += currWater;
                }
                rightP--;
            }
        }
        return total;
    }

    public int trapOptimal2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int total = 0;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    total += (maxLeft - height[left]);
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    total += (maxRight - height[right]);
                }
                right--;
            }
        }
        return total;
    }

}
