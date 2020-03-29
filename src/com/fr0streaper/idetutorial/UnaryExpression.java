package com.fr0streaper.idetutorial;

public abstract class UnaryExpression implements Expression {

    protected final Expression arg;

    public UnaryExpression(Expression arg) {
        this.arg = arg;
    }

    public abstract Double evaluate();

    public abstract String toString();

}