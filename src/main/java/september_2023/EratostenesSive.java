package september_2023;

public class EratostenesSive {

    // O(nloglog(n)) time | O(n) space
    public void eratostenesSive(int n) {
        boolean[] isPrime = new boolean[n + 1];

        // Inicjalizacja tablicy isPrime: zakładamy, że wszystkie liczby są początkowo liczbami pierwszymi
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Implementacja algorytmu Sita Eratostenesa
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Wyświetlenie znalezionych liczb pierwszych
        System.out.println("Liczby pierwsze od 2 do " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
            }
        }
    }

}
