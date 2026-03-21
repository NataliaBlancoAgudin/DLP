package ast.types;

import visitor.Visitor;

public class IntType implements Type {

    private static final IntType INT_TYPE = new IntType();

    private IntType(){}

    public static IntType getInstance(){
        return INT_TYPE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
