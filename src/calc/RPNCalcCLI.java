package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RPNCalcCLI {
    public static void main(String[] args) throws IOException {
        RPNCalc rpn = new RPNCalc();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));  
        String input = "";  
        while ((input = stdin.readLine()) != null) {
            try {
                rpn.push(Double.parseDouble(input));
            } catch (NumberFormatException e) {
                Operations o = Operations.get(input.trim());
                if (o != null) {
                    Number res = rpn.operate(o);
                    System.out.println(res);
                } else { System.out.println("\nunrecognized line " +input); }
            }
        }
    }
}
