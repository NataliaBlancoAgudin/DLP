package ast.expressions;

import ast.Locatable;

public interface Expression extends Locatable {

    void setLvalue(boolean bool);

    boolean getLvalue();
}
