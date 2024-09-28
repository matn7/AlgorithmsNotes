package august_2024;

public class NumberOfBitsOne {

    public static void main(String[] args) {
        int num = 23;

        int result = numOfBitsOne(num);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int numOfBitsOne(int num) {
        int result = 0;
        int bitMask = 1;
        while (num > 0) {
            if ((num & bitMask) == 1) {
                result++;
            }
            num = num >> 1;
        }

        return result;
    }

}
