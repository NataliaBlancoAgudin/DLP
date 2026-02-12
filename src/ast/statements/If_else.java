package ast.statements;

import ast.AbstractLocatable;
import ast.expressions.Expression;

import java.util.List;

public class If_else extends AbstractLocatable implements Statement{

    List<Statement> if_body;
    List<Statement> else_body;
    Expression condition;

    public If_else(List<Statement> if_body, List<Statement> else_body,Expression condition, int line, int column) {
        super(line, column);
        this.if_body = if_body;
        this.else_body = else_body;
        this.condition = condition;
    }

    public List<Statement> getIf_body() {
        return if_body;
    }

    public List<Statement> getElse_body() {
        return else_body;
    }

    public Expression getCondition() {
        return condition;
    }
}
