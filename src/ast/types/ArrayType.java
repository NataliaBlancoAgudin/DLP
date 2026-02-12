package ast.types;

public class ArrayType implements Type {
    int size;
    Type elementType;

    public int getSize() {
        return size;
    }

    public Type getElementType() {
        return elementType;
    }
}
