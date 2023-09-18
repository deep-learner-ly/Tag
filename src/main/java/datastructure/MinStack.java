package datastructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LongyunBian
 * @version 2023/9/18 17:52
 */
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }

    public void pop() {
        if(!xStack.isEmpty()){
            xStack.pop();
            minStack.pop();
        }

    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
