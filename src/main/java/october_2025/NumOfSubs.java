package october_2025;

public class NumOfSubs {

    public static void main(String[] args) {
//        int[] arr = {2,2,2,2,5,5,5,8};
//        int k = 3;
//        int threshold = 4;

        int[] arr = {11,13,17,23,29,31,7,5,2,3};
        int k = 3;
        int threshold = 5;

        NumOfSubs numOfSubs = new NumOfSubs();
        int result = numOfSubs.numOfSubarrays(arr, k, threshold);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int L = 0;
        int R = 0;
        int sum = 0;

        while (R < arr.length) {
            if (R - L == k) {
                if (sum / k >= threshold) {
                    count++;
                }
                sum -= arr[L];
                L++;
            }
            sum += arr[R];
            R++;
        }
        if (R - L == k) {
            if (sum / k >= threshold) {
                count++;
            }
        }

        return count;
    }

}
