package ast.expressions;

public class FieldAccess extends AbstractExpression{

    Expression left;
    Expression right;

    public FieldAccess(Expression left, Expression right, int line, int column) {
        super(line, column);
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
