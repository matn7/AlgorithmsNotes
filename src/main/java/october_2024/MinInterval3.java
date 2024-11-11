package october_2024;

import java.util.*;

public class MinInterval3 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};

        MinInterval3 minInterval3 = new MinInterval3();
        int[] result = minInterval3.minInterval(intervals, queries);

    }

    // leetcode premium 252

    // O(nlog(n) + mlog(m)) time | O(n + m) space
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Node> minHeap = new PriorityQueue();
        Map<Integer, Integer> res = new HashMap<>();
        int i = 0;
        int[] sortedQueries = new int[queries.length];
        System.arraycopy(queries, 0, sortedQueries, 0, queries.length);
        Arrays.sort(sortedQueries);

        for (int q : sortedQueries) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int[] interval = intervals[i];
                int l = interval[0];
                int r = interval[1];
                minHeap.add(new Node(r - l + 1, r));
                i++;
            }

            while (!minHeap.isEmpty() && minHeap.peek().r < q) {
                minHeap.poll();
            }
            if (!minHeap.isEmpty()) {
                res.put(q, minHeap.peek().size);
            } else {
                res.put(q, -1);
            }
        }
        int[] result = new int[queries.length];
        int index = 0;
        for (int q : queries) {
            result[index] = res.get(q);
            index++;
        }
        return result;
    }

    static class Node implements Comparable<Node> {
        int size;
        int r;

        public Node(int size, int r) {
            this.size = size;
            this.r = r;
        }

        @Override
        public int compareTo(Node o) {
            return size - o.size;
        }
    }


}
