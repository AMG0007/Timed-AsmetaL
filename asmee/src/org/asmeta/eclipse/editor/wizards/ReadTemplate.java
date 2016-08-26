package org.asmeta.eclipse.editor.wizards;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.asmeta.eclipse.AsmeeActivator;

public class ReadTemplate {

	private static final ReadTemplate READ_TEMPLATE = new ReadTemplate();
	
	static final String templateNotFound = "/* template not found */ asm .... ";

	/** not static to use getClass method */
	private String readTemplate(String specname) {
		StringBuilder result = new StringBuilder();
		try {
			URL installURL = AsmeeActivator.getDefault().getBundle().getEntry(
					"/templates/template.asm");

			InputStream template = installURL.openStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					template));

			for (;;) {
				String s = reader.readLine();
				if (s == null)	break;
				// replace the name
				s.replace("new_file", specname);
				result.append(s).append('\n');
			}
			reader.close();

		} catch (Exception E) {
			E.printStackTrace();
			return templateNotFound + "Exception: " + E;
		}
		return result.toString();
	}

	/**
	 * Gets the template.
	 * 
	 * @param specname
	 *            the specification name
	 * 
	 * @return the template
	 */
	public static String getTemplate(String specname) {

		return READ_TEMPLATE.readTemplate(specname);

	}
}
