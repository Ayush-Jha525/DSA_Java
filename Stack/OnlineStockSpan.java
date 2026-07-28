//Question : Design a class that collects daily stock prices and returns the stock span for each new price.
//      The span of a stock's price today is defined as:
//          The number of consecutive days (including today) for which the stock price was less than or equal to today's price.
// Amortized Time Complexity : O(1) per next() call
// Total Time Complexity for n calls : O(n)
//Space complexity : O(n) 

package Stack;

import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {
    ArrayList<Integer> spans;
    Stack<Integer> prices;

    public StockSpanner() {
        spans = new ArrayList<>();
        prices = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            span += spans.get(spans.size() - 1);
            spans.remove(spans.size() - 1);
        }
        prices.push(price);
        spans.add(span);
        return span;
    }
}

public class OnlineStockSpan {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.print(stockSpanner.next(100) + " ");
        System.out.print(stockSpanner.next(80) + " ");
        System.out.print(stockSpanner.next(60) + " ");
        System.out.print(stockSpanner.next(70) + " ");
        System.out.print(stockSpanner.next(60) + " ");
        System.out.print(stockSpanner.next(75) + " ");
        System.out.print(stockSpanner.next(85));
    }
}
