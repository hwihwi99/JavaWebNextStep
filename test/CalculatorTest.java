import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator cal;

    @Before
    public void setup() {
        cal = new Calculator();
        System.out.println("before test");
    }

    @Test // @Test 1개 == 단위테스트 1개
    public void add() {
        Calculator cal = new Calculator();
        /**
         * assertEquals
         * @params
         * 1. expected value
         * 2. actual value
         * 다양한 data tyoe 지원됨
         * */
        assertEquals(8, cal.add(3,5));
        System.out.println("add test");
    }

    @Test
    public void subtract() {
        Calculator cal = new Calculator();
        assertEquals(5, cal.subtract(9,4));
        System.out.println("subtract test");
    }

    @After
    public void afterTest() {
        System.out.println("after test");
    }
}