package com.fr0streaper.idetutorial;

public class Sqr extends UnaryExpression {

    public Sqr(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        Double value = arg.evaluate();
        return value * value;
    }
}
