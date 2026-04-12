package ast.types;

import ast.ASTNode;
import ast.Locatable;
import ast.expressions.*;
import ast.statements.Input;

import java.util.List;

// Interfaz `Type`: hereda de ASTNode porque es un nodo más
public interface Type extends ASTNode {

    // Comprueba que puede ser usado en condiciones (if/while)
    void mustBeLogical(Locatable l);

    // Para las operaciones binarias (+|-|*|/)
    Type arithmetic(Type other, Locatable l);

    // Para el UnaryMinus. Solo pueden los NumberType y los IntType
    Type arithmetic(Locatable l);

    // Para las comparaciones >, >=, <, <=, ==, !=
    Type comparison(Type other, Locatable c);

    // Para la invocacion a funciones
    Type parenthesis(List<Type> argumentsTypes, Locatable i);

    // Para ver si los tipos son promocionables
    void mustPromotesTo(Type other, Locatable l);

    // Para el acceso a array
    Type squareBrackets(Type other, Locatable a);

    // Para el cast
    Type canBeCastTo(Type other, Locatable c);

    // Para el acceso a campos
    Type dot(String name, Locatable f);

    void mustBeBuiltIn(Locatable i);
}
