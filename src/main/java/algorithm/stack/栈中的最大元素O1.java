package algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LongyunBian
 * @version 2023/9/26 17:51
 */
public class 栈中的最大元素O1 {
    Deque<Integer> xStack;
    Deque<Integer> maxStack ;

    public 栈中的最大元素O1() {
        xStack = new ArrayDeque<Integer>();
        maxStack = new ArrayDeque<Integer>();
        maxStack.push(Integer.MIN_VALUE);
    }

    public void push(int x) {
        xStack.push(x);
        maxStack.push(Math.max(maxStack.peek(), x));
    }

    public void pop() {
        xStack.pop();
        maxStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMax() {
        return maxStack.peek();
    }
}
