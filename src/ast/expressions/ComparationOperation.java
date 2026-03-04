package ast.expressions;

public class ComparationOperation extends BinaryOperation {

    public ComparationOperation(Expression left, Expression right, String operator, int line, int column) {
        super(left, right, operator, line, column);
    }
}
