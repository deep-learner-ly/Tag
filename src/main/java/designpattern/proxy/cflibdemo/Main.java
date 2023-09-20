package designpattern.proxy.cflibdemo;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author LongyunBian
 * @version 2023/9/20 0:03
 */
public class Main {
    public static void main(String[] args) {
        DaoProxy daoProxy = new DaoProxy();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Dao.class);
        enhancer.setCallback(daoProxy);

        Dao dao = (Dao)enhancer.create();
        dao.update();
        dao.select();
    }
}
