package com.fr0streaper.idetutorial;

import java.util.*;

public class PolishExpressionParser {

    public static final List<String> binaryOperations = Arrays.asList( "+", "-", "*", "/" );

    public Expression parse(String expr) throws IllegalArgumentException {
        if (expr == null) {
            throw new IllegalArgumentException("The expression must not be null");
        }

        List<String> args = Arrays.asList(expr.split(" "));

        Stack<Expression> expression = new Stack<Expression>();
        for (String arg : args) {
            if (binaryOperations.contains(arg)) {
                if (expression.size() < 2) {
                    throw new IllegalArgumentException("Insufficient arguments for operation " + arg + "; Expected: 2, found: " + expression.size());
                }



                Expression arg2 = expression.pop();
                Expression arg1 = expression.pop();

                if (arg.equals("+")) {
                    expression.push(new Add(arg1, arg2));
                }
                else if (arg.equals("-")) {
                    expression.push(new Subtract(arg1, arg2));
                }
                else if (arg.equals("*")) {
                    expression.push(new Multiply(arg1, arg2));
                }
                else if (arg.equals("/")) {
                    expression.push(new Divide(arg1, arg2));
                }
            }
            else {
                try {
                    expression.push(new Constant(Double.parseDouble(arg)));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid numbeer argument: " + arg, e);
                }
            }
        }

        if (expression.size() != 1) {
            throw new IllegalArgumentException("Invalid expression given; Couldn't reduce to a single number");
        }

        return expression.pop();
    }

}