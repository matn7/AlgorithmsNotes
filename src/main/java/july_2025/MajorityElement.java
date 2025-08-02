package july_2025;

public class MajorityElement {

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        MajorityElement majorityElement = new MajorityElement();
        int result = majorityElement.majorityElement(nums);
        System.out.println(result);
    }

    //             *
    // 2,2,1,1,1,2,2}
    // O(n) time | O(1) space
    public int majorityElement(int[] nums) {
        int res = 0; // 2
        int count = 0; // 1
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else if (res == num) {
                count++;
            } else {
                count--;
            }
        }
        return res;
    }


}
