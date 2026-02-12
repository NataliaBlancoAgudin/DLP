package ast.expressions;

public class ComparationOperation extends BinaryOperation {

    public ComparationOperation(Expression left, Expression right, int line, int column) {
        super(left, right, line, column);
    }
}
