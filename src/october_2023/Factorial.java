package october_2023;

public class Factorial {

    public static void main(String[] args) {
        int num = 6;

        System.out.println(factorialV1(num));
        System.out.println(factorialV2(num));
        System.out.println(factorialV3(num));
    }

    // O(n) time | O(n) space
    public static int factorialV1(int num) {
        if (num == 1) {
            return 1;
        }
        return num * factorialV1(num - 1);
    }

    // O(n) time | O(1) space
    public static int factorialV2(int num) {
        if (num == 1) {
            return 1;
        }
        int sum = 1;
        for (int i = num; i >= 1; i--) {
            sum *= i;
        }

        return sum;
    }

    // O(n) time | O(1) space
    public static int factorialV3(int num) {
        return factorialV3Helper(num, 1);
    }

    private static int factorialV3Helper(int num, int x) {
        if (num == 0) {
            return x;
        } else {
            return factorialV3Helper(num - 1, x * num);
        }
    }

}
