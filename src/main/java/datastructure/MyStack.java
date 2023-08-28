package datastructure;

/**
 * @author LongyunBian
 * @version 2023/8/29 0:46
 */
import java.util.ArrayList;
import java.util.EmptyStackException;

public class MyStack {
    private final ArrayList<Integer> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public void push(int item) {
        list.add(item);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.remove(list.size() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list.get(list.size() - 1);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }
}
