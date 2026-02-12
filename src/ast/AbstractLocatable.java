package ast;

// Clase Abstracta `AbstractLocatable`: Implementa la interfaz `Locatable`
public abstract class AbstractLocatable implements Locatable{
    // Variables de la clase abstracta: se ponen aqui para no tener que
    // repetir las variables en las clases del compilador, sino que al heredar
    // de esta ya las tendrán
    private int line;
    private int column;

    public AbstractLocatable(int line, int column) {
        this.line = line;
        this.column = column;
    }

    @Override
    public int getLine() {
        return line;
    }

    @Override
    public int getColumn() {
        return column;
    }
}
