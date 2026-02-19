package ast.definitions;

import ast.statements.Statement;
import ast.types.Type;

public class VarDefinition extends AbstractDefinition implements Statement {

    public VarDefinition(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }
}
