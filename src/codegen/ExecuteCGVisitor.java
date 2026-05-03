package codegen;

import ast.Program;
import ast.definitions.Definition;
import ast.definitions.FunctionDefinition;
import ast.definitions.VarDefinition;
import ast.statements.*;
import ast.types.FuncType;
import ast.types.IntType;

import java.util.ArrayList;
import java.util.List;

public class ExecuteCGVisitor extends AbstractCGVisitor<Void, Void> {

    private AddressCGVisitor addressCGVisitor;
    private ValueCGVisitor valueCGVisitor;

    public ExecuteCGVisitor(CodeGenerator codeGenerator) {
        super(codeGenerator);

        this.addressCGVisitor = new AddressCGVisitor(codeGenerator);
        this.valueCGVisitor = new ValueCGVisitor(codeGenerator);
        this.addressCGVisitor.setValueCGVisitor(valueCGVisitor);
        this.valueCGVisitor.setAddressCGVisitor(addressCGVisitor);
    }

    /**
     *execute[[Assigment: stmt -> expr1 expr2]]()=
     *         address[[expr1]]()
     *         value[[expr2]]()
     *         cg.convertTo(expr2.type, expr1.type)
     *         <store> expr1.type.suffix()
     */
    @Override
    public Void visit(Assigment a, Void param){
        getCodeGenerator().commentLine(a.getLine());
        getCodeGenerator().comment("Assignment");

        a.getLeft().accept(addressCGVisitor, null);
        a.getRight().accept(valueCGVisitor, null);
        getCodeGenerator().convertTo(a.getRight().getType(), a.getLeft().getType());
        getCodeGenerator().store(a.getLeft().getType());
        return null;
    }

    /**
     * execute[[Input: stmt1 -> expr]]()=
     *         <#line> expr.line
     *         < ' * Read>
     *         address[[expr]]()
     *         <in> expr.type.suffix
     *         <store> expr.type.suffix
     */
    @Override
    public Void visit(Input i, Void param){
        getCodeGenerator().commentLine(i.getLine());
        getCodeGenerator().comment("Read");
        i.getTarget().accept(addressCGVisitor, null);
        getCodeGenerator().in(i.getTarget().getType());
        getCodeGenerator().store(i.getTarget().getType());
        return null;
    }

    /**
     * execute[[Log: stmt -> expr]]()=
     *         <#line> expr.line
     *         < ' * Write>
     *         value[[expr]]
     *         <out> expr.type.suffix
     */
    @Override
    public Void visit(Log l, Void param){
        getCodeGenerator().commentLine(l.getLine());
        getCodeGenerator().comment("Write");
        l.getExpression().accept(valueCGVisitor, null);
        getCodeGenerator().output(l.getExpression().getType());
        return null;
    }

    /**
     *ID <:>
     *         < ' * Parameters: >
     *         for(VarDefinition v: type.params){
     *             exectue[[v]]();
     *         }
     *         < ' * Local Variables: >
     *         for(Statements st: stmt*){
     *             if(st instanceof VarDefinition){
     *                  execute[[st]]();
     *                 definitions*.add(st);
     *             }
     *         }
     *         if(definitions*.isEmpty()){
     *             defintion.bytesLocalSum = 0;
     *         }
     *         else {
     *             VarDefinition ultimaVardefintion = definition*.get(definition*.size()-1)
     *             definition.bytesLocalSum = -1 * ultimaVardefinition.offset
     *         }
     *
     *         <enter> definitions.bytesLocalSum
     *         for(Statements st:stmt*){
     *             if(!(st instaceof VarDefinition)){
     *                 execute[[st]]
     *             }
     *         }
     *         <ret> 0, definitions.bytesLocalSum, 0
     */
    @Override
    public Void visit(FunctionDefinition f, Void param){
        getCodeGenerator().commentLine(f.getLine());
        getCodeGenerator().printFunction(f.getName());
        getCodeGenerator().comment("Parameters:");

        for(VarDefinition def: ((FuncType) f.getType()).getParams()){
            def.accept(this, null);
        }

        getCodeGenerator().comment("Local Variables:");
        List<VarDefinition> definitionList = new ArrayList<>();
        for(Statement st: f.getStatements()){
            if(st instanceof VarDefinition){
                st.accept(this, null);
                definitionList.add((VarDefinition) st);
            }
        }

        if(definitionList.isEmpty()){
            f.setBytesLocalSum(0);
        }
        else {
            VarDefinition ultimaDef = definitionList.get(definitionList.size() - 1);
            f.setBytesLocalSum(-1 * ultimaDef.getOffset());
        }

        getCodeGenerator().enter(f.getBytesLocalSum());
        for(Statement st: f.getStatements()){
            if(!(st instanceof VarDefinition)){
                st.accept(this, null);
            }
        }

        getCodeGenerator().ret(0, f.getBytesLocalSum(), 0);
        return null;
    }

