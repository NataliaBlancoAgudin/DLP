package ast.types;

public class VoidType implements Type {

    private static final VoidType VOID_TYPE = new VoidType();

    private VoidType() {}

    public static VoidType getInstance(){
        return VOID_TYPE;
    }
}
