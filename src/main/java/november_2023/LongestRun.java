package november_2023;

public class LongestRun {

    public static void main(String[] args) {
        int result = longestRun(255);
        System.out.println(result);
    }

    // O(log(n)) time | O(1) space
    public static int longestRun(int num) {

        int BIT_MASK = 1;
        int max = 0;

        while (num != 0) {
            int curr = 0;
            while ((num & BIT_MASK) == 1) {
                curr++;
                num = num >> 1;
            }
            max = Math.max(max, curr);
            num = num >> 1;
        }
        return max;
    }

}
