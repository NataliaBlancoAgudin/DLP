package semantic;

import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.expressions.*;
import ast.statements.*;
import ast.types.*;
import visitor.AbstractVisitor;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckingVisitor extends AbstractVisitor<Void, Type> {

    @Override
    public Void visit(IntLiteral i, Type param){
        i.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Void visit(CharLiteral c, Type param){
        c.setType(CharType.getInstance());
        return null;
    }

    @Override
    public Void visit(RealLiteral r, Type param){
        r.setType(NumberType.getInstance());
        return null;
    }

    @Override
    public Void visit(Variable v, Type param){
        super.visit(v, param);
        v.setType(v.getDefinition().getType());
        return null;
    }

    @Override
    public Void visit(ArithmeticOperation a, Type param){
        super.visit(a, param);
        a.setType(a.getLeft().getType().arithmetic(a.getRight().getType(), a));
        return null;
    }

    @Override
    public Void visit(While w, Type param){
        super.visit(w, param);
        w.getCondition().getType().mustBeLogical(w);
        return null;
    }

    @Override
    public Void visit(UnaryMinus u, Type param){
        super.visit(u, param);
        u.setType(u.getOperand().getType().arithmetic(u));
        return null;
    }

    @Override
    public Void visit(UnaryNot u, Type param){
        super.visit(u, param);
        u.getOperand().getType().mustBeLogical(u);
        u.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Void visit(LogicOperation l, Type param){
        super.visit(l, param);
        l.getLeft().getType().mustBeLogical(l);
        l.getRight().getType().mustBeLogical(l);
        l.setType(IntType.getInstance());
        return null;
    }

    @Override
    public Void visit(ComparationOperation c, Type param){
        super.visit(c, param);
        c.setType(c.getLeft().getType().comparison(c.getRight().getType(),c));
        return null;
    }

    @Override
    public Void visit(Invocation i, Type param){
        super.visit(i, param);
        List<Type> argumentsTypes = new ArrayList<Type>();
        for(Expression e : i.getArgs()){
            argumentsTypes.add(e.getType());
        }
        i.setType(i.getVariable().getDefinition().getType().parenthesis(argumentsTypes, i));

        return null;
    }

    @Override
    public Void visit(ArrayAccess a, Type param){
        super.visit(a, param);
        a.setType(a.getLeft().getType().squareBrackets(a.getRight().getType(), a));
        return null;
    }

    @Override
    public Void visit(Cast c, Type param){
        super.visit(c, param);
        c.setType(c.getExpression().getType().canBeCastTo(c.getTargetType(), c));
        return null;
    }

    @Override
    public Void visit(FieldAccess f, Type param){
        super.visit(f, param);
        f.setType(f.getExpression().getType().dot(f.getName(), f));
        return null;
    }

    @Override
    public Void visit(If_else i, Type param){
        super.visit(i, param);
        i.getCondition().getType().mustBeLogical(i);
        return null;
    }

    @Override
    public Void visit(Input i, Type param){
        super.visit(i, param);
        i.getTarget().getType().mustBeBuiltIn(i);
        return null;
    }

    @Override
    public Void visit(Log l, Type param){
        super.visit(l, param);
        l.getExpression().getType().mustBeBuiltIn(l);
        return null;
    }

    @Override
    public Void visit(Return r, Type param){
        super.visit(r, param);
        r.getValue().getType().mustPromotesTo(param, r);
        return null;
    }

    @Override
    public Void visit(Assigment a, Type param){
        super.visit(a, param);
        a.getRight().getType().mustPromotesTo(a.getLeft().getType(), a);
        return null;
    }

    @Override
    public Void visit(FuncType f, Type param){
        super.visit(f, param);
        for(VarDefinition v: f.getParams()){
            v.getType().mustBeBuiltIn(v);
        }
        return null;
    }

    @Override
    public Void visit(FunctionDefinition f, Type param){
        // obtengo el tipo de retorno y se lo paso al visitor
        Type returnType = ((FuncType) f.getType()).getReturnType();
        super.visit(f, returnType);
        return null;
    }

}
