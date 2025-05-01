package april_2025;

import java.util.*;

public class MinInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1,4}, {2,4}, {3,6}, {4,4}};
//        int[] queries = {2, 3, 4, 5};

        int[][] intervals = {{2,3}, {2,5}, {1,8}, {20,25}};
        int[] queries = {2,19,5,22};

        MinInterval minInterval = new MinInterval();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];

        Map<Integer, List<Integer>> queryIdx = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            if (queryIdx.containsKey(queries[i])) {
                List<Integer> nums = queryIdx.get(queries[i]);
                nums.add(i);
                queryIdx.put(queries[i], nums);
            } else {
                List<Integer> nums = new ArrayList<>();
                nums.add(i);
                queryIdx.put(queries[i], nums);
            }
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(queries);


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            for (int[] interval : intervals) {
                if (query < interval[0]) {
                    break;
                }
                if (query <= interval[1]) {
                    queue.add(interval[1] - interval[0] + 1);
                }
            }
            if (queue.isEmpty()) {
                for (int idx : queryIdx.get(query)) {
                    result[idx] = -1;
                }
            } else {
                int pool = queue.poll();
                for (int idx : queryIdx.get(query)) {
                    result[idx] = pool;
                }
            }
            queue.clear();
        }

        return result;
    }

}
