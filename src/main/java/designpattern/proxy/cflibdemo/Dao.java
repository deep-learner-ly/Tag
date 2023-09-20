package designpattern.proxy.cflibdemo;/**
 * @author LongyunBian
 * @version  2023/9/19 23:57
 */
public class Dao {
    public void update() {
        System.out.println("PeopleDao.update()");
    }

    public void select() {
        System.out.println("PeopleDao.select()");
    }
}
