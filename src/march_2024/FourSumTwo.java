package march_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSumTwo {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {-2, -1};
        int[] c = {-1, 2};
        int[] d = {0, 2};

        int result = fourSumCount(a, b, c, d);
        System.out.println(result);
    }

    // 2 x 2 sum problem ?
    // O(n^2) time | O(n) space
    public static int fourSumCount(int[] a, int[] b, int[] c, int[] d) {
        Map<Integer, Integer> sumsMap = new HashMap<>();
        int answer = 0;

        for (int ai = 0; ai < a.length; ai++) {
            for (int bi = 0; bi < b.length; bi++) {
                int sum = a[ai] + b[bi];
                if (!sumsMap.containsKey(sum)) {
                    sumsMap.put(sum, 0);
                }
                sumsMap.put(sum, sumsMap.get(sum) + 1);
            }
        }

        for (int ci = 0; ci < c.length; ci++) {
            for (int di = 0; di < d.length; di++) {
                int sum = c[ci] + d[di];
                int key = sum * (-1);
                if (sumsMap.containsKey(key)) {
                    answer += sumsMap.get(key);
                }
            }
        }
        return answer;
    }


}
