package ast.types;

import visitor.Visitor;

public class NumberType implements Type {

    private static final NumberType NUMBER_TYPE = new NumberType();

    private NumberType() {}

    public static NumberType getInstance(){
        return NUMBER_TYPE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
