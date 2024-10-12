package august_2024;

public class PowerfulNumberCheckerV3 {

    public static void main(String[] args) {

        System.out.println(isPowerful(36));

    }

    public static boolean isPowerful(int num) {
        if (num <= 1) {
            return false;
        }

        for (int prime = 2; prime * prime <= num; prime++) {
            int count = 0;
            while (num % prime == 0) {
                num = num / prime;
                count++;
            }
            if (count % 2 != 0) {
                return false;
            }

            if (num > 1) {
                int sqrtN = (int) Math.sqrt(num);
                if (sqrtN * sqrtN != num) {
                    return false;
                }
            }
        }
        return true;
    }

}
