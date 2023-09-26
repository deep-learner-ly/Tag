package designpattern.decorator;

/**
 * @author LongyunBian
 * @version 2023/9/25 9:50
 */
public class HighScoreDecorator extends Decorator{
    public HighScoreDecorator(SchoolReport sr) {
        super(sr);
    }
    private void reportHighScore(){
        System.out.println("最高成绩：。。。");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
