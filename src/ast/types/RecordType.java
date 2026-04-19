package ast.types;

import ast.Locatable;
import visitor.Visitor;

import java.util.List;

public class RecordType extends AbstractType {
    List<RecordField> fieldList;

    public RecordType(List<RecordField> fieldList) {
        this.fieldList = fieldList;
    }

    public List<RecordField> getFieldList() {
        return fieldList;
    }

    @Override
    public <RT, PT> RT accept(Visitor<RT, PT> v, PT param){
        return v.visit(this, param);
    }

    @Override
    public int numberOfBytes() {
        int number = 0;
        for(RecordField field : fieldList){
            number+=field.getTargetype().numberOfBytes();
        }
        return number;
    }

    @Override
    public Type dot(String name, Locatable l){
        for(RecordField field : fieldList){
            if(field.getName().equals(name)){
                return field.getTargetype();
            }
        }
        return new ErrorType("El Record no tiene ningún campo con el nombre: " + name, l);
    }
}
