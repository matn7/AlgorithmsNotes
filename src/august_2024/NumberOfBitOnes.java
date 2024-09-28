package august_2024;

public class NumberOfBitOnes {

    public static void main(String[] args) {
        int num = 23;

        int result = countBits(num);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int countBits(int num) {
        int bitMask = 1;
        int count = 0;
        while (num > 0) {
            if ((num & bitMask) == 1) {
                count++;
            }
            num = num >> 1;
        }
        return count;
    }

}
