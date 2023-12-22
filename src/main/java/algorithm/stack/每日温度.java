package algorithm.stack;

//给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，
//        下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。



//当用removeLast操作来代替pop操作，用addLast操作代替push操作时，会出现错误，一个是用于栈，另一个是用于队列，不可等价。
import java.util.*;
public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] count=new int[temperatures.length];

        for(int i=0;i<temperatures.length;i++){
            int temp=temperatures[i];
            while(!stack.isEmpty()&&temp>temperatures[stack.peek()]){
                int index=stack.pop();
                count[index]=i-index;
            }
            stack.push(i);

        }
        return count;
    }
}
