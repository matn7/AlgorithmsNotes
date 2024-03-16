package october_2023;

import java.util.*;

public class PrimeSieveOfEratostenes {

    static int N = 1000000;

    public static void main(String[] args) {
        List<Integer> integers = primeSieve(20);
        primeSieve(20);
    }

    // O(nloglog(n)) time | O(n) space
    public static List<Integer> primeSieve(int k) {
        List<Integer> result = new ArrayList<>();
        boolean[] sieve = new boolean[k + 1];
        Arrays.fill(sieve, true);

        for (int i = 2; i < sieve.length; i++) {
            for (int p = i*i; p <= k; p += i) {
                sieve[p] = false;
            }
        }

        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                result.add(i);
            }
        }

        return result;
    }

    // O(nloglog(n)) time | O(n) space
    public static List<Long> primeSieve() {
        List<Long> result = new ArrayList<>();
        Map<Long, Boolean> sieveMap = new HashMap<>();
        for (long i = 0; i <= N; i++) {
            sieveMap.put(i, Boolean.TRUE);
        }
        sieveMap.put(0L, Boolean.FALSE);
        sieveMap.put(1L, Boolean.FALSE);

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

        return result;
    }

}
