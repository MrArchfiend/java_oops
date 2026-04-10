import java.util.Stack;

class StockSpan {
    static int[] calculateSpan(int[] price) {
        int n = price.length;
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }
            span[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        return span;
    }
}