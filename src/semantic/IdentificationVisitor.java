package semantic;

import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.Variable;
import ast.types.ErrorType;
import symboltable.SymbolTable;
import visitor.AbstractVisitor;

public class IdentificationVisitor extends AbstractVisitor<Void, Void> {
    private final SymbolTable symbolTable = new SymbolTable();
    // Definitions ---------------------------------------------------------------------------------------------
    @Override
    public Void visit(FunctionDefinition f, Void param) {
        if(!symbolTable.insert(f)){
            new ErrorType("Ya existe una función con el nombre " + f.getName() + " en el ambito", f);
        }
        symbolTable.set();
        super.visit(f, param);
        symbolTable.reset();
        return null;
    }

    @Override
    public Void visit(VarDefinition v, Void param) {
        if(!symbolTable.insert(v)){
            new ErrorType("Ya existe una variable con el nombre " + v.getName() + " en el ambito", v);
        }
        super.visit(v, param);
        return null;
    }

    // Expressions ----------------------------------------------------------------------------------------------
    @Override
    public Void visit(Variable v, Void param) {
        Definition def = symbolTable.find(v.getName());
        if(def != null){
            v.setDefinition(def);
        }
        else{
            ErrorType type = new ErrorType("No existe una variable con el nombre " + v.getName(), v);
            v.setDefinition(new VarDefinition("", type, 0,0));
        }
        super.visit(v, param);
        return null;
    }
}
