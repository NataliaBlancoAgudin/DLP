package ast.types;

public class RecordField {
    Type targetype;
    String name;

    public RecordField(Type targetype, String name) {
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
