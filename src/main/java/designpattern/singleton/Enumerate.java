package designpattern.singleton;

/**
 * @author LongyunBian
 * @version 2023/8/21 14:29
 */
public enum Enumerate {
    INSTANCE;
    public Enumerate getInstance(){
        return INSTANCE;
    }
}
