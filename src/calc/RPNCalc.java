package calc;

import java.util.Stack;

public class RPNCalc {

    enum Operations {
        add("+"), 
        subtract("-"), 
        multiply("*"), 
        devide("/");

        String alt;
        Operations(String alt) { this.alt = alt; }
        public static Operations get(String alt) {
            for (Operations o : values())
                if (o.alt == alt) { return o; }
            return null;
        }
    }

    Stack<Number> mStack = new Stack<Number>();

    public void push(Number i) { mStack.push(i); }
    public Number operate(Operations i) {
        Number n1 = mStack.pop();
        Number n2 = mStack.pop();
        Number result;
        
        if ((n1.doubleValue() == n1.longValue()) && (n2.doubleValue() == n2.longValue())) {
            result = (n1.longValue() + n2.longValue());
        } else {
            result = (n1.doubleValue() + n2.doubleValue());
        }
        return mStack.push(result);
    }
}
