package ast.expressions;

public class ArithmeticOperation extends BinaryOperation {

    public ArithmeticOperation(Expression left, Expression right, String operator, int line, int column) {
        super(left, right, operator, line, column);
    }
}
