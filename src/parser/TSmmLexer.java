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
		"\u0004\u0000\u0006u\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0001\u0000\u0004\u0000\u0015\b\u0000\u000b"+
		"\u0000\f\u0000\u0016\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005"+
		"\u0001\u001d\b\u0001\n\u0001\f\u0001 \t\u0001\u0001\u0001\u0003\u0001"+
		"#\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		")\b\u0002\n\u0002\f\u0002,\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u00024\b\u0002\n\u0002\f\u0002"+
		"7\t\u0002\u0001\u0002\u0003\u0002:\b\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0003\u0003@\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003E\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004I\b\u0004"+
		"\n\u0004\f\u0004L\t\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\\\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"c\b\u0007\n\u0007\f\u0007f\t\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"j\b\u0007\u000b\u0007\f\u0007k\u0003\u0007n\b\u0007\u0001\b\u0001\b\u0003"+
		"\br\b\b\u0001\b\u0001\b\u0002*5\u0000\t\u0001\u0001\u0003\u0002\u0005"+
		"\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0000\u000f\u0000\u0011\u0000"+
		"\u0001\u0000\b\u0003\u0000\t\n\r\r  \u0001\u000019\u0003\u0000AZ__az\u0004"+
		"\u000009AZ__az\u0004\u0000bbnnrrtt\u0001\u000009\u0002\u0000EEee\u0002"+
		"\u0000++--\u0080\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0001\u0014\u0001\u0000\u0000\u0000\u0003\"\u0001\u0000\u0000"+
		"\u0000\u00059\u0001\u0000\u0000\u0000\u0007D\u0001\u0000\u0000\u0000\t"+
		"F\u0001\u0000\u0000\u0000\u000b[\u0001\u0000\u0000\u0000\r]\u0001\u0000"+
		"\u0000\u0000\u000fm\u0001\u0000\u0000\u0000\u0011o\u0001\u0000\u0000\u0000"+
		"\u0013\u0015\u0007\u0000\u0000\u0000\u0014\u0013\u0001\u0000\u0000\u0000"+
		"\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0014\u0001\u0000\u0000\u0000"+
		"\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000"+
		"\u0018\u0019\u0006\u0000\u0000\u0000\u0019\u0002\u0001\u0000\u0000\u0000"+
		"\u001a\u001e\u0007\u0001\u0000\u0000\u001b\u001d\u0003\r\u0006\u0000\u001c"+
		"\u001b\u0001\u0000\u0000\u0000\u001d \u0001\u0000\u0000\u0000\u001e\u001c"+
		"\u0001\u0000\u0000\u0000\u001e\u001f\u0001\u0000\u0000\u0000\u001f#\u0001"+
		"\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000!#\u00050\u0000\u0000"+
		"\"\u001a\u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0004\u0001"+
		"\u0000\u0000\u0000$%\u0005/\u0000\u0000%&\u0005*\u0000\u0000&*\u0001\u0000"+
		"\u0000\u0000\')\t\u0000\u0000\u0000(\'\u0001\u0000\u0000\u0000),\u0001"+
		"\u0000\u0000\u0000*+\u0001\u0000\u0000\u0000*(\u0001\u0000\u0000\u0000"+
		"+-\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000-.\u0005*\u0000\u0000"+
		".:\u0005/\u0000\u0000/0\u0005/\u0000\u000001\u0005/\u0000\u000015\u0001"+
		"\u0000\u0000\u000024\t\u0000\u0000\u000032\u0001\u0000\u0000\u000047\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u0000"+
		"68\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u00008:\u0005\n\u0000\u0000"+
		"9$\u0001\u0000\u0000\u00009/\u0001\u0000\u0000\u0000:;\u0001\u0000\u0000"+
		"\u0000;<\u0006\u0002\u0000\u0000<\u0006\u0001\u0000\u0000\u0000=?\u0003"+
		"\u000f\u0007\u0000>@\u0003\u0011\b\u0000?>\u0001\u0000\u0000\u0000?@\u0001"+
		"\u0000\u0000\u0000@E\u0001\u0000\u0000\u0000AB\u0003\u0003\u0001\u0000"+
		"BC\u0003\u0011\b\u0000CE\u0001\u0000\u0000\u0000D=\u0001\u0000\u0000\u0000"+
		"DA\u0001\u0000\u0000\u0000E\b\u0001\u0000\u0000\u0000FJ\u0007\u0002\u0000"+
		"\u0000GI\u0007\u0003\u0000\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\n\u0001"+
		"\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000MN\u0005\'\u0000\u0000NO\t"+
		"\u0000\u0000\u0000O\\\u0005\'\u0000\u0000PQ\u0005\'\u0000\u0000QR\u0005"+
		"\\\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0007\u0004\u0000\u0000T\\"+
		"\u0005\'\u0000\u0000UV\u0005\'\u0000\u0000VW\u0005\\\u0000\u0000WX\u0001"+
		"\u0000\u0000\u0000XY\u0003\u0003\u0001\u0000YZ\u0005\'\u0000\u0000Z\\"+
		"\u0001\u0000\u0000\u0000[M\u0001\u0000\u0000\u0000[P\u0001\u0000\u0000"+
		"\u0000[U\u0001\u0000\u0000\u0000\\\f\u0001\u0000\u0000\u0000]^\u0007\u0005"+
		"\u0000\u0000^\u000e\u0001\u0000\u0000\u0000_`\u0003\u0003\u0001\u0000"+
		"`d\u0005.\u0000\u0000ac\u0003\r\u0006\u0000ba\u0001\u0000\u0000\u0000"+
		"cf\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000en\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000gi\u0005.\u0000"+
		"\u0000hj\u0003\r\u0006\u0000ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000m_\u0001\u0000\u0000\u0000mg\u0001\u0000\u0000\u0000n\u0010"+
		"\u0001\u0000\u0000\u0000oq\u0007\u0006\u0000\u0000pr\u0007\u0007\u0000"+
		"\u0000qp\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000st\u0003\u0003\u0001\u0000t\u0012\u0001\u0000\u0000\u0000"+
		"\u000f\u0000\u0016\u001e\"*59?DJ[dkmq\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}