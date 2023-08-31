package designpattern.singleton;

/**
 * @author LongyunBian
 * @version 2023/8/21 14:31
 */
public class DoubleCheck {
    private static volatile DoubleCheck instance;
    private DoubleCheck(){
        if(instance!=null){
            throw new RuntimeException("Singleton instance already exists");
        }
    }
    public DoubleCheck getInstance(){
        if(instance==null){
            synchronized (DoubleCheck.class){
                if(instance==null){
                    instance = new DoubleCheck();
                }
            }
        }
        return instance;
    }
}
