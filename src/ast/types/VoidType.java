package ast.types;

import visitor.Visitor;

public class VoidType implements Type {

    private static final VoidType VOID_TYPE = new VoidType();

    private VoidType() {}

    public static VoidType getInstance(){
        return VOID_TYPE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
