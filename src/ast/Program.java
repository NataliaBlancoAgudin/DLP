package ast;

import ast.definitions.Definition;
import visitor.Visitor;

import java.util.List;

public class Program implements ASTNode{

    List<Definition> definitionList;

    public Program(List<Definition> definitionList) {
        this.definitionList = definitionList;
    }

    public List<Definition> getDefinitionList() {
        return definitionList;
    }

    @Override
    public <PT, RT> RT accept(Visitor<PT, RT> v, PT param) {
        return v.visit(this, param);
    }

    // se puede añadir un constructor sin parametros y con un metodo que sea addDefintion
}
