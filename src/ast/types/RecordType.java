package ast.types;

import visitor.Visitor;

import java.util.List;

public class RecordType implements Type {
    List<RecordField> fieldList;

    public RecordType(List<RecordField> fieldList) {
        this.fieldList = fieldList;
    }

    public List<RecordField> getFieldList() {
        return fieldList;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
