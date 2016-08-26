package org.asmeta.eclipse.interpreter.actions;

import org.asmeta.eclipse.interpreter.jobs.RunJob;
import org.asmeta.eclipse.interpreter.jobs.RunRndJob;
import org.eclipse.core.resources.IFile;

public class RunRndAction extends RunAction {

	@Override
	protected RunJob getJob(IFile file) {
		return  new RunRndJob(file);
	}
}