package july_2025;

public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {3,2,2,3};
//        int val = 3;

        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;

        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElement(nums, val);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            while (i < nums.length && nums[i] != val) {
                i++;
            }
            while (j >= 0 && nums[j] == val) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(nums, i, j);
            i++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
