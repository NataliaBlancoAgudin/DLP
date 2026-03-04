package ast.expressions;

public class LogicOperation extends BinaryOperation {

    public LogicOperation(Expression left, Expression right, String operator, int line, int column) {
        super(left, right, operator, line, column);
    }
}
