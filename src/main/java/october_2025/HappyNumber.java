package october_2025;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public static void main(String[] args) {
        int n = 2;

        HappyNumber happyNumber = new HappyNumber();
        boolean result = happyNumber.isHappy(n);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while (n != 1) {
            int sum = 0;
            int temp = n;

            while (temp > 0) {
                int curr = temp % 10;
                sum += curr * curr;
                temp = temp / 10;
            }
            if (visited.contains(sum)) {
                return false;
            }

            n = sum;
            visited.add(n);
        }
        return true;
    }

}
