package august_2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerfulNumberChecker {
    // [4, 8, 9, 16, 25, 27, 32, 36, 49, 64, 72, 81]

    public static void main(String[] args) {
//        System.out.println(powerfulNumber(100));

        System.out.println(powerfulNumber(100));

//        boolean[] primeSieve = isPrimeSieve(100);
//        for (int i = 0; i < 100; i++) {
//            if (primeSieve[i]) {
//                System.out.println(i + " - is Prime");
//            }
//        }

    }

    public static boolean isPowerfulNumber(int n) {
        if (n <= 0) {
            return false;
        }

        // 36
        // 2; 4 <= 36; 2++
        // 9 % 2 == 0
        for (int prime = 2; prime * prime <= n; prime++) {
            int count = 0; // 2
            while (n % prime == 0) {
                n /= prime;
                count++;
            }
            if (count % 2 != 0) {
                return false;
            }
            if (n > 1) {
                int sqrtN = (int) Math.sqrt(n);
                if (sqrtN * sqrtN != n) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> powerfulNumber(int number) {
        List<Integer> powerfulNumbers = new ArrayList<>();

        boolean[] primes = isPrimeSieve(number);
        List<Integer> primesArr = new ArrayList<>();

        for (int i = 0; i < number / 2; i++) {
            if (primes[i]) {
                primesArr.add(i);
            }
        }

        // [2, 3, 5, 7, 11, 13, 17, 23]
        //

        for (int num = 0; num <= number; num++) {
            // num = 20
            List<Integer> divPrime = new ArrayList<>(); // [2, 3,
            for (int prime : primesArr) {
                // num % prime == 0, (36 % 7 == 0)
                if (num < prime) {
                    break;
                }
                if (num % prime == 0) {
                    divPrime.add(prime);
                }
            }
            if (divPrime.isEmpty()) {
                continue;
            }
            int count = divPrime.size();
            for (Integer prime : divPrime) {
                if (num % (prime * prime) == 0) {
                    count--;
                }
            }

            if (count == 0) {
                powerfulNumbers.add(num);
            }
        }

        return powerfulNumbers;
    }

    private static boolean[] isPrimeSieve(int num) {
        boolean[] primes = new boolean[num];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i <= Math.ceil(Math.sqrt(num)); i++) {
            if (primes[i]) {
                for (int mul = i * 2; mul < num; mul += i) {
                    primes[mul] = false;
                }
            }
        }
        return primes;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
