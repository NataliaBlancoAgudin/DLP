package ast.types;

public class IntType implements Type {

    private static final IntType INT_TYPE = new IntType();

    private IntType(){}

    public static IntType getInstance(){
        return INT_TYPE;
    }
}
