package august_2025;

import java.util.*;

public class AccountsMerge {

    // O((n*m) * log(m*m)) time | O(n*m) space
    // n - num of accounts
    // m - num of emails
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

    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.rank = new int[n];

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }

        private int find(int n) {
            int p = n;

            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public boolean union(int n1, int n2) {
            int p1 = find(n1);
            int p2 = find(n2);

            if (p1 == p2) {
                return false;
            }
            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1]++;
            } else {
                parent[p1] = p2;
                rank[p2]++;
            }
            return true;
        }

    }

}
