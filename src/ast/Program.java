package ast;

import ast.definitions.Definition;

import java.util.List;

public class Program implements ASTNode{

    List<Definition> definitionList;

    public Program(List<Definition> definitionList) {
        this.definitionList = definitionList;
    }

    public List<Definition> getDefinitionList() {
        return definitionList;
    }

    // se puede añadir un constructor sin parametros y con un metodo que sea addDefintion
}
