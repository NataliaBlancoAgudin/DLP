package ast.expressions;

import ast.statements.Statement;

import java.util.List;

public class Invocation extends AbstractExpression implements Statement, Expression {

    List<Expression> args;
    Variable name;

    public Invocation(List<Expression> args, Variable name, int line, int column) {
        super(line, column);
        this.args = args;
        this.name = name;
    }

    public List<Expression> getArgs() {
        return args;
    }

    public Variable getName() {
        return name;
    }
}
