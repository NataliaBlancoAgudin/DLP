package ast.types;

import ast.AbstractLocatable;
import visitor.Visitor;

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

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
