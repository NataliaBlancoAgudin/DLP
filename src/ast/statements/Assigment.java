package ast.statements;

import ast.AbstractLocatable;
import ast.expressions.Expression;

public class Assigment extends AbstractLocatable implements Statement {

    Expression left;
    Expression right;

    public Assigment(Expression left, Expression right, int line, int column) {
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
