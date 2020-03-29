package ExpressionTypes;

public abstract class BinaryExpression implements Expression {

    protected final Expression arg1, arg2;

    public BinaryExpression(Expression arg1, Expression arg2) {
        this.arg1 = arg1;
        this.arg2 = arg2;
    }

    public abstract Double evaluate();

    public abstract String toString();

}