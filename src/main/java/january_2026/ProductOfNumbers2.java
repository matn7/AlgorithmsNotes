package january_2026;

import java.util.ArrayList;

public class ProductOfNumbers2 {

    ArrayList<Integer> prefix;

    public ProductOfNumbers2() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            prefix.clear();
            prefix.add(1);
        } else {
            int lastNum = prefix.get(prefix.size() - 1);
            prefix.add(num * lastNum);
        }
    }

    public int getProduct(int k) {
        if (k >= prefix.size()) {
            return 0;
        }
        int n = prefix.size();

        return prefix.get(n - 1) / prefix.get(n - 1 - k);
    }

}
