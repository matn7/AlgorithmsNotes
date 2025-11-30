package november_2025;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        Map<String, Integer> emailToAccount = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> a = accounts.get(i);

            for (int j = 1; j < a.size(); j++) {
                String e = a.get(j);
                if (emailToAccount.containsKey(e)) {
                    uf.union(i, emailToAccount.get(e));
                } else {
                    emailToAccount.put(e, i);
                }
            }
        }

        Map<Integer, List<String>> emailGroup = new HashMap<>();
        for (Map.Entry<String, Integer> element : emailToAccount.entrySet()) {
            String e = element.getKey();
            int i = element.getValue();
            int leader = uf.find(i);
            if (!emailGroup.containsKey(leader)) {
                emailGroup.put(leader, new ArrayList<>());
            }
            emailGroup.get(leader).add(e);
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> element : emailGroup.entrySet()) {
            int i = element.getKey();
            List<String> emails = element.getValue();
            String name = accounts.get(i).get(0);
            List<String> oneRes = new ArrayList<>();
            oneRes.add(name);
            Collections.sort(emails);
            oneRes.addAll(emails);
            res.add(oneRes);
        }
        return res;
    }

    class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
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

}
