package org.asmeta.eclipse.editor;

//import org.eclipse.core.runtime.Preferences;
import org.asmeta.eclipse.AsmeeActivator;
import org.asmeta.eclipse.editor.preferences.PreferenceConstants;
import org.asmeta.parser.ASMParserConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.PatternRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.graphics.RGB;

/** scanner of the asm files to identify tokens to be highlighted */

public class AsmScanner extends RuleBasedScanner {

	public AsmScanner(ColorManager manager) {

		// COMMENTS
		// Preferences prefs =
		// AsmeeActivator.getDefault().getPluginPreferences();
		IPreferenceStore store = AsmeeActivator.getDefault()
				.getPreferenceStore();
		// if
		// (prefs.getBoolean(PreferenceConstants.GROOVY_EDITOR_HIGHLIGHT_GJDK_ENABLED))
		// {
		RGB commentRGB = PreferenceConverter.getColor(store,
				PreferenceConstants.P_COLOR_ASM_COMMENT);
		IToken commentToken = new Token(new TextAttribute(
				manager.getColor(commentRGB)));
		// RULES
		RGB rulesRGB = PreferenceConverter.getColor(store,
				PreferenceConstants.P_COLOR_ASM_RULES);
		IToken ruleToken = new Token(new TextAttribute(
				manager.getColor(rulesRGB)));
		PatternRule wrRules = new PatternRule("r_", " ", ruleToken, '_', true);
		// LOGICAL VARIABLES
		RGB varsRGB = PreferenceConverter.getColor(store,
				PreferenceConstants.P_COLOR_ASM_VARS);
		IToken varsToken = new Token(new TextAttribute(
				manager.getColor(varsRGB)));
		PatternRule varRule = new PatternRule("$", " ", varsToken, '$', true);
		// KEYWORDS
		RGB keywordRGB = PreferenceConverter.getColor(store,
				PreferenceConstants.P_COLOR_ASM_KEYWORD);
		IToken keywordToken = new Token(new TextAttribute(
				manager.getColor(keywordRGB)));
		WordRule wrkeyword = new WordRule(new IWordDetector() {
			@Override
			public boolean isWordStart(char c) {
				return Character.isLetter(c);
				// return Character.isJavaIdentifierStart(c);
			}

			@Override
			public boolean isWordPart(char c) {
				return Character.isLetter(c);
				// return Character.isJavaIdentifierPart(c);
			}
		});
		// get the keywords from ASMParserConstsnts
		String[] keywords = ASMParserConstants.tokenImage;
		for (String s : keywords) {
			// skip if keyword begins with <
			if (s.startsWith("<"))
				continue;
			// sostituisci \" con niente
			String k = s.replaceAll("\\\"", "");
			// only if it starts with a letter
			if (!Character.isLetter(k.charAt(0)))
				continue;
			// System.out.println(k);
			wrkeyword.addWord(k, keywordToken);
		}
		// add all the rules
		setRules(new IRule[] { wrkeyword,
				// Add rule for comments
				new EndOfLineRule("//", commentToken),
				// new EndOfLineRule("--", commentToken),
				new MultiLineRule("/*", "*/", commentToken),
				// for rules
				wrRules, varRule, new WhitespaceRule(new IWhitespaceDetector() {
					@Override
					public boolean isWhitespace(char c) {
						return Character.isWhitespace(c);
					}
				}) });
	}
}