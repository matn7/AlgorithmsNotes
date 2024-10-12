package november_2023;

public class TwoUniqueNumbers {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 3, 1, 5, 7};

        int[] result = uniqueNo2(arr);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public static int[] uniqueNo2(int[] arr) {
        int[] res = new int[2];
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        int pos = 0;
        int temp = xor;
        while ((temp & 1) == 0) {
            pos++;
            temp = temp >> 1;
        }
        int setA = 0;
        int setB = 0;
        int mask = 1 << pos;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & mask) > 0) {
                setA = setA ^ arr[i];
            } else {
                setB = setB ^ arr[i];
            }
        }
        res[0] = setA;
        res[1] = setB;

        return res;
    }
}
