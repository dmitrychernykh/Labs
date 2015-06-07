import static org.junit.Assert.assertTrue;

public class SinusSumTest {

    @org.junit.Test
    public void testCalculateSinus() throws Exception {
        assertTrue("sin() error: ", SinusSum.calculateSinus(90) == 1);
        assertTrue("sin() error: ", SinusSum.calculateSinus(-90) == -1);
        assertTrue("sin() error: ", SinusSum.calculateSinus(180) == 0);
        assertTrue("sin() error: ", SinusSum.calculateSinus(0) == 0);
    }
}