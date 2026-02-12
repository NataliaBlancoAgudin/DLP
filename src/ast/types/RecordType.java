package ast.types;

import java.util.List;

public class RecordType implements Type {
    List<RecordField> fieldList;

    public List<RecordField> getFieldList() {
        return fieldList;
    }
}
