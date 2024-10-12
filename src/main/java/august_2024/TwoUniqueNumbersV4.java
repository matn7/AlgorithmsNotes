package august_2024;

public class TwoUniqueNumbersV4 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 1,5, 7};

        int[] result = twoUniqueNumbers(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] twoUniqueNumbers(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum ^= num;
        }

        int temp = sum;
        int pos = 0;
        while ((temp & 1) == 0) {
            pos++;
            temp >>= 1;
        }
        int bitMask = 1 << pos;
        int setA = 0;
        int setB = 0;
        for (int num : arr) {
            if ((num & bitMask) == 0) {
                setA = num;
            } else {
                setB = num;
            }
        }

        return new int[] {setA, setB};
    }

}
