package may_2025;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfSquareNumbers {

    public static void main(String[] args) {
        SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
        System.out.println(sumOfSquareNumbers.judgeSquareSum(5));
    }

    // O(sqrt(c)) time | O(1) space
    public boolean judgeSquareSum(int c) {
        int l = 0;
        int r = (int) Math.sqrt(c);

        while (l <= r) {
            int total = l * l + r * r;
            if (total > c) {
                r--;
            } else if (total < c) {
                l++;
            } else {
                return true;
            }
        }

        return false;
    }

    // O(sqrt(c)) time | O(sqrt(c)) space
    public boolean judgeSquareSum2(int c) {
        Set<Integer> squareroot = new HashSet<>();
        for (int i = 0; i < Math.sqrt(c) + 1; i++) {
            squareroot.add(i * i);
        }
        int a = 0;
        while (a * a <= c) {
            int target = c - a * a;
            if (squareroot.contains(target)) {
                return true;
            }
            a++;
        }
        return false;
    }

}
