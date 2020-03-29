package com.fr0streaper.idetutorial;

public class Sqrt extends UnaryExpression {

    public Sqrt(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        return Math.sqrt(arg.evaluate());
    }
}
