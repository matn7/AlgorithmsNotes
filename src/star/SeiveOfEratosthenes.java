package star;

public class SeiveOfEratosthenes {

    public static void main(String[] args) {
        boolean[] primes = new boolean[40];

        SeiveOfEratosthenes seiveOfEratosthenes = new SeiveOfEratosthenes();
        seiveOfEratosthenes.seive(40, primes);

        System.out.println();
    }

    public void seive(int n, boolean[] primes) {

        for (int i = 2; i * i < n; i++) {
            if (!primes[i]) {
                for (int j = i * 2; j < n; j += i) {
                    primes[j] = true;
                }
            }
        }

    }

}
