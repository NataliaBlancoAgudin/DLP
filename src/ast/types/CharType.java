package ast.types;

import visitor.Visitor;

public class CharType implements Type {

    private static final CharType CHAR_TYPE = new CharType();

    private CharType() {}

    public static CharType getInstance(){
        return CHAR_TYPE;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }
}
