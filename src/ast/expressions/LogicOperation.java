package ast.expressions;

public class LogicOperation extends BinaryOperation {

    public LogicOperation(Expression left, Expression right, int line, int column) {
        super(left, right, line, column);
    }
}
