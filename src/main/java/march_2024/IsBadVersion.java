package march_2024;

public class IsBadVersion {

    public static void main(String[] args) {
        int result = firstBadVersion(6);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                if (mid == 1 || (mid - 1 > 0 && !isBadVersion(mid - 1))) {
                    return mid;
                } else {
                    right = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    private static boolean isBadVersion(int version) {
        return version >= 3;
    }

}
