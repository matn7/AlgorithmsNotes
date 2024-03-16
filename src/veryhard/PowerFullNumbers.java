package veryhard;

import java.util.*;

public class PowerFullNumbers {

    public static void main(String[] args) {
        List<Integer> result = findPowerfulNum(2, 100);
        System.out.println(result);

//        List<Integer> primes = sieveOfEratosthenes(100);
//        System.out.println();
//
//        PowerFullNumbers powerFullNumbers = new PowerFullNumbers();
//        powerFullNumbers.powerfulIntegers(2, 3, 10);
    }

    public static List<Integer> findPowerfulNum(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i < end; i++) {
            if (isPrime2(i)) {
                primes.add(i);
            }
        }

        Set<Integer> s = new HashSet<>();

        for (int m = start; m <= end; m++) {
            List<Integer> each = new ArrayList<>();
            if (m == 100) {
                System.out.println();
            }
            for (int p = 0; p < primes.size(); p++) {
                Integer prime = primes.get(p);
                if (prime >= m) {
                    break;
                }
                if ((m % prime) == 0) {
                    each.add(prime);
                }
            }
            if (each.size() == 0) {
                continue;
            }
            int count = each.size();
            for (int num : each) {
                if (m % (num * num) == 0) {
                    count--;
                }
            }
            if (count == 0) {
                System.out.println(m + " isPowerful");
            }
        }
        return null;
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2 || n == 3) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            for (int i = 5; i * i <= n; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean isPrime2(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> sieveOfEratosthenes(int n) {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);

        for (int p = 2; p*p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p*p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }

        // Collect all prime numbers
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true) {
                primes.add(i);
            }
        }

        return primes;
    }

    //
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> s = new HashSet<>();
        // x^i + y^j
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; i + j <= bound; j *= y) {
                s.add(i + j);
                if (y == 1) break;
            }
            if (x == 1) break;
        }
        return new ArrayList<>(s);
    }
}
