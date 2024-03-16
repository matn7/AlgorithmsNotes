package november_2023;

public class BestSeats {

    public static void main(String[] args) {
        int[] seats = {1, 0, 1, 0, 0, 0, 1};

        bestSeats(seats);
    }

    // O(n) time | O(1) space
    public static int bestSeats(int[] seats) {
        //  l
        // [1, 0, 1, 0, 0, 0, 1]
        //        r
        int bestSeats = -1;
        int maxSpace = 0;
        int left = 0;

        while (left < seats.length) {
            int right = left + 1;
            while (right < seats.length && seats[right] == 0) {
                right++;
            }
            int availableSpace = right - left - 1;
            if (availableSpace > maxSpace) {
                bestSeats = (left + right) / 2;
                maxSpace = availableSpace;
            }
            left = right;
        }
        return bestSeats;
    }

}
