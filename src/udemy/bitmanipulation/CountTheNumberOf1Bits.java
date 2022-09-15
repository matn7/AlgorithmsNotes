package udemy.bitmanipulation;

public class CountTheNumberOf1Bits {

    int count_1s_optimized(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
    }

}
