package november_2024;

public class RemoveDuplicates {


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int[] nums = {1, 1, 2};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int result = removeDuplicates.removeDuplicates(nums);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {

        int a = 0;
        int b = 0;

        while (b < nums.length) {
            int num = nums[b];
            while (b < nums.length && nums[b] == num) {
                b++;
            }
            nums[a] = num;
            a++;
        }
        return a;
    }

}
