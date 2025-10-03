package september_2025;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 19;

        HappyNumber happyNumber = new HappyNumber();
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public boolean isHappy(int n) {

        Set<Integer> calculated = new HashSet<>();

        while (n != 1) {
            int temp = n;
            int sum = 0;
            while (temp != 0) {
                int num = temp % 10;
                sum += num * num;
                temp = temp / 10;
            }
            if (calculated.contains(sum)) {
                return false;
            }
            calculated.add(sum);
            n = sum;
        }

        return true;
    }

}
