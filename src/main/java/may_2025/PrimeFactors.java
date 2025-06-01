package may_2025;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimeFactors {

    public static void main(String[] args) {
        PrimeFactors primeFactors = new PrimeFactors();
        List<Integer> result = primeFactors.primeFactors(24);
        System.out.println(result);
    }

    // O(sqrt(n)) time | O(log(n)) space
    public List<Integer> primeFactors(int num) {
        List<Integer> result = new ArrayList<>();

        while (num % 2 == 0) {
            num = num / 2;
            result.add(2);
        }

        for (int i = 3; i * i <= num; i += 2) {
            while (num % i == 0) {
                num = num / i;
                result.add(i);
            }
        }

        if (num > 1) {
            result.add(num);
        }

        return result;
    }

}
