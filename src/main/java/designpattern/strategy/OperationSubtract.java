package designpattern.strategy;

/**
 * @author LongyunBian
 * @version 2023/9/5 0:29
 */
public class OperationSubtract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1-num2;
    }
}
