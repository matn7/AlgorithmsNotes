package october_2024;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class SeatManager {

    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5);
    }

    // top seat to reserve
    private final PriorityQueue<Integer> topSeat;
    // currently used seats
//    private final Map<Integer, Boolean> occupiedSeat;

    public SeatManager(int n) {
        topSeat = new PriorityQueue<>();
//        occupiedSeat = new HashMap<>();
        initSeats(n);
    }

    private void initSeats(int n) {
        for (int i = 1; i <= n; i++) {
            topSeat.add(i);
//            occupiedSeat.put(1, Boolean.FALSE);
        }
    }

    public int reserve() {
//        occupiedSeat.put(lowestIdxSeat, Boolean.TRUE);
        return topSeat.poll();
    }

    public void unreserve(int seatNumber) {
//        occupiedSeat.put(seatNumber, Boolean.FALSE);
        topSeat.add(seatNumber);
    }
}