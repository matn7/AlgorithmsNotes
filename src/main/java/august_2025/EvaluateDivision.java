package august_2025;

import java.util.*;

public class EvaluateDivision {

    // O(n * (v + e)) time | O(v + e) space
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adj = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            if (!adj.containsKey(a)) {
                adj.put(a, new ArrayList<>());
            }
            if (!adj.containsKey(b)) {
                adj.put(b, new ArrayList<>());
            }
            adj.get(a).add(new Pair(b, values[i]));
            adj.get(b).add(new Pair(a, 1 / values[i]));
        }

        List<Double> result = new ArrayList<>();
        for (List<String> q : queries) {
            String s = q.get(0);
            String d = q.get(1);
            result.add(bfs(s, d, adj));
        }
        double[] res = new double[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }

    private double bfs(String src, String target, Map<String, List<Pair>> adj) {
        if (!adj.containsKey(src) || !adj.containsKey(target)) {
            return -1;
        }
        ArrayDeque<Pair> q = new ArrayDeque();
        Set<String> visit = new HashSet<>();
        q.add(new Pair(src, 1));
        visit.add(src);

        while (!q.isEmpty()) {
            Pair pair = q.pollFirst();
            String n = pair.vertex;
            double w = pair.edge;
            if (n.equals(target)) {
                return w;
            }

            List<Pair> neighbors = adj.get(n);
            for (Pair nei : neighbors) {
                if (!visit.contains(nei.vertex)) {
                    q.add(new Pair(nei.vertex, w * nei.edge));
                    visit.add(nei.vertex);
                }
            }
        }
        return -1;
    }

    static class Pair {
        String vertex;
        double edge;

        public Pair(String vertex, double edge) {
            this.vertex = vertex;
            this.edge = edge;
        }
    }

}
