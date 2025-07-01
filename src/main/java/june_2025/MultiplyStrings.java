package june_2025;

public class MultiplyStrings {

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings multiplyStrings = new MultiplyStrings();
        String result = multiplyStrings.multiply(num1, num2);
        System.out.println(result);
    }

    // O(n*m) time | O(n+m) space
    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length() + num2.length()];

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i1 = 0; i1 < num1.length(); i1++) {
            int a = num1.charAt(i1) - '0';
            for (int i2 = 0; i2 < num2.length(); i2++) {
                int b = num2.charAt(i2) - '0';
                nums[i1 + i2] += (a * b);
                nums[i1 + i2 + 1] += nums[i1 + i2] / 10;
                nums[i1 + i2] %= 10;
            }
        }
        StringBuilder result = new StringBuilder();
        int i = nums.length - 1;

        while (nums[i] == 0) {
            i--;
        }
        while (i >= 0) {
            result.append(nums[i]);
            i--;
        }
        return result.toString();
    }


}
