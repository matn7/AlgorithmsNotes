package march_2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SieveOfErathostenes {

    public static void main(String[] args) {

        SieveOfErathostenes sieveOfErathostenes = new SieveOfErathostenes();
        int result = sieveOfErathostenes.countPrimes(10);
        System.out.println(result);
    }

    // O(nlog(log(n))) time | O(n) space
    public int countPrimes(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                for (int j = i * 2; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (primes[i]) {
                res++;
            }
        }
        return res;
    }

    private List<Integer> sieveList(int num) {
        boolean[] primes = new boolean[num + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i <= num; i++) {
            if (primes[i]) {
                for (int j = i * 2; j <= num; j += i) {
                    primes[j] = false;
                }
            }
        }
        List<Integer> primesList = new ArrayList<>();
        for (int i = 0; i <= num; i++) {
            if (primes[i]) {
                primesList.add(i);
            }
        }
        return primesList;
    }

}
