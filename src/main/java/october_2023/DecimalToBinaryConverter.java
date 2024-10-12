package october_2023;

public class DecimalToBinaryConverter {

    public static void main(String[] args) {
        int num = 3891;

        String result = decToBin(num);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public static String decToBin(int num) {

        StringBuilder builder = new StringBuilder();  // 1 1 1 0 0 1 1 0 0 1 1 1
        while (num > 0) {
            int val = num % 2; // 3
            if (val == 0) {
                builder.append(0);
            } else {
                builder.append(1);
            }
            num /= 2;
        }

        return builder.reverse().toString();

    }

}
