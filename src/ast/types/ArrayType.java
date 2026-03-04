package ast.types;

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
}
