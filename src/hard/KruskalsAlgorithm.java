package hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalsAlgorithm {

    public static void main(String[] args) {
        int[][][] edges = {
                {{1,3}, {2,5}},
                {{0,3}, {2,10}, {3,12}},
                {{0,5}, {1,10}},
                {{1,12}}
        };

        KruskalsAlgorithm kruskalsAlgorithm = new KruskalsAlgorithm();
        kruskalsAlgorithm.kruskalsAlgorithm(edges);
    }

    // ********
    // * STAR *
    // ********

    // O(e * log(e)) time | O(e + v) space
    public int[][][] kruskalsAlgorithm(int[][][] edges) {
        // Write your code here.
        List<Integer[]> edgeList = new ArrayList<>();

        for (int sourceIndex = 0; sourceIndex < edges.length; sourceIndex++) {
            int[][] vertex = edges[sourceIndex];
            for (int[] edge : vertex) {
                if (edge[0] > sourceIndex) {
                    edgeList.add(new Integer[]{sourceIndex, edge[0], edge[1]});
                }
            }
        }
        edgeList.sort(Comparator.comparingInt(e -> e[2]));
        List<Integer[]> sortedEdges = new ArrayList<>(edgeList);

        List<Integer> parents = new ArrayList<>();
        List<Integer> ranks = new ArrayList<>();
        List<List<int[]>> mst = new ArrayList<>();
        for (int vertex = 0; vertex < edges.length; vertex++) {
            parents.add(vertex);
            ranks.add(0);
            mst.add(new ArrayList<>());
        }

        for (Integer[] edge : sortedEdges) {
            Integer vertex1Root = find(edge[0], parents);
            Integer vertex2Root = find(edge[1], parents);
            if (vertex1Root != vertex2Root) {
                mst.get(edge[0]).add(new int[]{edge[1], edge[2]});
                mst.get(edge[1]).add(new int[]{edge[0], edge[2]});
                union(vertex1Root, vertex2Root, parents, ranks);
            }
        }

        int[][][] result = new int[edges.length][][];

        for (int i = 0; i < mst.size(); i++) {
            List<int[]> edge = mst.get(i);
            result[i] = new int[edge.size()][2];
            for (int j = 0; j < edge.size(); j++) {
                int[] e = edge.get(j);
                result[i][j] = e;
            }
        }

        return result;
    }

    private Integer find(Integer vertex, List<Integer> parents) {
        if (vertex != parents.get(vertex)) {
            parents.set(vertex, find(parents.get(vertex), parents));
        }
        return parents.get(vertex);
    }

    private void union(Integer vertex1Root, Integer vertex2Root, List<Integer> parents, List<Integer> ranks) {
        if (ranks.get(vertex1Root) < ranks.get(vertex2Root)) {
            parents.set(vertex1Root, vertex2Root);
        } else if (ranks.get(vertex1Root) > ranks.get(vertex2Root)) {
            parents.set(vertex2Root, vertex1Root);
        } else {
            parents.set(vertex2Root, vertex1Root);
            ranks.set(vertex1Root, ranks.get(vertex1Root) + 1);
        }
    }


}
