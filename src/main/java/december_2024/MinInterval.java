package december_2024;

public class MinInterval {

    public static void main(String[] args) {
        // intervals=[[1,3],[2,3],[3,7],[6,6]]
        // queries=[2,3,1,7,6,8]
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4,4}};
        int[] queries = {2,3,4,5};

//        int[][] intervals = {{1, 3}, {2, 3}, {3, 7}, {6,6}};
//        int[] queries = {2,3,1,7,6,8};

        MinInterval minInterval = new MinInterval();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];

        // [2, 3, 4, 5]
        //
        // [[1, 4], [2, 4], [3, 6], [4, 4]]

        for (int q = 0; q < queries.length; q++) {
            int query = queries[q];
            int minSize = Integer.MAX_VALUE;
            for (int i = 0; i < intervals.length; i++) {
                int[] interval = intervals[i];
                int start = interval[0];
                int end = interval[1];
                if (query >= start && query <= end) {
                    minSize = Math.min(minSize, end - start + 1);
                }
            }
            if (minSize == Integer.MAX_VALUE) {
                result[q] = -1;
            } else {
                result[q] = minSize;
            }
        }

        return result;
    }

}
