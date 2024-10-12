package august_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GCDUsingPrimeFactors {

    // Funkcja do rozkładania liczby na czynniki pierwsze
    public static Map<Integer, Integer> primeFactors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();
        // Sprawdzanie liczby 2
        while (n % 2 == 0) {
            factors.put(2, factors.getOrDefault(2, 0) + 1);
            n /= 2;
        }
        // Sprawdzanie liczb nieparzystych od 3 wzwyż
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }
        // Jeśli pozostała część n jest liczbą pierwszą
        if (n > 2) {
            factors.put(n, 1);
        }
        return factors;
    }

    // Funkcja do obliczania NWD na podstawie rozkładów na czynniki pierwsze
    public static int gcdUsingPrimeFactors(int a, int b) {
        Map<Integer, Integer> factorsA = primeFactors(a);
        Map<Integer, Integer> factorsB = primeFactors(b);
        int gcd = 1;

        // Przechodzimy przez czynniki pierwsze pierwszej liczby
        for (int prime : factorsA.keySet()) {
            if (factorsB.containsKey(prime)) {
                gcd *= Math.pow(prime, Math.min(factorsA.get(prime), factorsB.get(prime)));
            }
        }

        return gcd;
    }

    public static void main(String[] args) {
        int a = 48;
        int b = 180;
        System.out.println("GCD of " + a + " and " + b + " is " + gcdUsingPrimeFactors(a, b));
        // Wynik: GCD of 48 and 180 is 12
    }
}