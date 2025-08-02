package july_2025;

public class NumArray {

    SegmentTree segmentTree;
    public NumArray(int[] nums) {
        segmentTree = SegmentTree.build(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        segmentTree.update(index, val);
    }

    public int sumRange(int left, int right) {
        return segmentTree.getRange(left, right);
    }

    static class SegmentTree {
        int sum;
        int L;
        int R;
        SegmentTree left;
        SegmentTree right;

        public SegmentTree(int sum, int l, int r) {
            this.sum = sum;
            L = l;
            R = r;
        }

        public static SegmentTree build(int[] nums, int L, int R) {
            if (L == R) {
                return new SegmentTree(nums[L], L, R);
            }
            int M = (L + R) / 2;
            SegmentTree root = new SegmentTree(0, L, R);
            root.left = build(nums, L, M);
            root.right = build(nums, M + 1, R);
            root.sum = root.left.sum + root.right.sum;
            return root;
        }

        public void update(int index, int val) {
            if (this.L == this.R) {
                this.sum = val;
                return;
            }
            int M = (this.L + this.R) / 2;
            if (index > M) {
                this.right.update(index, val);
            } else {
                this.left.update(index, val);
            }
            this.sum = this.left.sum + this.right.sum;
        }

        public int getRange(int L, int R) {
            if (L == this.L && R == this.R) {
                return this.sum;
            }
            int M = (this.L + this.R) / 2;
            if (L > M) {
                return this.right.getRange(L, R);
            } else if (R <= M) {
                return this.left.getRange(L, R);
            } else {
                return this.left.getRange(L, M) + this.right.getRange(M + 1, R);
            }
        }
    }

}
