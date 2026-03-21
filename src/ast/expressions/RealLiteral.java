package ast.expressions;

import visitor.Visitor;

public class RealLiteral extends AbstractExpression {

    double value;

    public RealLiteral(double value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
