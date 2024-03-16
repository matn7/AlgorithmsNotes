package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimeQueries {

    public static void main(String[] args) {
        primeQueries(3, 10);
    }

    private static final int N = 1000000;

    // O(nloglog(n) + n + Q) time | O(n) space
    public static int primeQueries(int start, int end) {
        // O(nloglog(n)) time | O(n) space
        List<Long> primes = primeSieve();
        int primeIdx = 0;
        int[] cumsum = new int[N];
        for (int i = 1; i < N; i++) {
            Long prime = primes.get(primeIdx);
            if (i == prime) {
                cumsum[i] = cumsum[i - 1] + 1;
                primeIdx++;
            } else {
                cumsum[i] = cumsum[i - 1];
            }
        }
        int result = cumsum[end + 1] - cumsum[start + 1];
        return result;
    }

    // O(n loglog(n)) time | O(n) space
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
