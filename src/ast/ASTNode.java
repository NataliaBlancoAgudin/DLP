package ast;

import visitor.Visitor;

// Interfaz `ASTNode`
public interface ASTNode {
    <PT, RT> RT accept(Visitor<PT,RT> v, PT param);
}
