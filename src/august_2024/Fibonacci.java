package august_2024;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    public static void main(String[] args) {
        fib(3);
        fib(5);
        fib(6);
        fib(10);

        fibRec(6);
    }

    public static List<Integer> fibRec(int n) {
        List<Integer> result = new ArrayList<>();
        if (n >= 1) {
            result.add(0);
        }
        if (n >= 2) {
            result.add(1);
        }

        fibRecHelper(n, result);

        return result;
    }

    private static int fibRecHelper(int n, List<Integer> result) {
        if (n == 1) {
            return result.get(0);
        }
        if (n == 2) {
            return result.get(1);
        }
        int res = fibRecHelper(n - 1, result) + fibRecHelper(n - 2, result);
        result.add(res);
        return res;
    }

    public static void fib(int n) {
        List<Integer> result = new ArrayList<>();
        int prevprev = 0;
        int prev = 1;
        if (n >= 1) {
            result.add(prevprev);
        }
        if (n >= 2) {
            result.add(prev);
        }
        int b;
        for (int i = 2; i < n; i++) {
            b = prev + prevprev;
            result.add(b);
            prevprev = prev;
            prev = b;
        }

        for (Integer num : result) {
            System.out.print(num + " ");
        }

    }

}
