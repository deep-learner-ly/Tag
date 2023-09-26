package designpattern.decorator;

/**
 * @author LongyunBian
 * @version 2023/9/25 9:53
 */
public class Father {
    public static void main(String[] args) {
        SchoolReport sr = new FourthGradeSchoolReport();
        sr= new SortDecorator(sr);
        sr = new HighScoreDecorator(sr);

        sr.report();
        sr.sign("老三");
    }
}
