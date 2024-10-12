package leetcode;

import java.util.*;

public class FourSum {

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
//        int target = 0;

        int[] nums = {2, 2, 2, 2, 2};
        int target = 8;

        FourSum fourSum = new FourSum();
        fourSum.fourSum(nums, target);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        List<List<Integer>> quadruplets = new ArrayList<>();
        Map<Integer, List<Integer[]>> numPairs = new HashMap<>();
        Set<String> uniqueCheck = new HashSet<>();
        Set<String> pairCheck = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int aNum = nums[i];
                int bNum = nums[j];
                int sum = aNum + bNum;
                int key = target - sum;
                if (numPairs.containsKey(key)) {
                    List<Integer[]> pairs = numPairs.get(key);
                    for (Integer[] pair : pairs) {
                        String keyToAdd = aNum + ":" + bNum + ":" + pair[0] + ":" + pair[1];
                        if (uniqueCheck.contains(keyToAdd)) {
                            continue;
                        }
                        uniqueCheck.add(keyToAdd);
                        long test = (long )aNum + bNum + pair[0] + pair[1];
                        if (test > Integer.MAX_VALUE || test < Integer.MIN_VALUE) {
                            continue;
                        }
                        List<Integer> quadruple = new ArrayList<>(Arrays.asList(aNum, bNum, pair[0], pair[1]));
                        quadruplets.add(quadruple);
                    }
                }
            }

            for (int k = 0; k < i; k++) {
                int aNum = nums[i];
                int kNum = nums[k];
                int key = aNum + kNum;
                if (numPairs.containsKey(key)) {
                    List<Integer[]> pairs = numPairs.get(key);
                    Integer[] pair = new Integer[] {aNum, kNum};
                    String pairToCheck = aNum + ":" + kNum;
                    if (pairCheck.contains(pairToCheck)) {
                        continue;
                    }
                    pairCheck.add(pairToCheck);
                    pairs.add(pair);
                    numPairs.put(key, pairs);
                } else {
                    List<Integer[]> pairs = new ArrayList<>();
                    Integer[] pair = new Integer[] {aNum, kNum};
                    String pairToCheck = aNum + ":" + kNum;
                    if (pairCheck.contains(pairToCheck)) {
                        continue;
                    }
                    pairCheck.add(pairToCheck);
                    pairs.add(pair);
                    numPairs.put(key, pairs);
                }
            }
        }
        return quadruplets;
    }

}
