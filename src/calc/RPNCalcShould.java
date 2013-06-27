package calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import calc.RPNCalc.Operations;

public class RPNCalcShould {

    @Before
    public void setUp() {}

    @Test
    public void testAddTwoNumbers() {        
        RPNCalc rpn = new RPNCalc();
        rpn.push(2);
        rpn.push(4);
        Number top = rpn.operate(Operations.get("+"));
        assertEquals(6, top.doubleValue(), 0.001);
    }
    
    @Test
    public void testAddThreeNumbers() {        
        RPNCalc rpn = new RPNCalc();
        rpn.push(2);
        rpn.push(4);
        rpn.push(5);
        rpn.operate(Operations.get("+"));
        Number top = rpn.operate(Operations.get("+"));
        assertEquals(11, top.doubleValue(), 0.001);
    }
    
}
