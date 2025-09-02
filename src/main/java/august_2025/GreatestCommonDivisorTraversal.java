package august_2025;

import java.util.HashMap;
import java.util.Map;

public class GreatestCommonDivisorTraversal {

    class UnionFind {
        private int n;
        private int[] Parent;
        private int[] Size;

        public UnionFind(int n) {
            this.n = n;
            this.Parent = new int[n + 1];
            this.Size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                this.Parent[i] = i;
                this.Size[i] = 1;
            }
        }

        public int find(int node) {
            if (Parent[node] != node) {
                Parent[node] = find(Parent[node]);
            }
            return Parent[node];
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return false;
            n--;
            if (Size[pu] < Size[pv]) {
                int temp = pu;
                pu = pv;
                pv = temp;
            }
            Size[pu] += Size[pv];
            Parent[pv] = pu;
            return true;
        }

        public boolean isConnected() {
            return n == 1;
        }
    }

    // 2709
    // O(m + n * sqrt(m)) time | O(n log(m)) space
    // n - size of nums, m - max num in nums
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> factorIndex = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int f = 2;
            while (f * f <= num) {
                if (num % f == 0) {
                    if (factorIndex.containsKey(f)) {
                        uf.union(i, factorIndex.get(f));
                    } else {
                        factorIndex.put(f, i);
                    }
                    while (num % f == 0) {
                        num /= f;
                    }
                }
                f++;
            }
            if (num > 1) {
                if (factorIndex.containsKey(num)) {
                    uf.union(i, factorIndex.get(num));
                } else {
                    factorIndex.put(num, i);
                }
            }
        }

        return uf.isConnected();
    }


}
