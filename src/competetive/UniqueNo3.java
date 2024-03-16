package competetive;

public class UniqueNo3 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 8, 4, 3, 1, 5, 5, 654, 3, 1, 4, 4, 8};

        uniqueNo3(arr);

    }

    // O(n) time | O(32) space
    public static int uniqueNo3(int[] arr) {
        int[] sums = new int[32];

        int BIT_MASK = 1;

        for (int num : arr) {
            int counter = 0;
            while (num > 0) {
                if ((num & BIT_MASK) == 1) {
                    sums[counter] += 1;
                }
                counter++;
                num = num >> 1;
            }
        }
        for (int i = 0; i < sums.length; i++) {
            sums[i] = sums[i] % 3;
        }
        int result = 0;
        int pow = 0;
        for (int num : sums) {
            if (num == 1) {
                result += Math.pow(2, pow);
            }
            pow++;
        }
        return result;
    }

    private static void printBitOne(int number) {
        int BIT_MAST = 1;
        while (number > 0) {
            if ((number & BIT_MAST) == 1) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            number = number >> 1;
            //  1  1 1 0 0 0
            // 32 16 8 4 2 1
        }
    }

}
