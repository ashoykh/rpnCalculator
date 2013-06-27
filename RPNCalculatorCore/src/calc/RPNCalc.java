package calc;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNCalc {

	Stack<Number> mStack = new Stack<Number>();

	public void push(Number i) {
		mStack.push(i);
	}

	public Number operate(Operations i) throws TooFewOperandsException {
		try {
			Number result = i.operate(mStack.pop(), mStack.pop());

			return mStack.push(result);
		} catch (EmptyStackException e) {
			throw new TooFewOperandsException(e);
		}
	}
	
	public Stack<Number> getRPNStack() {
		return (Stack<Number>)(mStack.clone());
	}
}
