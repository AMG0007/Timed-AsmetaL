package org.asmeta.eclipse.editor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.ui.editors.text.TextEditor;

public class AsmetaLEditor extends TextEditor {

	private ColorManager colorManager;

	public AsmetaLEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new Configuration(colorManager));
	}

	@Override
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

	/**
	 * udpate markers on the document to be edited rawMsg: int line number where
	 * the problem is, message esempio 1,dioodw
	 */

	public void updateMarkers(IResource resource, int line, int startColumn,
			int endColumn, String msg) {
		// install a new marker
		try {
			if (line <= 0) {
				// no line number so trigger an external box !
				ErrorDialog.openError(getSite().getShell(),
						"Unlocalized compilation error",
						"Unlocalized compilation error", new Status(
								IStatus.ERROR, "org.asmeta.eclipse", 0, msg, null));
				return;
			}
			IMarker m = resource.createMarker(IMarker.PROBLEM);
			m.setAttribute(IMarker.LINE_NUMBER, line);
			m.setAttribute(IMarker.CHAR_START, startColumn);
			m.setAttribute(IMarker.CHAR_END, endColumn);
			m.setAttribute(IMarker.MESSAGE, msg);
			m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
		} catch (CoreException e) {
		}
	}

	/**
	 * clear markers for a resource
	 * 
	 * @throws CoreException
	 */
	public void clearMarkers(IResource resource) throws CoreException {
		resource.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
	}
}