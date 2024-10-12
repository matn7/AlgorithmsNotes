package udemy.faang.datastructuresalgorithms;

public class Factorial {

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        int resRec = factorial.findFactorialRecursive(6);
        int resIter = factorial.findFactorialIterative(6);
        int resIter2 = factorial.findFactorialIterative2(6);
        System.out.println();
    }

    // O(n) time | O(n) space
    public int findFactorialRecursive(int number) {
        if (number == 1) {
            return 1;
        }
        return number * findFactorialRecursive(number - 1);
    }

    // O(n) time | O(1) space
    public int findFactorialIterative(int number) {
        int answer = 1;
        while (number > 1) {
            answer *= number;
            number--;
        }
        return answer;
    }

    public int findFactorialIterative2(int number) {
        int answer = 1;
        for (int i = 2; i <= number; i++) {
            answer *= i;
        }
        return answer;
    }

}
