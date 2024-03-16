package numbers.udemy;

import java.util.*;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        primeSieve();
    }

//    private static final int N = 10000000;

    private static final int N = 1000;

    // O(n loglog(n)) time | O(n) space
    public static List<Long> primeSieve() {

        List<Long> result = new ArrayList<>();

        Map<Long, Boolean> sieveMap = new HashMap<>();
        for (long i = 0; i <= N; i++) {
//            sieveMap.put(i, Boolean.FALSE);
            sieveMap.put(i, Boolean.TRUE);
        }

        sieveMap.put(0L, Boolean.FALSE);
        sieveMap.put(1L, Boolean.FALSE);

        // Optymalization mark all multiply of 2 as prime
//        for (long i = 3; i <= N; i += 2) {
//            sieveMap.put(i, Boolean.TRUE);
//        }

        // start for 2 and mark all multiples of ith number (prime) as not prime
        for (long i = 2; i <= N; i++) {
            if (sieveMap.get(i)) {
                for (long j = i * i; j <= N; j += i) {
                    sieveMap.put(j, Boolean.FALSE);
                }
            }
        }

        for (Map.Entry<Long, Boolean> element : sieveMap.entrySet()) {
            if (element.getValue()) {
                result.add(element.getKey());
            }
        }

        System.out.println(result.get(result.size() - 1) < N);
        for (Long element : result) {
            System.out.print(element + " ");
        }

        return result;
    }


    // O(n loglog(n)) time | O(n) space
    public static List<Long> primeSieve(int num) {

        List<Long> result = new ArrayList<>();

        Map<Long, Boolean> sieveMap = new HashMap<>();
        for (long i = 0; i <= num; i++) {
//            sieveMap.put(i, Boolean.FALSE);
            sieveMap.put(i, Boolean.TRUE);
        }

        sieveMap.put(0L, Boolean.FALSE);
        sieveMap.put(1L, Boolean.FALSE);

        // Optymalization mark all multiply of 2 as prime
//        for (long i = 3; i <= N; i += 2) {
//            sieveMap.put(i, Boolean.TRUE);
//        }

        // start for 2 and mark all multiples of ith number (prime) as not prime
        for (long i = 2; i <= num; i++) {
            if (sieveMap.get(i)) {
                for (long j = i * i; j <= num; j += i) {
                    sieveMap.put(j, Boolean.FALSE);
                }
            }
        }

        for (Map.Entry<Long, Boolean> element : sieveMap.entrySet()) {
            if (element.getValue()) {
                result.add(element.getKey());
            }
        }

        return result;
    }


}
