package november_2025;

public class LocalMaximaInArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        LocalMaximaInArray localMaximaInArray = new LocalMaximaInArray();
        int peakElement = localMaximaInArray.findPeakElement(nums);
        System.out.println(peakElement);
    }

    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        return binarySearch(nums, l, r);
    }

    private int binarySearch(int[] nums, int l, int r) {
        int mid = (l + r) / 2;
        int searchLeft = mid > 0 ? nums[mid - 1] : Integer.MIN_VALUE;
        int searchRight = mid < nums.length - 1 ? nums[mid + 1] : Integer.MIN_VALUE;

        if (nums[mid] > searchLeft && nums[mid] > searchRight) {
            return mid;
        } else {
            int numLeft = binarySearch(nums, mid + 1, r);
            if (numLeft != -1) {
                return numLeft;
            }
            return binarySearch(nums, l, mid - 1);
        }
    }

}
