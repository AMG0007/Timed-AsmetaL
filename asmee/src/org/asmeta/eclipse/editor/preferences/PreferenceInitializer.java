package org.asmeta.eclipse.editor.preferences;
  
import org.apache.log4j.Level;
import org.asmeta.eclipse.AsmeeActivator;
import org.asmeta.eclipse.editor.DefaultColorConstants;
import org.asmeta.interpreter.RuleEvaluator;
import org.asmeta.interpreter.main.Simulator;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;


/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
	 */
	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = AsmeeActivator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_SHUFFLE, true);
		RuleEvaluator.isShuffled = true;
		store.setDefault(PreferenceConstants.P_CHECK_AXIOMS, Simulator.checkInvariants);
		store.setDefault(PreferenceConstants.P_STOP_UPDATESET_EMPTY, true);
		store.setDefault(PreferenceConstants.P_STOP_UPDATESET_TRIVIAL, true);

		PreferenceConverter.setDefault(store, PreferenceConstants.P_COLOR_ASM_COMMENT, DefaultColorConstants.ASM_COMMENT);
		PreferenceConverter.setDefault(store, PreferenceConstants.P_COLOR_ASM_KEYWORD, DefaultColorConstants.ASM_KEYWORD);
		PreferenceConverter.setDefault(store, PreferenceConstants.P_COLOR_ASM_RULES, DefaultColorConstants.ASM_RULES);
		PreferenceConverter.setDefault(store, PreferenceConstants.P_COLOR_ASM_VARS,	DefaultColorConstants.ASM_VARIABLES);
		store.setDefault(PreferenceConstants.P_DEBUG_PARSER, Level.INFO.toString());
		store.setDefault(PreferenceConstants.P_DEBUG_SIMULATOR, Level.INFO.toString());
		store.setDefault(PreferenceConstants.P_DEBUG_USE_EXTERNAL_FILE,	false);
	}

}
