package ast.expressions;

public class UnaryNot extends AbstractExpression {

    Expression operand;

    public UnaryNot(Expression operand, int line, int column) {
        super(line, column);
        this.operand = operand;
    }

    public Expression getOperand() {
        return operand;
    }
}
