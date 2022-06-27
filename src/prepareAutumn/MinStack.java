package prepareAutumn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sunchuanjia
 * @Description
 * @create 2022-06-27 23:04
 */
public class MinStack {
    Deque<Integer> minStack;
    Deque<Integer> xStack;
    public MinStack() {
        minStack = new LinkedList<>();
        xStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(val, minStack.peek()));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
