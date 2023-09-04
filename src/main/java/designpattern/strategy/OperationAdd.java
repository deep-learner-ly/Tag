package designpattern.strategy;

/**
 * @author LongyunBian
 * @version 2023/9/5 0:28
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
