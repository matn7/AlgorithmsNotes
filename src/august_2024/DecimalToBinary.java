package august_2024;

public class DecimalToBinary {

    public static void main(String[] args) {
        int num = 3891;

        String result = decToBin(num);
        System.out.println(result);
    }

    // O(log(n)) time | O(log(n)) space
    public static String decToBin(int num) {
        StringBuilder builder = new StringBuilder();

        while (num > 0) {
            if (num % 2 == 0) {
                builder.insert(0, '0');
            } else {
                builder.insert(0, '1');
            }
            num /= 2;
        }

        return builder.toString();
    }

}
