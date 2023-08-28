package basics;

/**
 * @author: LongyunBian
 * @date: 2023/8/18 23:17
 * @Description: finally的用法
 */
public class FinallyDemo {
    public static void main(String[] args) {
        System.out.println(new FinallyDemo().finallyTest());
    }
    public String finallyTest(){
        try {
            int x = 1/0;
            return "a";
        }
        catch(Exception e){
            return "b";
        }
        finally{
            return "c";
        }
    }
}
