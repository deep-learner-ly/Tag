package algorithm.stack;

import datastructure.MyStack;

/**
 * @author LongyunBian
 * @version 2023/8/29 0:44
 */
public class 栈的最大元素 extends MyStack {

    private int max;
    private int count;

    public 栈的最大元素() {
        max = Integer.MIN_VALUE;
        count = -1;
    }

    @Override
    public void push(int item) {
        if(item>max){
            max = item;
            count = 1;
        } else if (item==max) {
            count++;
        }
        super.push(item);
    }

    @Override
    public int pop() {
        int item = super.pop();
        if(item==max){
            count--;
            if(count==0){
                // re
                max = Integer.MIN_VALUE;
                count = -1;
                vote();
            }
        }
        return item;
    }
    private void vote(){
        MyStack temp = new MyStack();
        while (!isEmpty()){
            temp.push(super.pop());
        }
        while (!temp.isEmpty()){
            push(temp.pop());
        }

    }
    public int max(){
        return max;
    }
}
