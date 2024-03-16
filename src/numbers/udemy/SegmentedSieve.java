package numbers.udemy;

import java.util.ArrayList;
import java.util.List;

public class SegmentedSieve {

    public static void main(String[] args) {
        SegmentedSieve sieve = new SegmentedSieve();
        List<Integer> result = sieve.segmentedSieve(200, 250);
        for (Integer res : result) {
            System.out.print(res + " ");
        }
    }

    private static final int N = 100000;

    List<Long> primes;

    public List<Integer> segmentedSieve(int m, int n) {
        primes = SieveOfEratosthenes.primeSieve(N);

        List<Integer> segment = new ArrayList<>();
        for (int i = 0; i < n - m + 1; i++) {
            segment.add(0);
        }

        for (Long p : primes) {
            // stop when p^2 > n
            if (p*p > n) {
                break;
            }

            // otherwise we need to find the nearest starting point
            long start = (m/p) * p;

            // special case
            if (p >= m && p <= n) {
                start = 2 * p;
            }

            // start marking the numbers as not prime from start
            for (long j = start; j <= n; j =  j + p) {
                if (j < m) {
                    continue;
                }
                segment.set((int) j - m, 1);
            }
        }
        // primes stored as 0 in segment
        List<Integer> result = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if (segment.get(i - m) == 0 && i != 1) {
                result.add(i);
            }
        }
        return result;
    }

}
