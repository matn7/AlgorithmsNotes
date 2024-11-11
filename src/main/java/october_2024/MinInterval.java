package october_2024;

import java.util.*;

public class MinInterval {

    public static void main(String[] args) {
//        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};

        // [4,5],[5,8],[1,9],[8,10],[1,6]
        int[][] intervals = {{4,5}, {5,8}, {1,9}, {8,10}, {1,6}};

        MinInterval minInterval = new MinInterval();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
//        PriorityQueue<Node> queue = new PriorityQueue<>();
        Set<Node> treeSet = new TreeSet<>();

        for (int[] interval : intervals) {
            int size = interval[1] - interval[0] + 1;
//            queue.add(new Node(size, interval));
            treeSet.add(new Node(size, interval));
        }

        int[] result = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            Iterator<Node> iterator = treeSet.iterator();
            boolean found = false;
            while (iterator.hasNext()) {
                Node current = iterator.next();
                int[] currInterval = current.intervals;
                if (query >= currInterval[0] && query <= currInterval[1]) {
                    result[index] = currInterval[1] - currInterval[0] + 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[index] = -1;
            }
            index++;
        }

        return result;
    }

    static class Node implements Comparable<Node> {
        int size;
        int[] intervals;

        public Node(int size, int[] intervals) {
            this.size = size;
            this.intervals = intervals;
        }

        @Override
        public int compareTo(Node o) {
            if (this.size == o.size) {
                return this.intervals[1] - o.intervals[1];
            }
            return this.size - o.size;
        }
    }

}
