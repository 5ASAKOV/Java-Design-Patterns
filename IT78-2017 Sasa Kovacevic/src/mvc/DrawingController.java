package mvc;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import command.CmdAddShape;
import command.CmdBringToBack;
import command.CmdBringToFront;
import command.CmdDeselectShape;
import command.CmdRemoveShape;
import command.CmdSelectShape;
import command.CmdToBack;
import command.CmdToFront;
import command.CmdUpdateCircle;
import command.CmdUpdateDonut;
import command.CmdUpdateHexagon;
import command.CmdUpdateLine;
import command.CmdUpdatePoint;
import command.CmdUpdateRectangle;
import command.Command;
import dialog.DialogCircle;
import dialog.DialogDonut;
import dialog.DialogLine;
import dialog.DialogPoint;
import dialog.DialogRectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.HexagonAdapter;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import hexagon.Hexagon;;

public class DrawingController{
	private DrawingModel model;
	private DrawingFrame frame;
	private Point startPoint;
	
	private LinkedList<Command> commandsUndo = new LinkedList<Command>();  
	private LinkedList<Command> commandsRedo = new LinkedList<Command>();  
	
	
	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}
	

	public void mouseClicked(MouseEvent arg0) {
		if(frame.getTglbtnPoint()){
			
			
		}
		else if (frame.getTglbtnLine()) {
			
		}
		else if (frame.getTglbtnRectangle()) {
			
		}
		else if (frame.getTglbtnHexagon()) {
				
		}
		else if (frame.getTglbtnCircle()) {
				
		}
		else if (frame.getTglbtnDonut()) {
			
		}
		else if (frame.getTglbtnSelect()) {
			
		}				
	}
	
//MODIFIKACIJA
	
	public void btnModifyClicked(MouseEvent arg0) {
		
	}
	
//BRISANJE
	public void btnDeleteClicked(MouseEvent arg0) {
		
	}
	
// TANSLACIJA PO Z OSI
	public void toFront() {
		
	}
	
	public void bringToFront() {
		
	}
	
	public void toBack() {
		
	}
	
	public void bringToBack() {
		
	}
	
	public void undo() {
		
	}
	
	public void undoLog() {
		
	}
	
	public void redo() {
		
	}
	
	
	public void saveLog() {
		
	}
	
	public void openLog() {
		
	}
	
	public void next(){
		
	}
	

	public void saveDrawing() {
		
	}
	
	public void openDrawing() {
		
	}
}