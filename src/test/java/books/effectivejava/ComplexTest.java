package books.effectivejava;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexTest {

    @Test
    public void plus() {
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);
        Complex result = c1.plus(c2);
        assertEquals(new Complex(4, 6), result);
    }
}