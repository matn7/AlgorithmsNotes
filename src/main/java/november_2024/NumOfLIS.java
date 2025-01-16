package november_2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumOfLIS {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
//        int[] nums = {2, 2, 2, 2, 2};

        NumOfLIS numOfLIS = new NumOfLIS();
        int numberOfLIS = numOfLIS.findNumberOfLIS(nums);
        System.out.println(numberOfLIS);
    }

    public int findNumberOfLIS(int[] nums) {

        Map<Integer, Integer[]> dp = new HashMap<>();
        int lenLIS = 0;
        int res = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int maxLen = 1;
            int maxCnt = 1;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int length = dp.get(j)[0];
                    int count = dp.get(j)[1];
                    if (length + 1 > maxLen) {
                        maxLen  = length + 1;
                        maxCnt = count;
                    } else if (length + 1 == maxLen) {
                        maxCnt += count;
                    }
                }
            }

            if (maxLen > lenLIS) {
                lenLIS  =  maxLen;
                res = maxCnt;
            } else if (maxLen == lenLIS) {
                res += maxCnt;
            }

            dp.put(i, new Integer[]{maxLen, maxCnt});
        }

        return res;
    }


//    public int findNumberOfLIS(int[] nums) {
//
//        int[] sequence = new int[nums.length];
//
//        Arrays.fill(sequence, 1);
//        int max = 0;
//        Map<Integer, Integer> freqMap = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] > nums[i]) {
//                    sequence[j] = Math.max(sequence[j], sequence[i] + 1);
//                    freqMap.put(sequence[j], freqMap.getOrDefault(sequence[j], 0) + 1);
//                    max = Math.max(max, sequence[j]);
//                }
//            }
//        }
//
//        return freqMap.isEmpty() ? nums.length : freqMap.get(max);
//    }

}
