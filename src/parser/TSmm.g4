grammar TSmm;	

program:
       ;


//
// Patrón espacios en blanco
WHITES: [ \n\t\r]+ -> skip
      ;

// Patrón numeros enteros
INT_CONSTANT: [1-9]DIGIT*
            | '0'
            ;

// Patrón para los comentario de una sola linea y dos
COMMENTS: ('/*' .*? '*/'
         | '//' ~[\r\n]*)
         -> skip
         ;

// Patrón para los números reales
REAL_CONSTANT: BASE_DECIMAL EXP?
             | INT_CONSTANT EXP
            ;

// Patrón para los identificadores
ID: [a-zA-Z_][a-zA-Z0-9_]*
    ;

// Patrón para los characteres
CHAR_CONSTANT: '\'' . '\''
              | '\'\\' ('n'|'r'|'t'|'b') '\''
              | '\'\\' INT_CONSTANT '\''
            ;

// Framgentos
// Fragmento para los digitos
fragment
DIGIT: [0-9]
        ;
// Fragmento para la base decimal
fragment
BASE_DECIMAL: INT_CONSTANT '.' DIGIT*
    | '.' DIGIT+
    ;

// Fragmento para el exponente
fragment
EXP:[Ee] [+-]? INT_CONSTANT
    ;