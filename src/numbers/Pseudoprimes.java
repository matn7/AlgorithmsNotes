package numbers;

import java.math.BigInteger;
import java.util.Scanner;

public class Pseudoprimes {

    // Pseudoprime to liczba, która wydaje się być liczbą pierwszą, ale w rzeczywistości nie jest.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę n: ");
        BigInteger n = scanner.nextBigInteger();

        System.out.print("Podaj liczbę a (1 < a < n): ");
        BigInteger a = scanner.nextBigInteger();

        if (isFermatPseudoprime(n, a)) {
            System.out.println(n + " jest pseudopierwsza Fermata dla liczby a=" + a);
        } else {
            System.out.println(n + " nie jest pseudopierwsza Fermata dla liczby a=" + a);
        }
    }

    // O(1) time | O(log(n)) space
    public static boolean isFermatPseudoprime(BigInteger n, BigInteger a) {
        // Sprawdź, czy a^(n-1) ≡ 1 (mod n)
        BigInteger exponent = n.subtract(BigInteger.ONE);
        BigInteger result = a.modPow(exponent, n);
        return result.equals(BigInteger.ONE);
    }
}
