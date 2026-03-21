package ast.expressions;

import visitor.Visitor;

public class ArrayAccess extends AbstractExpression{

    Expression left;
    Expression right;

    public ArrayAccess(Expression left, Expression right, int line, int column) {
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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
