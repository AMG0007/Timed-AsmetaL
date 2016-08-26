package org.asmeta.eclipse.interpreter.actions;

import org.asmeta.eclipse.interpreter.jobs.RunJob;
import org.asmeta.eclipse.interpreter.jobs.RunStepJob;
import org.eclipse.core.resources.IFile;

public class RunStepAction extends RunAction {

	@Override
	protected RunJob getJob(IFile file) {
		return new RunStepJob(file);
	}
}