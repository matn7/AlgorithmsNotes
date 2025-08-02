package july_2025;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanner {

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {7, 2, 1, 2, 2};
        for (int price : prices) {
            System.out.println(stockSpanner.next(price));
        }
    }

    // O(n) time | O(n) space
    Stack<int[]> stack;
    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }
        stack.push(new int[] {price, span});
        return span;
    }

}
