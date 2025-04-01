package march_2025;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeFactors {

    public static void main(String[] args) {
        PrimeFactors primeFactors = new PrimeFactors();
        List<Integer> result = primeFactors.primeFactors(897);
        System.out.println(result);
        int res = 1;
        for (int num : result) {
            res *= num;
        }

        System.out.println(res);
    }

    public List<Integer> primeFactors(int number) {
        Map<Integer, Integer> primeFreqMap = new HashMap<>();

        while (number % 2 == 0) {
            primeFreqMap.put(2, primeFreqMap.getOrDefault(2, 0) + 1);
            number = number / 2;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFreqMap.put(i, primeFreqMap.getOrDefault(i, 0) + 1);
                number = number / i;
            }
        }
        if (number > 2) {
            primeFreqMap.put(number, 1);
        }
        List<Integer> result = new ArrayList<>();

        for (Map.Entry<Integer, Integer> elem : primeFreqMap.entrySet()) {
            Integer primeNum = elem.getKey();
            Integer primeFreq = elem.getValue();
            for (int i = 0; i < primeFreq; i++) {
                result.add(primeNum);
            }
        }

        return result;

    }

}
