package ast.types;

import ast.definitions.VarDefinition;

import java.util.List;

public class FuncType implements Type {
    // Atributo de la clase `FuncType`: tiene que guardar
    // un `Type` de retorno y una lista de `VarDefintion`
    Type returnType;
    List<VarDefinition> params;

    public FuncType(Type returnType, List<VarDefinition> params) {
        this.returnType = returnType;
        this.params = params;
    }

    public Type getReturnType() {
        return returnType;
    }

    public List<VarDefinition> getParams() {
        return params;
    }
}
