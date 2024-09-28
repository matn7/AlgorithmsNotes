package july_2024;

public class HouseRobbery {

    public static void main(String[] args) {
        int[] nums = {6, 5, 5, 9, 3};

        //  0  1  2  3  4
        // [6, 5, 5, 9, 3]
        //  a  b
        //              *
    }

    public static int houseRobbery(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int house1 = nums[0]; // 15
        int house2 = Math.max(nums[0], nums[1]); // 15
        int ans = house2;
        for (int i = 2; i < nums.length; i++) {
            ans = Math.max(nums[i] + house1, house2); // max(3 + 11, 15) = 15
            house1 = house2;
            house2 = ans;
        }
        return ans;
    }
}
