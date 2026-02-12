package ast.expressions;

import ast.types.Type;

public class Cast extends AbstractExpression{

    Expression expression;
    Type targetType;

    public Cast(Expression expression,Type targetType, int line, int column) {
        super(line, column);
        this.expression = expression;
        this.targetType = targetType;
    }

    public Expression getExpression() {
        return expression;
    }

    public Type getTargetType() {
        return targetType;
    }
}
