package org.asmeta.eclipse.interpreter.jobs;

import java.io.InputStream;
import java.io.PrintStream;

import org.asmeta.interpreter.readers.InteractiveMFReader;
import org.asmeta.interpreter.readers.MonFuncReader;
import org.eclipse.core.resources.IFile;
/** run step by step computation until is canceled */
public class RunStepJob extends RunJob {

	/**
	 * the file to run
	 */
	public RunStepJob(IFile asmFile) {
		super(asmFile, false);
	}

	@Override
	protected MonFuncReader getUI(InputStream is, PrintStream printOut) {
		return new InteractiveMFReader(is, printOut);
	}

	@Override
	protected String getRunMessage() {
		return "Running interactively";
	}
}