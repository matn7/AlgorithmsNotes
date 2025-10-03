package september_2025;

import java.util.HashMap;
import java.util.Map;

public class LemonadeChange {

    public static void main(String[] args) {
//        int[] bills = {5, 5, 10, 20};
        int[] bills = {5,5,10,10,20};

        LemonadeChange lemonadeChange = new LemonadeChange();
        boolean result = lemonadeChange.lemonadeChange(bills);
        System.out.println(result);
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> packet = new HashMap<>();
        packet.put(5, 0); // {5: 2}
        packet.put(10, 0); // {10 : 0}
        packet.put(20, 0); // {20 : 0}

        int cost = 5;

        int[] changes = {20, 10, 5};

        // bills = [5,5,5,10,20]
        //                 *
        for (int bill : bills) {
            int R = bill - cost; // 10 - 5 = 5

            for (int change : changes) {
                if (R == 0) {
                    break;
                }
                if (change > R || packet.get(change) == 0) { // to big change or we do not have this coin in packet
                    continue;
                }
                while (R > 0 && change <= R && packet.get(change) >= 1) {  // 0 <= 5 && 2 >= 1
                    R = R - change;
                    packet.put(change, packet.getOrDefault(change, 0) - 1);
                }
            }
            if (R != 0) {
                return false;
            }
            packet.put(bill, packet.getOrDefault(bill, 0) + 1);
        }
        return true;
    }

}
