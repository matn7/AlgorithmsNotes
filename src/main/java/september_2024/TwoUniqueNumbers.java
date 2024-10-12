package september_2024;

public class TwoUniqueNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 1, 5, 7};
        int[] result = twoUniqueNumbers(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] twoUniqueNumbers(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        int temp = result;
        int pos = 0;
        while ((temp & 1) == 0) {
            temp >>= 1;
            pos++;
        }
        int mask = 1 << pos;
        int setA = 0;
        int setB = 0;
        for (int num : arr) {
            if ((num & mask) == 0) {
                setA = num;
            } else {
                setB = num;
            }
        }
        return new int[] {setA, setB};
    }

}
