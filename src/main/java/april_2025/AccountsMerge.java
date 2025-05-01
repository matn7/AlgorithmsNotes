package april_2025;

import java.util.*;

public class AccountsMerge {

    // O((n*m)log(n*m)) time | O(n*m) space
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        Map<String, Integer> emailToAcc = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> a = accounts.get(i);
            for (int j = 1; j < a.size(); j++) {
                String e = a.get(j);
                if (emailToAcc.containsKey(e)) {
                    uf.union(i, emailToAcc.get(e));
                } else {
                    emailToAcc.put(e, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> elem : emailToAcc.entrySet()) {
            String e = elem.getKey();
            Integer i = elem.getValue();
            int leader = uf.find(i);
            emailGroup.computeIfAbsent(leader, x -> new ArrayList<>()).add(e);
        }

        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0));
            merged.addAll(emails);
            res.add(merged);
        }

        return res;
    }

}


class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x1, int x2) {
        int p1 = find(x1);
        int p2 = find(x2);
        if (p1 == p2) {
            return false;
        }
        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
