package august_2024;

public class TwoUniqueNumbersV2 {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5, 3, 1, 5, 7};

        int[] result = twoUniqueNumbersChecker(arr);
    }

    public static int[] twoUniqueNumbersChecker(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum ^= num;
        }
        int pos = 0;
        while ((sum & 1) == 0) {
            sum = sum >> 1;
            pos++;
        }

        int setA = 0;
        int setB = 0;
        int mask = 1 << pos;
        for (int num : arr) {
            if ((num & mask) == 1) {
                setB = num;
            } else {
                setA = num;
            }
        }

        return new int[] {setA, setB};

    }

}
