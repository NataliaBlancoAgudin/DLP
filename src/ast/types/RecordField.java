package ast.types;

import ast.AbstractLocatable;

public class RecordField extends AbstractLocatable {
    Type targetype;
    String name;

    public RecordField(Type targetype, String name, int line, int column) {
        super(line, column);
        this.targetype = targetype;
        this.name = name;
    }

    public Type getTargetype() {
        return targetype;
    }

    public String getName() {
        return name;
    }
}
