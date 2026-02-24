grammar TSmm;	
// reglas sintácticas ----------------------------------------
program: definition* mainDefinition EOF
       ;

// Expression
expression: '(' expression ')'                                  // Parentesis
           | ID '(' (expression (',' expression)*)? ')'            // Invocation como expresion
           | expression '[' expression ']'                      // ArrayAccess
           | expression '.' ID                                  // Record
           | '(' expression 'as' simple_type ')'                // Cast
           | '-' expression                                     // UnaryMinus
           | '!' expression                                     // UnaryNot
           | expression ('*'|'/' | '%') expression              // Arithmetic
           | expression ('+'|'-') expression                    // Arithmetic
           | expression ('>'|'>='|'<'|'<='|'!='|'==') expression // Comparation
           | expression ('&&'|'||') expression                  // Logic
           | ID                                                 // Variable
           | INT_CONSTANT                                       // IntLiteral
           | REAL_CONSTANT                                      // RealLiteral
           | CHAR_CONSTANT                                      // CharLiteral
           ;

// Statements
statement:  'log' expression (',' expression)* ';'              // Log
          | 'input' expression (',' expression)* ';'            // Input
          | expression '=' expression ';'                       // Assigment
          | 'while' '(' expression ')' body                     // While
          | 'if' '(' expression ')' body ('else' body)?         // If-else
          | ID '(' (expression (',' expression)*)? ')' ';'         // Invocation como statement
          | 'return' expression ';'                             // Return
          ;

// Regla auxiliar para no repetir codigo con el body de if-else y while
body: statement
     | '{' statement* '}'
     ;

// Tipos puede ser tipo simple o tipos compuestos (arrays y records)
type: simple_type
     | '[' INT_CONSTANT ']' type
     | '[' recordField+ ']'
     ;

// Ponemos en distintas reglas el simple y el complex para
// que no podamos hacer cosas como n as [19]int
simple_type: 'int'
            | 'number'
            | 'char'
            ;

// Tipo RecordFiled
recordField: 'let' ID ':' type ';'
            ;

// Definition
definition: varDefinition
           | functionDefinition
           ;

// FunctionDefinition
functionDefinition: 'function' ID '(' params* ')' ':' ('void' | simple_type) '{' bodyFunction '}'
                   ;

// Regla auxiliar para la definicion de funciones
bodyFunction:  varDefinition* statement*
            ;

// Regla auxiliar para la definicion de funciones
params: ID ':' type (',' ID ':' type)*
        ;

// VarDefinition
varDefinition: 'let' ids ';'
             ;

// Regla auxiliar para la definicion de variables
ids: ID (',' ID)* ':' type
       ;

mainDefinition: 'function' 'main' '(' ')' ':' 'void' '{' bodyFunction '}'
               ;

// REGLAS LEXICAS ---------------------------------------

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