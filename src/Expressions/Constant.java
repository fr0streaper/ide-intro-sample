package Expressions;

import ExpressionTypes.Expression;

public class Constant implements Expression {

    private final Double value;

    public Constant(Double value) {
        this.value = value;
    }

    public Double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}