package november_2024;

import java.util.HashMap;
import java.util.Map;

public class IntegerBreak2 {

    public int integerBreak(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(1, 1);

        for (int num = 2; num <= n; num++) {
            dp.put(num, num == n ? 0 : num);
            for (int i = 1; i < num; i++) {
                int val = dp.get(i) * dp.get(num - i);
                dp.put(num,  Math.max(dp.get(num), val));
            }
        }
        return dp.get(n);
    }



}
