package designpattern.singleton;

/**
 * @author LongyunBian
 * @version 2023/8/21 14:34
 */
public class InnerStaticClass {
    private InnerStaticClass() {
        // 私有构造函数，防止外部实例化
    }

    private static class Holder{
        private static final InnerStaticClass INSTANCE = new InnerStaticClass();
    }
    public static InnerStaticClass getInstance(){
        return Holder.INSTANCE;
    }
}
