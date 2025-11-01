package october_2025;

public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int val = 2;

//        int[] nums = {1};
//        int val = 1;

        int[] nums= {1,1,1,1,1};
        int val=1;

        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElement(nums, val);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;
        while (r >= l) {
            while (l <= r && nums[l] != val) {
                l++;
            }
            while (r >= l && nums[r] == val) {
                r--;
            }
            if (l > r) {
                break;
            }
            swap(nums, l, r);
        }

        return l;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
