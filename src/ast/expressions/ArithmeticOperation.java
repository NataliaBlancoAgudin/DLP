package ast.expressions;

public class ArithmeticOperation extends BinaryOperation {

    public ArithmeticOperation(Expression left, Expression right, int line, int column) {
        super(left, right, line, column);
    }
}
