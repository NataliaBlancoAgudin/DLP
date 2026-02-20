// Generated from C:/Users/nati6/OneDrive/Escritorio/Informatica/4 Curso/Segundo Semestre/DLP/DLP-PL/Lab02/AST/src/parser/TSmm.g4 by ANTLR 4.13.2
package parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TSmmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHITES=1, INT_CONSTANT=2, COMMENTS=3, REAL_CONSTANT=4, ID=5, CHAR_CONSTANT=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHITES", "INT_CONSTANT", "COMMENTS", "REAL_CONSTANT", "ID", "CHAR_CONSTANT", 
			"DIGIT", "BASE_DECIMAL", "EXP"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHITES", "INT_CONSTANT", "COMMENTS", "REAL_CONSTANT", "ID", "CHAR_CONSTANT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public TSmmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TSmm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0006t\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0004\u0000\u0015\b\u0000\u000b"+
		"\u0000\f\u0000\u0016\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005"+
		"\u0001\u001d\b\u0001\n\u0001\f\u0001 \t\u0001\u0001\u0001\u0003\u0001"+
		"#\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		")\b\u0002\n\u0002\f\u0002,\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00024\b\u0002\n\u0002\f\u0002"+
		"7\t\u0002\u0003\u00029\b\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0003\u0003?\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003D\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004H\b\u0004\n\u0004\f"+
		"\u0004K\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005[\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007b\b"+
		"\u0007\n\u0007\f\u0007e\t\u0007\u0001\u0007\u0001\u0007\u0004\u0007i\b"+
		"\u0007\u000b\u0007\f\u0007j\u0003\u0007m\b\u0007\u0001\b\u0001\b\u0003"+
		"\bq\b\b\u0001\b\u0001\b\u0001*\u0000\t\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0000\u000f\u0000\u0011\u0000\u0001"+
		"\u0000\t\u0003\u0000\t\n\r\r  \u0001\u000019\u0002\u0000\n\n\r\r\u0003"+
		"\u0000AZ__az\u0004\u000009AZ__az\u0004\u0000bbnnrrtt\u0001\u000009\u0002"+
		"\u0000EEee\u0002\u0000++--\u007f\u0000\u0001\u0001\u0000\u0000\u0000\u0000"+
		"\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000"+
		"\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b"+
		"\u0001\u0000\u0000\u0000\u0001\u0014\u0001\u0000\u0000\u0000\u0003\"\u0001"+
		"\u0000\u0000\u0000\u00058\u0001\u0000\u0000\u0000\u0007C\u0001\u0000\u0000"+
		"\u0000\tE\u0001\u0000\u0000\u0000\u000bZ\u0001\u0000\u0000\u0000\r\\\u0001"+
		"\u0000\u0000\u0000\u000fl\u0001\u0000\u0000\u0000\u0011n\u0001\u0000\u0000"+
		"\u0000\u0013\u0015\u0007\u0000\u0000\u0000\u0014\u0013\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000"+
		"\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000"+
		"\u0000\u0018\u0019\u0006\u0000\u0000\u0000\u0019\u0002\u0001\u0000\u0000"+
		"\u0000\u001a\u001e\u0007\u0001\u0000\u0000\u001b\u001d\u0003\r\u0006\u0000"+
		"\u001c\u001b\u0001\u0000\u0000\u0000\u001d \u0001\u0000\u0000\u0000\u001e"+
		"\u001c\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f"+
		"#\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000!#\u00050\u0000"+
		"\u0000\"\u001a\u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0004"+
		"\u0001\u0000\u0000\u0000$%\u0005/\u0000\u0000%&\u0005*\u0000\u0000&*\u0001"+
		"\u0000\u0000\u0000\')\t\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000)"+
		",\u0001\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000"+
		"\u0000+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0005*\u0000"+
		"\u0000.9\u0005/\u0000\u0000/0\u0005/\u0000\u000001\u0005/\u0000\u0000"+
		"15\u0001\u0000\u0000\u000024\b\u0002\u0000\u000032\u0001\u0000\u0000\u0000"+
		"47\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000069\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008$\u0001\u0000"+
		"\u0000\u00008/\u0001\u0000\u0000\u00009:\u0001\u0000\u0000\u0000:;\u0006"+
		"\u0002\u0000\u0000;\u0006\u0001\u0000\u0000\u0000<>\u0003\u000f\u0007"+
		"\u0000=?\u0003\u0011\b\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000"+
		"\u0000?D\u0001\u0000\u0000\u0000@A\u0003\u0003\u0001\u0000AB\u0003\u0011"+
		"\b\u0000BD\u0001\u0000\u0000\u0000C<\u0001\u0000\u0000\u0000C@\u0001\u0000"+
		"\u0000\u0000D\b\u0001\u0000\u0000\u0000EI\u0007\u0003\u0000\u0000FH\u0007"+
		"\u0004\u0000\u0000GF\u0001\u0000\u0000\u0000HK\u0001\u0000\u0000\u0000"+
		"IG\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000J\n\u0001\u0000\u0000"+
		"\u0000KI\u0001\u0000\u0000\u0000LM\u0005\'\u0000\u0000MN\t\u0000\u0000"+
		"\u0000N[\u0005\'\u0000\u0000OP\u0005\'\u0000\u0000PQ\u0005\\\u0000\u0000"+
		"QR\u0001\u0000\u0000\u0000RS\u0007\u0005\u0000\u0000S[\u0005\'\u0000\u0000"+
		"TU\u0005\'\u0000\u0000UV\u0005\\\u0000\u0000VW\u0001\u0000\u0000\u0000"+
		"WX\u0003\u0003\u0001\u0000XY\u0005\'\u0000\u0000Y[\u0001\u0000\u0000\u0000"+
		"ZL\u0001\u0000\u0000\u0000ZO\u0001\u0000\u0000\u0000ZT\u0001\u0000\u0000"+
		"\u0000[\f\u0001\u0000\u0000\u0000\\]\u0007\u0006\u0000\u0000]\u000e\u0001"+
		"\u0000\u0000\u0000^_\u0003\u0003\u0001\u0000_c\u0005.\u0000\u0000`b\u0003"+
		"\r\u0006\u0000a`\u0001\u0000\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001"+
		"\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000dm\u0001\u0000\u0000\u0000"+
		"ec\u0001\u0000\u0000\u0000fh\u0005.\u0000\u0000gi\u0003\r\u0006\u0000"+
		"hg\u0001\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000"+
		"\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000l^\u0001\u0000"+
		"\u0000\u0000lf\u0001\u0000\u0000\u0000m\u0010\u0001\u0000\u0000\u0000"+
		"np\u0007\u0007\u0000\u0000oq\u0007\b\u0000\u0000po\u0001\u0000\u0000\u0000"+
		"pq\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0003\u0003\u0001"+
		"\u0000s\u0012\u0001\u0000\u0000\u0000\u000f\u0000\u0016\u001e\"*58>CI"+
		"Zcjlp\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}