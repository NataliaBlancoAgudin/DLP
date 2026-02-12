package ast.statements;

import ast.AbstractLocatable;
import ast.expressions.Expression;

public class Return extends AbstractLocatable implements Statement {

    Expression value;

    public Return(Expression value, int line, int column) {
        super(line, column);
        this.value = value;
    }
}
