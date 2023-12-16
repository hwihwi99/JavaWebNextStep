import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculatorTest {
    StringCalculator cal;

    @Before
    public void setup() {
        cal = new StringCalculator();
    }
    @Test(expected = RuntimeException.class)
    public void add() throws Exception{
        cal.add("-1,2,3");
        // assertThrows(RuntimeException,)
    }
}