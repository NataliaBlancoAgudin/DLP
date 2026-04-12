package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;
import visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class FunctionDefinition extends AbstractDefinition{
    List<Statement> statements;

    public FunctionDefinition(String name, Type type, List<Statement> statements, int line, int column) {
        super(name, type, line, column);
        this.statements = new ArrayList<>(statements);
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param) {
        return v.visit(this, param);
    }
}
