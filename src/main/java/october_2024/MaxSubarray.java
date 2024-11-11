package october_2024;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaxSubarray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};

        MaxSubarray maxSubarray = new MaxSubarray();
        int result = maxSubarray.maxSumMinProduct(nums);
        System.out.println(result);
    }

    // leetcode 1856
    public int maxSumMinProduct(int[] nums) {
        BigInteger res = BigInteger.ZERO;
        Stack<Element> stack = new Stack<>();
        List<Long> prefix = new ArrayList<>();
        prefix.add(0l);

        int mod = (int) Math.pow(10, 9) + 7;
        for (int n : nums) {
            prefix.add(prefix.get(prefix.size() - 1) + n);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int newStart = i;
            while (!stack.isEmpty() && stack.peek().value.intValue() > n) {
                Element pop = stack.pop();
                int start = pop.index;
                BigInteger val = pop.value;
                BigInteger total = BigInteger.valueOf(prefix.get(i) - prefix.get(start));
                res = res.max(total.multiply(val));
                newStart = start;
            }
            stack.push(new Element(newStart, BigInteger.valueOf(n)));
        }

        while (!stack.isEmpty()) {
            Element pop = stack.pop();
            int start = pop.index;
            BigInteger val = pop.value;
            BigInteger total = BigInteger.valueOf(prefix.get(nums.length) - prefix.get(start));
            res = res.max(total.multiply(val));
        }

        return res.mod(BigInteger.valueOf(mod)).intValue();
    }

    static class Element {
        int index;
        BigInteger value;

        public Element(int index, BigInteger value) {
            this.index = index;
            this.value = value;
        }
    }

    public int maxSumMinProduct2(int[] nums) {
        BigInteger res = BigInteger.ZERO;

        for (int i = 0; i < nums.length; i++) {
            BigInteger currMin = BigInteger.valueOf(nums[i]);
            BigInteger sum = BigInteger.ZERO;
            for (int j = i; j < nums.length; j++) {
                currMin = currMin.min(BigInteger.valueOf(nums[j]));
                sum = sum.add(BigInteger.valueOf(nums[j])).mod(BigInteger.valueOf((int) Math.pow(10, 9) + 7));
                BigInteger multiply = sum.multiply(currMin);
                res = res.max(multiply);
            }
        }

        return res.intValue();
    }

}
