package ast.types;

import ast.Locatable;
import java.util.List;

public abstract class AbstractType implements Type {
    // Por defecto devuelvo el caracter nulo
    @Override
    public char suffix() {
        return '\0';
    }

    @Override
    public int numberOfBytes() {
        // Esto es para los tipo Void, Error, Func
        throw new UnsupportedOperationException("La definción de una variable no puede ser de tipo " + this);
    }

    @Override
    public void mustBeLogical(Locatable l){
        new ErrorType("No se puede usar este tipo como condición", l);
    }

    @Override
    public void mustPromotesTo(Type type, Locatable l){
        if(type instanceof ErrorType){
            return;
        }
        new ErrorType("No se puede promocionar el tipo " + this + " a " + type, l);
    }

    @Override
    public Type arithmetic(Type t, Locatable l){
        if(t instanceof ErrorType){
            return t;
        }
        return new ErrorType("Operación aritmética no soportada entre " + this + " y " + t.toString(), l);
    }

    @Override
    public Type arithmetic(Locatable l){
        return new ErrorType("Operación Unaria no soportada para " + this, l);
    }

    @Override
    public Type comparison(Type t, Locatable l){
        if(t instanceof ErrorType){
            return t;
        }
        return new ErrorType("Operación de comparación no soportada para " + this + " y " + t.toString(), l);
    }

    @Override
    public Type parenthesis(List<Type> e, Locatable l){
        StringBuilder params = new StringBuilder();
        for(Type t: e){
            if(t instanceof ErrorType){
                return t;
            }
            else{
                params.append(t.toString()).append(", ");
            }
        }
        if(!params.isEmpty()){
            params.setLength(params.length()-2);
        }
        else{
            params.append("No parameters");
        }
        return new ErrorType("La invocacion esperaba diferentes arguments.", l);
    }

    @Override
    public Type squareBrackets(Type other, Locatable l){
        if(other instanceof ErrorType){
            return other;
        }
        return new ErrorType("No se puede indexar el tipo " + this, l);
    }

    @Override
    public Type canBeCastTo(Type other, Locatable c){
        if(other instanceof ErrorType){
            return other;
        }
        return new ErrorType("No se puede castear el tipo " + this + " a " + other.toString(), c);
    }

    @Override
    public Type dot(String name, Locatable l) {
        return new ErrorType("El tipo " + this + " no soporta el operador '.'", l);
    }

    @Override
    public void mustBeBuiltIn(Locatable l) {
        new ErrorType("Se esperaba un tipo primitivo, pero es " + this, l);
    }
}
