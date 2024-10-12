package february_2024;

import java.util.Arrays;

public class NonConstructableChange {

    public static void main(String[] args) {

        int[] nums = {5, 7, 1, 1, 2, 3, 22};

        int result = nonConstructableChange(nums);
        System.out.println(result);

    }

    public static int nonConstructableChange(int[] nums) {
        Arrays.sort(nums);

        int reduce = Arrays.stream(nums)
                .reduce(0, (coin, sum) -> {
                    System.out.println(coin + ":" + sum);
                    if (sum > coin + 1) {
                        return coin + 1;
                    }
                    return coin + sum;
                });


//        Arrays.stream(nums)
//                .reduce(0, (coin,sum) -> {
//                    System.out.println(coin + ":" + sum);
//                    if (coin > sum + 1) {
//                        return sum + 1;
//                    }
//                    sum += coin;
//                    return sum;
//                });
        return reduce;
    }

}
