package december_2024;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;

        HappyNumber happyNumber = new HappyNumber();
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    public boolean isHappy(int n) {
        List<Integer> nums = getNums(n);
        int sum = 0;
        Set<Integer> seen = new HashSet<>();
        while (true) {
            for (Integer c : nums) {
                sum += c*c;
            }
            if (sum == 1) {
                return true;
            }
            if (seen.contains(sum)) {
                return false;
            }
            seen.add(sum);
            nums = getNums(sum);
            sum = 0;
        }
    }

    private List<Integer> getNums(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n = n / 10;
        }
        return nums;
    }
}