    /**
     * VarDefinition
     *     execute[[VarDefinition: definition -> type ID]](){
     *         < ' * > type ID <(offset > definition.offset <)>
     *     }
     */
    @Override
    public Void visit(VarDefinition v, Void param){
        getCodeGenerator().comment(v.getType() + " " + v.getName() + "(offset " + v.getOffset() + ")");
        return null;
    }

    /**
     *
     * execute[[While: stmt1 -> expr stmt2*]]()=
     *         String cond = cg.getLabel()
     *         String end = cg.getLabel()
     *         cond <:>
     *         value[[expr]]()
     *         cg.convertTo(expr.type, IntType.instance)
     *         <jz> end
     *         stmt2*.forEach(s -> execute[[s]]())
     *         <jmp> cond
     *         end <:>
     */
    @Override
    public Void visit(While w, Void param){
        getCodeGenerator().commentLine(w.getLine());
        getCodeGenerator().comment("While");

        String cond = getCodeGenerator().getLabel();
        String end = getCodeGenerator().getLabel();
        getCodeGenerator().insertLabel(cond);
        w.getCondition().accept(valueCGVisitor, null);
        getCodeGenerator().convertTo(w.getCondition().getType(), IntType.getInstance());
        getCodeGenerator().jz(end);
        for(Statement st: w.getBody()){
            getCodeGenerator().comment("While body");
            st.accept(this, null);
        }
        getCodeGenerator().jmp(cond);
        getCodeGenerator().insertLabel(end);
        return null;
    }

    /**
     * execute[[If_else: stmt1 -> expr stmt2* stmt3*]]()=
     *         String else = cg.getLabel()
     *         String end = cg.getLabel()
     *         value[[expr]]()
     *         cg.convertTo(expr.type, IntType.instance)
     *         <jz> else
     *         stmt2*.forEach(s -> execute[[s]]())
     *         <jmp> end
     *         else <:>
     *         stmt3*.forEach(s -> execute[[s]]())
     *         end <:>
     */
    @Override
    public Void visit(If_else i, Void param){
        getCodeGenerator().commentLine(i.getLine());
        getCodeGenerator().comment("If");

        String elseC = getCodeGenerator().getLabel();
        String end = getCodeGenerator().getLabel();
        i.getCondition().accept(valueCGVisitor, null);
        getCodeGenerator().convertTo(i.getCondition().getType(), IntType.getInstance());
        getCodeGenerator().jz(elseC);
        for(Statement st : i.getIf_body()){
            st.accept(this, null);
        }
        getCodeGenerator().jmp(end);
        getCodeGenerator().insertLabel(elseC);
        for(Statement st : i.getElse_body()){
            st.accept(this, null);
        }
        getCodeGenerator().insertLabel(end);
        return null;
    }

    /**
     * execute[[Program: program -> def*]]()=
     *         for(Defintion d:def*){
     *             if(d instanceof VarDefinition){
     *                 execute[[d]]()
     *             }
     *         }
     *         <' Invocation to the main function>
     *         <call main>
     *         <halt>
     *
     *         for(Definition d:def*){
     *             if(d instanceof FuncDefinition){
     *                 execute[[d]]()
     *             }
     *         }
     */
    @Override
    public Void visit(Program p, Void param){
        for(Definition def: p.getDefinitionList()){
            if(def instanceof VarDefinition){
                def.accept(this, null);
            }
        }

        getCodeGenerator().mainInvocation();
        getCodeGenerator().halt();

        for(Definition def: p.getDefinitionList()){
            if(def instanceof FunctionDefinition){
                def.accept(this, null);
            }
        }
        return null;
    }
}
