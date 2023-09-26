package designpattern.decorator;

/**
 * @author LongyunBian
 * @version 2023/9/25 9:52
 */
public class SortDecorator extends Decorator{
    public SortDecorator(SchoolReport sr) {
        super(sr);
    }
    private void reportSort(){
        System.out.println("排名是。。。");
    }

    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
