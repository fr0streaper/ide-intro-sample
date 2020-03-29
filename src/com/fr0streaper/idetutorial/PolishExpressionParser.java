package com.fr0streaper.idetutorial;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class PolishExpressionParser {

    public static final Map<String, Class<? extends Expression>> binaryExpressions = Map.ofEntries(
                                                                    Map.entry("+", Add.class),
                                                                    Map.entry("-", Subtract.class),
                                                                    Map.entry("*", Multiply.class),
                                                                    Map.entry("/", Divide.class),
                                                                    Map.entry("log", Log.class),
                                                                    Map.entry("^", Power.class));

    public static final Map<String, Class<? extends Expression>> unaryExpressions = Map.ofEntries(
                                                                    Map.entry("neg", Negate.class),
                                                                    Map.entry("sqrt", Sqrt.class),
                                                                    Map.entry("sqr", Sqr.class),
                                                                    Map.entry("exp", Exp.class),
                                                                    Map.entry("ln", Ln.class));

    public Expression parse(String expr) throws IllegalArgumentException {
        if (expr == null) {
            throw new IllegalArgumentException("The expression must not be null");
        }

        List<String> args = Arrays.asList(expr.split(" "));

        Stack<Expression> expression = new Stack<>();
        for (String arg : args) {
            if (binaryExpressions.containsKey(arg)) {
                if (expression.size() < 2) {
                    throw new IllegalArgumentException("Insufficient arguments for operation " + arg + "; Expected: 2, found: " + expression.size());
                }

                Expression arg2 = expression.pop();
                Expression arg1 = expression.pop();

                try {
                    expression.push(binaryExpressions.get(arg).getConstructor(Expression.class, Expression.class).newInstance(arg1, arg2));
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    throw new IllegalArgumentException("Invalid operation argument: " + arg, e);
                }
            }
            else if (unaryExpressions.containsKey(arg)) {
                if (expression.size() < 1) {
                    throw new IllegalArgumentException("Insufficient arguments for operation " + arg + "; Expected: 1, found: " + expression.size());
                }

                Expression arg1 = expression.pop();

                try {
                    expression.push(unaryExpressions.get(arg).getConstructor(Expression.class).newInstance(arg1));
                } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                    throw new IllegalArgumentException("Invalid operation argument: " + arg, e);
                }
            }
            else {
                try {
                    expression.push(new Constant(Double.parseDouble(arg)));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid number argument: " + arg, e);
                }
            }
        }

        if (expression.size() != 1) {
            throw new IllegalArgumentException("Invalid expression given; Couldn't reduce to a single number");
        }

        return expression.pop();
    }

}