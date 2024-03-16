package september_2023;

public class BestSeats {

    public static void main(String[] args) {
        int[] seats = {1, 0, 1, 0, 0, 0, 1};
        BestSeats bestSeats = new BestSeats();
        bestSeats.bestSeat(seats);
    }

    // O(n) time | O(1) space
    public int bestSeat(int[] seats) {
        // Write your code here.
        int bestSeat = -1;
        int maxSpace = 0;
        int left = 0;
        while (left < seats.length) {
            int right = left + 1;
            while (right < seats.length && seats[right] == 0) {
                right++;
            }
            int availableSpace = right - left - 1;
            if (availableSpace > maxSpace) {
                bestSeat = (left + right) / 2;
                maxSpace = availableSpace;
            }
            left = right;
        }
        return bestSeat;
    }

}
