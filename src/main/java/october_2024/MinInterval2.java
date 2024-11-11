package october_2024;

import java.util.*;

public class MinInterval2 {

    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {2, 4}, {3, 6}, {4, 4}};
        int[] queries = {2, 3, 4, 5};

        // [4,5],[5,8],[1,9],[8,10],[1,6]
//        int[][] intervals = {{4,5}, {5,8}, {1,9}, {8,10}, {1,6}};

        MinInterval2 minInterval = new MinInterval2();
        int[] result = minInterval.minInterval(intervals, queries);
        System.out.println(result);
    }

    public int[] minInterval(int[][] intervals, int[] queries) {
        Map<Integer, Set<Node>> treeMap = new TreeMap<>();
        List<Integer> sizesArray = new ArrayList<>();
        for (int[] interval : intervals) {
            int size = interval[1] - interval[0] + 1;
            Set<Node> nodes;
            if (treeMap.containsKey(size)) {
                nodes = treeMap.get(size);
            } else {
                nodes = new TreeSet<>();
            }
            nodes.add(new Node(size, interval));
            treeMap.put(size, nodes);
        }

        int[] sizes = new int[treeMap.size()];

        Set<Integer> integers = treeMap.keySet();
        int idx = 0;
        for (Integer i : integers) {
            sizes[idx] = i;
            idx++;
        }

        int[] result = new int[queries.length];
        int index = 0;
        for (int query : queries) {
            boolean found = false;

            int start = 0;
            int end = treeMap.size() - 1;

            while (start <= end) {
                int mid = (start + end) / 2;
                int midVal = sizes[mid];
                Set<Node> nodes = treeMap.get(midVal);

                int max = Integer.MIN_VALUE;
                for (Node node : nodes) {
                    int[] nodeInterval = node.intervals;
                    max = Math.max(max, nodeInterval[1]);
                    if (query >= nodeInterval[0] && query <= nodeInterval[1]) {
                        result[index] = node.size; // it doesn't mean it is min possible!
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
                if (query > max) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
                System.out.println();

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
