package september_2025;

public class Triboinacci {

    public static void main(String[] args) {
        Triboinacci triboinacci = new Triboinacci();
        int n = 4;
        int result = triboinacci.tribonacci(n);
        System.out.println(result);
    }

    // O(n) time | O(1) space
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        int res = t0 + t1 + t2;
        for (int i = 3; i < n; i++) {
            t0 = t1;
            t1 = t2;
            t2 = res;
            res = t0 + t1 + t2;
        }
        return res;
    }


}
