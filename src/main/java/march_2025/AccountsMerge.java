package march_2025;

import java.util.*;

public class AccountsMerge {

    // O(n * m) * log(n * m)) time | O(n * m) space
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());

        Map<String, Integer> emailToAcc = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (String e : account) {
                if (emailToAcc.containsKey(e)) {
                    uf.union(i, emailToAcc.get(e));
                } else {
                    emailToAcc.put(e, i);
                }
            }
        }
        // Group emails by leader account
        Map<Integer, List<String>> emailGroup = new HashMap<>(); // index of acc -> list of emails
        for (Map.Entry<String, Integer> entry : emailToAcc.entrySet()) {
            String email = entry.getKey();
            int accId = entry.getValue();
            int leader = uf.find(accId);
            emailGroup.putIfAbsent(leader, new ArrayList<>());
            emailGroup.get(leader).add(email);
        }


        // Build result
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : emailGroup.entrySet()) {
            int accId = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(accId).get(0)); // Add account name
            merged.addAll(emails);
            res.add(merged);
        }

        return res;
    }

    static class UnionFind {
        int[] par;
        int[] rank;

        public UnionFind(int len) {
            int[] par = new int[len + 1];
            int[] rank = new int[len + 1];

            for (int i = 0; i <= len; i++) {
                par[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int n) {
            int p = par[n];
            while (p != par[p]) {
                par[p] = par[par[p]];
                p = par[p];
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
                par[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                par[p1] = p2;
                rank[p2] += rank[p1];
            }
            return true;
        }
    }

}
