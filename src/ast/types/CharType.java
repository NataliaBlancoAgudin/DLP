package ast.types;

public class CharType implements Type {

    private static final CharType CHAR_TYPE = new CharType();

    private CharType() {}

    public static CharType getInstance(){
        return CHAR_TYPE;
    }
}
