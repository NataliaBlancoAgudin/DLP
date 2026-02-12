package ast.definitions;

import ast.AbstractLocatable;
import ast.statements.Statement;
import ast.types.Type;

public class VarDefinition extends AbstractLocatable implements Statement {

    public VarDefinition(String name, Type type, int line, int column) {
        super(name, type, line, column);
    }
}
