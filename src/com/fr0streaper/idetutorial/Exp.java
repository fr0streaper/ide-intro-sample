package com.fr0streaper.idetutorial;

public class Exp extends UnaryExpression {

    public Exp(Expression arg) {
        super(arg);
    }

    @Override
    public Double evaluate() {
        return Math.pow(Math.E, arg.evaluate());
    }
}
