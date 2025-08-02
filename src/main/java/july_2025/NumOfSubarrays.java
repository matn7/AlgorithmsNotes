package july_2025;

public class NumOfSubarrays {

    public static void main(String[] args) {
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;

        NumOfSubarrays numOfSubarrays = new NumOfSubarrays();
        int result = numOfSubarrays.numOfSubarrays(arr, k, threshold);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int L = 0;
        int R = 0;
        int subSum = 0;
        int count = 0;
        while (R < arr.length) {
            while (R - L + 1 <= k) {
                subSum += arr[R];
                R++;
            }
            if (subSum / k >= threshold) {
                count++;
            }
            subSum -= arr[L];
            L++;
        }
        return count;
    }

}
