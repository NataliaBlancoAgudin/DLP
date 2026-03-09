package ast.types;

import ast.Locatable;

public class ErrorType implements Type {
    private String casuse;
    private Locatable locatable;

    public ErrorType(String cause, Locatable locatable){
        this.casuse = cause;
        this.locatable = locatable;
    }

    public String getCasuse(){
        return this.casuse;
    }

    public Locatable getLocatable(){
        return this.locatable;
    }

    @Override
    public String toString() {
        return "ErrorType {" +
                "casuse='" + casuse + '\'' +
                ", fila=" + locatable.getLine()+
                ", columna= " + locatable.getColumn()+
                '}';
    }
}
