package ast.statements;

import ast.AbstractLocatable;
import ast.expressions.Expression;

import java.util.List;

public class While extends AbstractLocatable implements Statement{

    List<Statement> body;
    Expression condition;

    public While(List<Statement> body,Expression condition, int line, int column) {
        super(line, column);
        this.body = body;
        this.condition = condition;
    }

    public List<Statement> getBody() {
        return body;
    }

    public Expression getCondition() {
        return condition;
    }
}
