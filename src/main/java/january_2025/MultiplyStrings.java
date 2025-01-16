package january_2025;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123456789";
        String num2 = "987654321";

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String multiply = multiplyStrings.multiply(num1, num2);
        System.out.println(multiply);
    }

    public String multiply(String num1, String num2) {
        int[] arr1 = new int[num1.length()];
        int[] arr2 = new int[num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            arr1[i] = num1.charAt(i) - '0';
        }

        for (int i = 0; i < num2.length(); i++) {
            arr2[i] = num2.charAt(i) - '0';
        }

        long sum = 0;
        int pow = 1;

        for (int i = arr1.length - 1; i >= 0; i--) {
            int a = arr1[i]; // 3
            long subSum = 0;
            int p = 1;
            for (int j = arr2.length - 1; j >= 0; j--) {
                int b = arr2[j]; // 6
                subSum = subSum + (long) a * b * p;
                p = p * 10;
            }
            sum = sum + subSum * pow;
            pow = pow * 10;
        }

        return String.valueOf(sum);
    }

}
