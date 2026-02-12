package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;

import java.util.List;

public class FunctionDefintion extends AbstractDefinition{
    List<Statement> statements;

    public FunctionDefintion(String name, Type type, List<Statement> statements, int line, int column) {
        super(name, type, line, column);
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }
}
