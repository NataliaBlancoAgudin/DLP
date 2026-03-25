package semantic;

import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

public class LValueVisitor extends AbstractVisitor<Void, Void> {
    // Expressions ----------------------------------------------------------------------------------------------
    @Override
    public Void visit(ArithmeticOperation a, Void param) {
        super.visit(a, param);
        a.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ArrayAccess a, Void param) {
        super.visit(a, param);
        a.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(Cast c, Void param) {
        super.visit(c, param);
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(CharLiteral c, Void param) {
        super.visit(c, param);
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(ComparationOperation c, Void param) {
        super.visit(c, param);
        c.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Void param) {
        super.visit(f, param);
        f.setLvalue(true);
        return null;
    }

    @Override
    public Void visit(IntLiteral i, Void param) {
        super.visit(i, param);
        i.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(LogicOperation l, Void param) {
        super.visit(l, param);
        l.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(RealLiteral r, Void param) {
        super.visit(r, param);
        r.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Void param) {
        super.visit(u, param);
        u.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(UnaryNot u, Void param) {
        super.visit(u, param);
        u.setLvalue(false);
        return null;
    }

    @Override
    public Void visit(Variable v, Void param) {
        super.visit(v, param);
        v.setLvalue(true);
        return null;
    }

    // Statements -------------------------------------------------------------------------------------------------
    @Override
    public Void visit(Assigment a, Void param) {
        super.visit(a, param);
        if(!a.getLeft().getLvalue()){
            new ErrorType("El lado izquierdo de la asignación no es direccionable (lvalue)", a.getLeft());
        }
        return null;
    }

    @Override
    public Void visit(Input i, Void param) {
        super.visit(i, param);
        if(!i.getTarget().getLvalue()){
            new ErrorType("La expresión debe ser direccionable (lvalue)", i.getTarget());
        }
        return null;
    }
}
