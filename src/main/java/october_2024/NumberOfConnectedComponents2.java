package october_2024;

import java.util.*;

public class NumberOfConnectedComponents2 {

    public static void main(String[] args) {
        int[][] edges = {{0,1}, {1,2}, {3,4}};
        int n = 5;

        NumberOfConnectedComponents2 numberOfConnectedComponents = new NumberOfConnectedComponents2();
        int result = numberOfConnectedComponents.countComponents(n, edges);
        System.out.println(result);
    }


    // leetcode 323 premium

    // O(v + e) time | O(v) space
    public int countComponents(int n, int[][] edges) {
        int[] par = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        int res = n;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int n1 = edge[0];
            int n2 = edge[1];
            res -= union(n1, n2, par, rank);
        }

        return res;
    }

    private int find(int n1, int[] par) {
        int res = n1;

        while (res != par[res]) {
            par[res] = par[par[res]];
            res = par[res];
        }
        return res;
    }

    public int union(int n1, int n2, int[] par, int[] rank) {
        int p1 = find(n1, par);
        int p2 = find(n2, par);
        if (p1 == p2) {
            return 0;
        }
        if (rank[p2] > rank[p1]) {
            par[p1] = p2;
            rank[p2] += rank[p1];
        } else {
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        return 1;
    }

}
