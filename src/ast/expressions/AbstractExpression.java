package ast.expressions;

import ast.AbstractLocatable;

public abstract class AbstractExpression extends AbstractLocatable implements Expression {

    private boolean lvalue;

    public AbstractExpression(int line, int column) {
        super(line, column);
    }

    public void setLvalue(boolean lvalue){
        this.lvalue = lvalue;
    }

    public boolean getLvalue(){
        return this.lvalue;
    }
}
