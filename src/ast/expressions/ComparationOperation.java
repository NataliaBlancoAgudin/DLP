package ast.expressions;

import visitor.Visitor;

public class ComparationOperation extends BinaryOperation {

    public ComparationOperation(Expression left, Expression right, String operator, int line, int column) {
        super(left, right, operator, line, column);
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
