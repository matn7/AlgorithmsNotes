package educative.topologicalsort;

import java.util.*;

public class AllTaskSchedulingOrders {

    // O(v! * e) time | O(v! * e) space
    public static void printOrders(int tasks, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (tasks <= 0) {
            return;
        }

        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < tasks; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0];
            int child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        printAllTopologicalSorts(graph, inDegree, sources, sortedOrder);
    }

    private static void printAllTopologicalSorts(HashMap<Integer, List<Integer>> graph,
                                                 HashMap<Integer, Integer> inDegree,
                                                 Queue<Integer> sources, List<Integer> sortedOrder) {
        if (!sources.isEmpty()) {
            for (Integer vertex : sources) {
                sortedOrder.add(vertex);
                Queue<Integer> sourcesForNextCell = cloneQueue(sources);
                sourcesForNextCell.remove(vertex);
                List<Integer> children = graph.get(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) - 1);
                    if (inDegree.get(child) == 0) {
                        sourcesForNextCell.add(child);
                    }
                }

                printAllTopologicalSorts(graph, inDegree, sourcesForNextCell, sortedOrder);

                sortedOrder.remove(vertex);
                for (int child : children) {
                    inDegree.put(child, inDegree.get(child) + 1);
                }
            }
        }

        if (sortedOrder.size() == inDegree.size()) {
            System.out.println(sortedOrder);
        }
    }

    private static Queue<Integer> cloneQueue(Queue<Integer> queue) {
        Queue<Integer> clone = new LinkedList<>();
        for (Integer num : queue) {
            clone.add(num);
        }
        return clone;
    }

    public static void main(String[] args) {
        AllTaskSchedulingOrders.printOrders(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(4,
                new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
        System.out.println();

        AllTaskSchedulingOrders.printOrders(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 }, new int[] { 0, 4 },
                new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
        System.out.println();
    }

}
