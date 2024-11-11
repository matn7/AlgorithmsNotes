package november_2024;

public class RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
//        int val = 2;

        int[] nums = {3, 3};
        int val = 3;

        RemoveElement removeElement = new RemoveElement();
        int result = removeElement.removeElement(nums, val);
        System.out.println(result);
    }

    public int removeElement(int[] nums, int val) {
        int res = 0;  // This will track the number of valid elements.

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[res] = nums[i];  // Move valid elements to the front.
                res++;  // Increment count of valid elements.
            }
        }

        return res;  // The length of the array after removal.
    }


}
