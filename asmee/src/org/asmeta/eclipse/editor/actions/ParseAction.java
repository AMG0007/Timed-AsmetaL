package org.asmeta.eclipse.editor.actions;

import org.asmeta.eclipse.AsmeeConsole;
import org.asmeta.eclipse.Utility;
import org.asmeta.eclipse.editor.AsmetaLEditor;
import org.asmeta.parser.ParserResultLogger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleView;

/**
 * Our sample action implements workbench action delegate. The action proxy will
 * be created by the workbench and shown in the UI. When the user tries to use
 * the action, this delegate will be created and execution will be delegated to
 * it. 
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class ParseAction implements IWorkbenchWindowActionDelegate {
	
	private IWorkbenchWindow window;

	/**
	 * The constructor.
	 */
	public ParseAction() {
	}

	/**
	 * The action has been activated. The argument of the method represents the
	 * 'real' action sitting in the workbench UI.
	 * 
	 * @see IWorkbenchWindowActionDelegate#run
	 */
	@Override
	public void run(IAction action) {

		// get the current document as file (IFile)
		IEditorPart part = window.getActivePage().getActiveEditor();
		AsmetaLEditor editor = (AsmetaLEditor) part;
		// save the file
		editor.doSave(new NullProgressMonitor());
		IEditorInput input = part.getEditorInput();
		IFile file = ((IFileEditorInput) input).getFile();

		try {
			// open the console !!
			IConsoleView view = (IConsoleView) window.getActivePage().showView(IConsoleConstants.ID_CONSOLE_VIEW);
			AsmeeConsole mc = Utility.findDefaultConsole();
			view.display(mc);
			// run the action
			// 1. create the runner
			Job parseJob = new ParseJob(file, mc);
			// 2. clear the markers
			editor.clearMarkers(file);
			// run the parse
			parseJob.schedule();
			// wait for it
			parseJob.join();
			// if there is an error
			// DIC 10 AG : non funziona: reports always no error
			ParserResultLogger result = ParseJob.parseResult;
			if ((result != null) && result.lastParseError != null){
				mc.writeMessage("errors in parsing");
				editor.updateMarkers(file,
						result.lastParseError.currentToken.beginLine,
						result.lastParseError.currentToken.beginColumn,
						result.lastParseError.currentToken.endColumn,
						result.lastParseError.currentToken.toString().replace('\n', ' '));
			} 
		} catch (PartInitException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Selection in the workbench has been changed. We can change the state of
	 * the 'real' action here if we want, but this can only happen after the
	 * delegate has been created.
	 * 
	 * @see IWorkbenchWindowActionDelegate#selectionChanged
	 */
	@Override
	public void selectionChanged(IAction action, ISelection selection) {
	}

	/**
	 * We can use this method to dispose of any system resources we previously
	 * allocated.
	 * 
	 * @see IWorkbenchWindowActionDelegate#dispose
	 */
	@Override
	public void dispose() {
	}

	/**
	 * We will cache window object in order to be able to provide parent shell
	 * for the message dialog.
	 * 
	 * @see IWorkbenchWindowActionDelegate#init
	 */
	@Override
	public void init(IWorkbenchWindow window) {
		this.window = window;
	}
}