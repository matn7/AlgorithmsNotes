package november_2024;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntToRoman {


    public static void main(String[] args) {
        int num = 10;

        IntToRoman intToRoman = new IntToRoman();
        String result = intToRoman.intToRoman(num);
        System.out.println(result);
    }

    static List<Roman> symList = new ArrayList<>();

    static {
        symList.add(new Roman("I", 1));
        symList.add(new Roman("IV", 4));
        symList.add(new Roman("V", 5));
        symList.add(new Roman("IX", 9));
        symList.add(new Roman("X", 10));
        symList.add(new Roman("XL", 40));
        symList.add(new Roman("L", 50));
        symList.add(new Roman("XC", 90));
        symList.add(new Roman("C", 100));
        symList.add(new Roman("CD", 400));
        symList.add(new Roman("D", 500));
        symList.add(new Roman("CM", 900));
        symList.add(new Roman("M", 1000));
    }

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        for (int i = symList.size() - 1; i>= 0; i--) {
            Roman current = symList.get(i);
            String sym = current.symbol;
            int val = current.value;
            if (num / val != 0) {
                int count = num / val;
                res.append(sym.repeat(Math.max(0, count)));
                num = num % val;
            }
        }

        return res.toString();
    }

    static class Roman {
        String symbol;
        int value;

        public Roman(String symbol, int value) {
            this.symbol = symbol;
            this.value = value;
        }
    }

}
