package ast.expressions;

import ast.AbstractLocatable;

public class UnaryMinus extends AbstractExpression {

    Expression operand;

    public UnaryMinus(Expression operand, int line, int column) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }
}
