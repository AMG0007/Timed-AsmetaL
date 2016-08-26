package org.asmeta.eclipse.interpreter.jobs;

import java.io.InputStream;
import java.io.PrintStream;

import org.asmeta.interpreter.readers.MonFuncReader;
import org.asmeta.interpreter.readers.RandomMFReader;
import org.eclipse.core.resources.IFile;

/**
 * The Class RunRndJob is a Job with random environment
 * It stops only if cancelled
 */
public class RunRndJob extends RunJob {

	/**
	 * the file to run  
	 * */	
	public RunRndJob(IFile asmFile){super(asmFile, true);}

	@Override
	protected MonFuncReader getUI(InputStream is, PrintStream printOut) {
		return new RandomMFReader(); 
	}

	@Override
	protected String getRunMessage() {
		return "Running with random values";
	}
}