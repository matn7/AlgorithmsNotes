package october_2025;

public class GuessNumberHigherOrLower {

    // O(log(n)) time | O(1) space
    public int guessNumber(int n) {
        int l = 1;
        int r = n;

        while (l <= r) {
            int num = l + (r - l) / 2;
            int guess = guess(num);
            if (guess == -1) {
                r = num - 1;
            } else if (guess == 1) {
                l = num + 1;
            } else {
                return num;
            }
        }
        return -1;
    }

    private int guess(int num) {
        return -1;
    }

}
