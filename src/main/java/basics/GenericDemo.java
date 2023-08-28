package basics;

/**
 * @author LongyunBian
 * @version 2023/8/19 16:08
 */
public class GenericDemo<T> {
    T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GenericDemo<String> demo = new GenericDemo<>();
        demo.setName("晗晗");
        System.out.println(demo.getName());
    }
}
