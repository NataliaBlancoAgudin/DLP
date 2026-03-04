package ast.expressions;

public class RealLiteral extends AbstractExpression {

    double value;

    public RealLiteral(double value, int line, int column) {
        super(line, column);
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
