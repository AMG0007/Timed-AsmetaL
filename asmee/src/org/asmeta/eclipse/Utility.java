package org.asmeta.eclipse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.asmeta.eclipse.editor.preferences.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;

public class Utility {

	
	/** find the default console of this editor where to send messages
	 * if there is not ASMEE console yet, it creates a new one.
	 */
	public static AsmeeConsole findDefaultConsole() {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++) {
			if ( existing[i] instanceof AsmeeConsole) { 
				return (AsmeeConsole) existing[i];
			}
		}
		// no console found, so create a new one
		// not that message console could be enough, but it is not writable !!!
		AsmeeConsole myConsole = new AsmeeConsole();
		conMan.addConsoles(new IConsole[] { myConsole });
		myConsole.activate();
		return myConsole;
	}

	public static void setUpLogger(IPreferenceStore store) {
		// for debugging
		// get the preference
		Boolean useexternalFile = store.getBoolean(PreferenceConstants.P_DEBUG_USE_EXTERNAL_FILE);
		if (useexternalFile){
			String fileConf = store.getString(PreferenceConstants.P_DEBUG_EXTERNAL_FILE);
			//PropertyConfigurator.configureAndWatch("log4j.asmee.prop");
			PropertyConfigurator.configureAndWatch(fileConf);
		} else{		
			String parserDebuglevel = store.getString(PreferenceConstants.P_DEBUG_PARSER);
			// note that parser uses this logger
			Logger.getLogger("org.asmeta.parser").setLevel(Level.toLevel(parserDebuglevel));
			String simulatorDebuglevel = store.getString(PreferenceConstants.P_DEBUG_SIMULATOR);
			//Logger.getLogger(Simulator.class).setLevel(Level.toLevel(simulatorDebuglevel));
			Logger.getLogger("org.asmeta.interpreter").setLevel(Level.toLevel(simulatorDebuglevel));
		}
	}	
}
