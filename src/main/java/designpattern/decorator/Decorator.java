package designpattern.decorator;

/**
 * @author LongyunBian
 * @version 2023/9/25 9:44
 */
public abstract class Decorator  extends  SchoolReport{ // Decorator
    private final SchoolReport sr;
    public Decorator(SchoolReport sr){
        this.sr = sr;
    }

    @Override
    public void report() {
        sr.report();
    }

    @Override
    public void sign(String name) {
        sr.sign(name);
    }
}
