package stacklab;

import java.util.*;


public class UndoRedoPainter extends Painter

{	
	public UndoRedoPainter() {
		setUndoButtonEnabled(false);
		setRedoButtonEnabled(false);
	}
	// Called when the user pushes the Undo button. //pop
	void undo()
	{
		Stack<Circle> history = super.getHistory();
		Stack<Circle> undoHistory = super.getUndoHistory();
		if (!history.isEmpty()) {
			Circle k = history.pop();
			undoHistory.push(k);
			repaint();
			setRedoButtonEnabled(true);
		}
		else {
			setUndoButtonEnabled(false);
		}
		
		
	}


	// Called when the user pushes the Redo button.
	void redo()
	{
		Stack<Circle> history = super.getHistory();
		Stack<Circle> undoHistory = super.getUndoHistory();
		if (!undoHistory.isEmpty()) {
			Circle k = undoHistory.pop();
			history.push(k);
			repaint();
			setUndoButtonEnabled(true);
		}
		else {
			setRedoButtonEnabled(false);
		}
	}
	
	
	public static void main(String[] args)
	{
		new UndoRedoPainter().setVisible(true);
	}
}
