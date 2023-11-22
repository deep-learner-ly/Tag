package basics;

/**
 * @author LongyunBian
 * @version 2023/10/10 23:06
 */
public class 默认值 {
    public static void main(String[] args) {
        new 默认值().fun();
    }
    private void fun(){
        int [] x= new int[1];
        System.out.println(x[0]);
    }
}
