package november_2023;

public class BestSeatsV2 {

    public static void main(String[] args) {
        int[] seats = {1, 0, 1, 0, 0, 0, 1};

        bestSeats(seats);
    }

    // O(n) time | O(1) space
    public static int bestSeats(int[] seats) {
        //  l
        // [1, 0, 1, 0, 0, 0, 1]
        //        r
        int left = 0;
        int right = 1;
        int max = 0;
        int idx = 0;

        while (right < seats.length) {
            while (seats[right] == 0) {
                right++;
            }
            int space = right - left - 1;
            if (space > max) {
                max = space;
                idx = (right + left) / 2;
            }
            left = right;
            right++;
        }

        return idx;
    }

}
