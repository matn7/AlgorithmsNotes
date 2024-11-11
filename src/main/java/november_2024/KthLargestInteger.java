package november_2024;

import java.math.BigInteger;
import java.util.PriorityQueue;

public class KthLargestInteger {

    public static void main(String[] args) {
        String[] nums = {"2", "21", "12", "1", "99"};
        int k = 3;

        KthLargestInteger kthLargestInteger = new KthLargestInteger();
        String result = kthLargestInteger.kthLargestNumber(nums, k);
        System.out.println(result);
    }

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> queue = new PriorityQueue<>();

        for (String num : nums) {
            BigInteger currNum = new BigInteger(num);
            if (queue.size() < k) {
                queue.add(currNum);
            } else {
                BigInteger topNumber = queue.peek(); // "2"
                // "1"
                if (currNum.compareTo(topNumber) > 0) {
                    queue.poll();
                    queue.add(currNum);
                }
            }
        }
        return queue.poll().toString();
    }


}
