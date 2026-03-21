package ast.types;

import visitor.Visitor;

public class ArrayType implements Type {
    int size;
    Type elementType;

    public ArrayType(int size, Type elementType){
        this.size = size;
        this.elementType = elementType;
    }

    public int getSize() {
        return size;
    }

    public Type getElementType() {
        return elementType;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
