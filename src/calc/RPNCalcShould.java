package calc;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;


public class RPNCalcShould {

	private RPNCalc rpn;

	@Before
	public void setUp() {
		rpn = new RPNCalc();
	}

	@Test
	public void testAddTwoNumbers() {
		rpn.push(2);
		rpn.push(4);
		Number top = rpn.operate(Operations.get("+"));
		assertEquals(6, top.doubleValue(), 0.001);
	}

	@Test
	public void testAddThreeNumbers() {
		rpn.push(2);
		rpn.push(4);
		rpn.push(5);
		rpn.operate(Operations.add);
		Number top = rpn.operate(Operations.add);
		assertEquals(11, top.doubleValue(), 0.001);
	}

	@Test(expected=TooFewOperandsException.class)
    public void testAddingTooFewOperands() {
    	rpn.push(2);
    	rpn.operate(Operations.add);
    }
	
	@Test
	public void testMutiplyingAndAddingOperands() {
		rpn.push(5);
		rpn.push(1);
		rpn.push(2);
		rpn.operate(Operations.add);
		rpn.push(4);
		rpn.operate(Operations.multiply);
		rpn.operate(Operations.add);
		rpn.push(3);
		Number top = rpn.operate(Operations.subtract);
		assertEquals(14, top.doubleValue(), 0.001);
	}
	
	@Test
	public void testRPNStackContainsPushedValuesInCorrectOrder() {
		Stack<Number> tmp = new Stack<Number>();
		for (int i = 5 ; i > 0 ; i--) {
			tmp.push(i);
			rpn.push(i);
		}

		Stack<Number> res = rpn.getRPNStack();
		for (int i = 5 ; i > 0 ; i--) {
			assertEquals(tmp.pop(), res.pop());
		}
	}
}
