package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PartitionArrayIntoThreePartsWithEqualSum {

    public boolean canThreePartsEqualSum(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int a : arr) {
            sum += 1;
        }
        int target = sum / 3;
        int current = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            current = current + arr[i];
            if (current == target) {
                current = 0;
                count++;
            }
        }
        return current == 0 && count == 3;
    }

    public boolean canThreePartsEqualSum2(int[] arr) {
        List<Integer> array = new ArrayList<>();
        for (int a : arr) {
            array.add(a);
        }
        int n = array.size();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                List<Integer> subset1 = array.subList(0, i);
                List<Integer> subset2 = array.subList(i, j);
                List<Integer> subset3 = array.subList(j, array.size());
                int sum1 = 0;
                for (int s : subset1) {
                    sum1 += s;
                }
                int sum2 = 0;
                for (int s : subset2) {
                    sum2 += s;
                }
                int sum3 = 0;
                for (int s : subset3) {
                    sum3 += s;
                }
                if (sum1 == sum2 && sum2 == sum3) {
                    return true;
                }
            }
        }
        return false;
    }

}
