package ast.expressions;

public class FieldAccess extends AbstractExpression{

    Expression expression;
    String name;

    public FieldAccess(Expression expression, String name, int line, int column) {
        super(line, column);
        this.expression = expression;
        this.name = name;
    }

    public Expression getExpression() {
        return expression;
    }

    public String getName() {
        return name;
    }
}
