package designpattern.decorator;

/**
 * @author LongyunBian
 * @version 2023/9/25 9:42
 */
public class FourthGradeSchoolReport extends SchoolReport { // ConcreteComponent
    @Override
    public void report() {
        System.out.println("成绩单");
    }

    @Override
    public void sign(String name) {
        System.out.println("家长签名"+name);
    }
}
