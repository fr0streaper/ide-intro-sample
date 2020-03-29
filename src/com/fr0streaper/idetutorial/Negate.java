package com.fr0streaper.idetutorial;

public class Negate extends UnaryExpression {

    public Negate(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        return -1 * arg.evaluate();
    }
}
