package october_2024;

public class MinFlips2 {

    public static void main(String[] args) {
        String s = "010";

        MinFlips2 minFlips2 = new MinFlips2();
        int result = minFlips2.minFlips(s);
        System.out.println(result);
    }

    public int minFlips(String s) {
        int n = s.length();
        s = s + s;
        StringBuilder alt1Builder = new StringBuilder();
        StringBuilder alt2Buildre = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            alt1Builder.append(i % 2 == 0 ? "0" : "1");
            alt2Buildre.append(i % 2 == 0 ? "1" : "0");
        }
        String alt1 = alt1Builder.toString();
        String alt2 = alt2Buildre.toString();

        int res = s.length();
        int diff1 = 0;
        int diff2 = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) != alt1.charAt(r)) {
                diff1++;
            }
            if (s.charAt(r) != alt2.charAt(r)) {
                diff2++;
            }
            if ((r - l + 1) > n) {
                if (s.charAt(l) != alt1.charAt(l)) {
                    diff1--;
                }
                if (s.charAt(l) != alt2.charAt(l)) {
                    diff2--;
                }
                l++;
            }
            if (r - l + 1 == n) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }
        return res;
    }

}
