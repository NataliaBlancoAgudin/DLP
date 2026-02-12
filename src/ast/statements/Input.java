package ast.statements;

import ast.AbstractLocatable;
import ast.expressions.Expression;

public class Input extends AbstractLocatable implements Statement {

    Expression target;

    public Input(Expression target, int line, int column) {
        super(line, column);
        this.target = target;
    }

    public Expression getTarget() {
        return target;
    }
}
