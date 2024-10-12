package october_2024;

import java.util.Arrays;

public class MostFreqElement {

    public static void main(String[] args) {
//        int[] nums = {1,4,8,13};
//        int k = 5;
//        int[] nums = {3,9,6};
//        int k = 2;
        int[] nums = {1, 1, 1, 2, 2, 4};
        int k = 2;

        MostFreqElement mostFreqElement = new MostFreqElement();
        int result = mostFreqElement.maxFrequency(nums, k);
        System.out.println(result);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = 0;
        int res = 0;
        long total = 0;

        while (r < nums.length) {
            total += nums[r];
            while ((long) nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }


    // leetcode 1838
    public int maxFrequency2(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, maxFreq = 0, total = 0;

        // we consider right as special value
        for (int right = 0; right < nums.length; right++) {
            total += nums[right]; // Add the current number to total

            // Expand while (nums[r]*windowLen <= total + k)

            // Calculate the cost to make all numbers in the window equal to nums[right]
            while (nums[right] * (right - left + 1) - total > k) {
                total -= nums[left]; // Remove the leftmost number from the total
                left++; // Move the left pointer to the right
            }

            // Update max frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }

    public int maxFrequency3(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 0;

        // Iterate over each unique number as a potential target
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            int totalCost = 0;
            int count = 0;

            // Count how many we can make equal to the target
            for (int j = i; j < nums.length; j++) {
                totalCost += target - nums[j];
                if (totalCost <= k) {
                    count++;
                } else {
                    break; // Stop if we exceed the cost
                }
            }

            maxFreq = Math.max(maxFreq, count);
        }

        return maxFreq;
    }

}
