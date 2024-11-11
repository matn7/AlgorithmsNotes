package october_2024;

import java.util.*;

public class MaxAlternatingSum {

    public static void main(String[] args) {

        int[] nums = {6, 2, 1, 2, 4, 5};

        MaxAlternatingSum maxAlternatingSum = new MaxAlternatingSum();
        long result = maxAlternatingSum.maxAlternatingSum(nums);
        System.out.println(result);

    }

    public long maxAlternatingSum(int[] nums) {
        int sumEven = 0;
        int sumOdd = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            int tempEven = Math.max(sumOdd + nums[i], sumEven);
            int tempOdd = Math.max(sumEven - nums[i], sumOdd);
            sumEven = tempEven;
            sumOdd = tempOdd;
        }
        return sumEven;
    }

    private long dfs(int i, boolean even, Map<Element, Long> dp, int[] nums) {
        if (i == nums.length) {
            return 0;
        }
        Element elem = new Element(i, even);
        if (dp.containsKey(elem)) {
            return dp.get(elem);
        }
        long total = even ? nums[i] : (-1 * nums[i]);
        dp.put(elem, Math.max(total + dfs(i + 1, !even, dp, nums), dfs(i + 1, even, dp, nums)));
        return dp.get(elem);
    }

    class Element {
        int index;
        boolean even;

        public Element(int index, boolean even) {
            this.index = index;
            this.even = even;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element element = (Element) o;
            return index == element.index && even == element.even;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, even);
        }
    }


}
