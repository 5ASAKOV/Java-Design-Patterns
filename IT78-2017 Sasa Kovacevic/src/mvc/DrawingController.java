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
import hexagon.Hexagon;

public class DrawingController {
	private DrawingModel model;
	private DrawingFrame frame;
	private Point startPoint;
	private Shape testShape;
	
	private Command lastCommand;
	private Command previousCommand;
	private Command lastRedoCommand;
	private Shape s = null;
	private Shape oldShape = null;
	
	
	private LinkedList<Command> commandsUndo = new LinkedList<Command>();  
	private LinkedList<Command> commandsRedo = new LinkedList<Command>();   
	
	private int numOfUndoCommands; 
	private int numOfRedoCommands; 


	public DrawingController(DrawingModel model, DrawingFrame frame) {
		this.model = model;
		this.frame = frame;
	}
	

	public void mouseClicked(MouseEvent arg0) {
		if(frame.getTglbtnPoint()){
			
			Point p = new Point(arg0.getX(), arg0.getY());
			DialogPoint dp = new DialogPoint();
			dp.getBtnColor().setVisible(false);
			dp.setTextXEdit(false);
			dp.setTextYEdit(false);
			dp.setTextX(Integer.toString(p.getX()));
			dp.setTextY(Integer.toString(p.getY()));
			dp.setVisible(true);
			p.setCol(frame.getBtnEdgeColor().getBackground());
			
			CmdAddShape cmdAddShape = new CmdAddShape(model,p);
			cmdAddShape.execute();
			
			addCommandsUndo(cmdAddShape);
			checkRedo();
			
			frame.getListModel().addElement("Draw: " + p.toString());
			frame.repaint();
			
		}
		else if (frame.getTglbtnLine()) {
			if(startPoint == null)
			{
				startPoint = new Point(arg0.getX(),arg0.getY());
			}
			else {
				Line l = new Line(startPoint, new Point(arg0.getX(), arg0.getY(), frame.getBtnEdgeColor().getBackground()));
				DialogLine dl = new DialogLine();
				dl.getBtnColor().setVisible(false);
				dl.setTextEndXEdit(false);
				dl.setTextEndYEdit(false);
				dl.setTextStartXEdit(false);
				dl.setTextStartYEdit(false);
				dl.setTextStartX(Integer.toString(l.getStartPoint().getX()));
				dl.setTextStartY(Integer.toString(l.getStartPoint().getY()));
				dl.setTextEndX(Integer.toString(l.getEndPoint().getX()));
				dl.setTextEndY(Integer.toString(l.getEndPoint().getY()));
				dl.setVisible(true);
				l.setCol(frame.getBtnEdgeColor().getBackground());
				
				CmdAddShape cmdAddShape = new CmdAddShape(model,l);
				cmdAddShape.execute();
				
				addCommandsUndo(cmdAddShape);
				checkRedo();

				frame.getListModel().addElement("Draw: " + l.toString());
				frame.repaint();
				startPoint = null;	
			}	
		}
		else if (frame.getTglbtnRectangle()) {
			Point p = new Point(arg0.getX(),arg0.getY());
			DialogRectangle dr = new DialogRectangle();
			dr.getBtnEdgeColor().setVisible(false);
			dr.getBtnFillColor().setVisible(false);
			dr.setTextXcor(Integer.toString(p.getX()));
			dr.setTextYcor(Integer.toString(p.getY()));
			dr.setTextXcorEditable(false);
			dr.setTextYcorEditable(false);
			dr.setVisible(true);
			
			if(dr.isOk())
			{
				int width = Integer.parseInt(dr.getTextWidth());
				int height = Integer.parseInt(dr.getTextHeight());
				
				if (height == 0 || width == 0) {
					
					JOptionPane.showMessageDialog(new JFrame(), "Height and width must be positive numbers.", "Error!", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					Rectangle rct = new Rectangle(p, height, width);
					rct.setEdgeColor(frame.getBtnEdgeColor().getBackground());
					rct.setFillColor(frame.getBtnFillColor().getBackground());

					CmdAddShape cmdAddShape = new CmdAddShape(model, rct);
					cmdAddShape.execute();

					addCommandsUndo(cmdAddShape);
					checkRedo();

					frame.getListModel().addElement("Draw: " + rct.toString());
					frame.repaint();
				}
			}
		}
		else if (frame.getTglbtnHexagon()) {
			Point center = new Point(arg0.getX(),arg0.getY());
			DialogCircle dh = new DialogCircle();
			dh.getBtnEdgeColor().setVisible(false);
			dh.getBtnFillColor().setVisible(false);
			dh.setTitle("Hexagon");
			dh.setTextXEdit(false);
			dh.setTextYEdit(false);
			dh.setTextX(Integer.toString(center.getX()));
			dh.setTextY(Integer.toString(center.getY()));
			dh.setVisible(true);
			
			if(dh.isOk())
			{
				int radius = Integer.parseInt(dh.getTextRadius());
				if(radius == 0)                         
				{
					JOptionPane.showMessageDialog(new JFrame(), "Radius must be greater than 0", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					HexagonAdapter h = new HexagonAdapter(arg0.getX(),arg0.getY(),radius);				
					h.setColor(frame.getBtnEdgeColor().getBackground());
					h.setFillColor(frame.getBtnFillColor().getBackground());
							
					CmdAddShape cmdAddShape = new CmdAddShape(model,h);
					cmdAddShape.execute();
					
					addCommandsUndo(cmdAddShape);
					checkRedo();

					frame.getListModel().addElement("Draw: " + h.toString());
					frame.repaint();
				}
			}				
		}
		else if (frame.getTglbtnCircle()) {
			Point center = new Point(arg0.getX(),arg0.getY());
			DialogCircle dc = new DialogCircle();
			dc.getBtnEdgeColor().setVisible(false);
			dc.getBtnFillColor().setVisible(false);
			dc.setTextXEdit(false);
			dc.setTextYEdit(false);
			dc.setTextX(Integer.toString(center.getX()));
			dc.setTextY(Integer.toString(center.getY()));
			dc.setVisible(true);

			if(dc.isOk())
			{
				int radius = Integer.parseInt(dc.getTextRadius());
				if(radius == 0)                                                           
				{
					JOptionPane.showMessageDialog(new JFrame(), "Radius must be greater than 0", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else {
					
					Circle c = new Circle(center,radius);
					c.setEdgeColor(frame.getBtnEdgeColor().getBackground());
					c.setFillColor(frame.getBtnFillColor().getBackground());
					
					CmdAddShape cmdAddShape = new CmdAddShape(model,c);
					cmdAddShape.execute();
					
					addCommandsUndo(cmdAddShape);
					checkRedo();

					frame.getListModel().addElement("Draw: " + c.toString());
					frame.repaint();
				}
		
			}				
		}
		else if (frame.getTglbtnDonut()) {
			Point center = new Point(arg0.getX(),arg0.getY());
			center.setCol(frame.getBtnEdgeColor().getBackground());
			DialogDonut dd = new DialogDonut();
			dd.getBtnEdgeColor().setVisible(false);
			dd.getBtnFillColor().setVisible(false);
			dd.setTextX(Integer.toString(center.getX()));
			dd.setTextY(Integer.toString(center.getY()));
			dd.setTextXEditable(false);
			dd.setTextYEditable(false);
			dd.setVisible(true);

			if(dd.isOk())
			{
				int innerRadius = Integer.parseInt(dd.getTextInnerR());
				int outerRadius = Integer.parseInt(dd.getTextOuterR());
				if(innerRadius == 0)                                                           
				{
					JOptionPane.showMessageDialog(new JFrame(), "Inner radius must be greater than 0", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else if (innerRadius >= outerRadius)
				{
					JOptionPane.showMessageDialog(new JFrame(), "Outer radius must be greater than inner radius", "Error", JOptionPane.WARNING_MESSAGE);
				}
				else
				{
					Donut donut = new Donut(center,outerRadius,innerRadius);
					donut.setEdgeColor(frame.getBtnEdgeColor().getBackground());
					donut.setsEdgeColor(frame.getBtnEdgeColor().getBackground());
					donut.setFillColor(frame.getBtnFillColor().getBackground());
					
					CmdAddShape cmdAddShape = new CmdAddShape(model,donut);
					cmdAddShape.execute();
					
					addCommandsUndo(cmdAddShape);
					checkRedo();

					frame.getListModel().addElement("Draw: " + donut.toString());
					frame.repaint();
				}
			}			
		}
		else if (frame.getTglbtnSelect()) {
			Point p = new Point(arg0.getX(),arg0.getY());
			int prev = 0;
			int ii = 0;
	
			ArrayList<Shape> shapes = new ArrayList<Shape>();
			shapes = (ArrayList<Shape>) model.getShapes();
			
			ArrayList<Shape> shapesover = new ArrayList<Shape>();
			
			for (int it = 0; it<= shapes.size() - 1; it++) {
				if (shapes.get(it).contains(p.getX(),p.getY())) {
					shapesover.add(shapes.get(it));
					prev++;
				}
			}
			if (prev > 1) {
				
				if(JOptionPane.showConfirmDialog(new JFrame(), "Do you want to (de)select just last painted shape?", "Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
				
					for (ii = 0; ii< shapesover.size() - 1; ii++) {}
					
						if (shapesover.get(ii).contains(p.getX(),p.getY())) {
						
							if (shapesover.get(ii).isSelected() == false){
								logSelect(model, shapesover.get(ii));
				
							} else {
								
								CmdDeselectShape cmdDeselectShape = new CmdDeselectShape(model,shapesover.get(ii));
								cmdDeselectShape.execute();
								
								//check
								System.out.println("Selected test: " + shapesover.get(ii).isSelected());
								System.out.println("Current selected: " + model.getNumOfSelected());
								
								addCommandsUndo(cmdDeselectShape);
								frame.getListModel().addElement("Deselect: " + shapesover.get(ii).toString());
							}
						} 
						ii=0;
						
				} else {System.out.println("NO");} 
				
			} else {
				
				for (int i = 0; i<= shapes.size() - 1; i++) {
					if (shapes.get(i).contains(p.getX(),p.getY())) {
					
						if (shapes.get(i).isSelected() == false){
			
							logSelect(model, shapes.get(i));
							testShape = shapes.get(i);
							
							System.out.println("Test shape = " + shapes.get(i).toString());
							System.out.println("Current selected: " + model.getNumOfSelected());
			
						} else {
							
							CmdDeselectShape cmdDeselectShape = new CmdDeselectShape(model,shapes.get(i));
							cmdDeselectShape.execute();
							
							//check
							System.out.println("Selected test: " + shapes.get(i).isSelected());
							System.out.println("Current selected: " + model.getNumOfSelected());
							
							addCommandsUndo(cmdDeselectShape);
							frame.getListModel().addElement("Deselect: " + shapes.get(i).toString());
						}
					}
				}
			}
		}
		
		frame.repaint();  					
	}
	
//MODIFIKACIJA
	
	public void btnModifyClicked(MouseEvent arg0) {
		
		testShape = model.getAllSelected().get(0);
		//chek -- mogu i bez get0
		System.out.println("Test shape = " + model.getAllSelected().get(0));
		
		if(testShape != null)
		{
			if(testShape instanceof Point)
			{
				Point oldPoint = (Point) testShape;
				DialogPoint dlgP = new DialogPoint();
				dlgP.setTextX(Integer.toString((oldPoint).getX()));
				dlgP.setTextY(Integer.toString((oldPoint).getY()));
				dlgP.setColor((oldPoint).getCol());
				dlgP.setVisible(true);

				if (dlgP.isOk()) {
					Point newPoint = new Point(Integer.parseInt(dlgP.getTextX()), Integer.parseInt(dlgP.getTextY()), dlgP.getColor());

					CmdUpdatePoint cmdPoint = new CmdUpdatePoint(oldPoint, newPoint);
					cmdPoint.execute();
					frame.repaint();

					addCommandsUndo(cmdPoint);
					frame.getListModel().addElement("Update: " + testShape.toString());
				}
			}
			else if(testShape instanceof Line)
			{
				Line oldLine = (Line) testShape;

				DialogLine dlgL = new DialogLine();
				dlgL.setTextStartX(Integer.toString((oldLine).getStartPoint().getX()));
				dlgL.setTextStartY(Integer.toString((oldLine).getStartPoint().getY()));
				dlgL.setTextEndX(Integer.toString((oldLine).getEndPoint().getX()));
				dlgL.setTextEndY(Integer.toString((oldLine).getEndPoint().getY()));
				dlgL.setCol((oldLine).getCol());
				dlgL.setVisible(true);

				if (dlgL.isOk()) {
					Line newLine = new Line(new Point(Integer.parseInt(dlgL.getTextStartX()),Integer.parseInt(dlgL.getTextStartY())), new Point(Integer.parseInt(dlgL.getTextEndX()),Integer.parseInt(dlgL.getTextEndY())), dlgL.getCol());
				
					CmdUpdateLine cmdLine = new CmdUpdateLine(oldLine, newLine);
					cmdLine.execute();
					frame.repaint();

					addCommandsUndo(cmdLine);
					frame.getListModel().addElement("Update: " + testShape.toString());
				}
			}
			else if(testShape instanceof Rectangle)
			{
				Rectangle oldRectangle = (Rectangle)testShape;
				
				DialogRectangle dlgR = new DialogRectangle();
				dlgR.setTextXcor(Integer.toString((oldRectangle).getUpperLeftPoint().getX()));
				dlgR.setTextYcor(Integer.toString((oldRectangle).getUpperLeftPoint().getY()));
				dlgR.setTextWidth(Integer.toString((oldRectangle).getWidth()));
				dlgR.setTextHeight(Integer.toString((oldRectangle).getHeight()));
				dlgR.setFillColor((oldRectangle).getFillColor());
				dlgR.setEdgeColor((oldRectangle).getEdgeColor());
				dlgR.setVisible(true);
				
				if (dlgR.isOk()) {
					Point upperLeftPoint = new Point(Integer.parseInt(dlgR.getTextXcor()), Integer.parseInt(dlgR.getTextYcor()));
					int height = Integer.parseInt(dlgR.getTextHeight());
					int width = Integer.parseInt(dlgR.getTextWidth());
					
					if (height == 0 || width == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Height and width must be positive numbers.", "Error!", JOptionPane.WARNING_MESSAGE);
					}
					else
					{
						Rectangle newRectangle = new Rectangle(upperLeftPoint, height, width);
						newRectangle.setEdgeColor(dlgR.getEdgeColor());
						newRectangle.setFillColor(dlgR.getFillColor());
	
						CmdUpdateRectangle cmdRectangle = new CmdUpdateRectangle(oldRectangle, newRectangle);
						cmdRectangle.execute();
						frame.repaint();
	
						addCommandsUndo(cmdRectangle);
						frame.getListModel().addElement("Update: " + testShape.toString());
						
						System.out.println("Test shape = " + testShape.toString());
					}	
				}	
			}
			else if(testShape instanceof HexagonAdapter)
			{
				HexagonAdapter oldHexagon = (HexagonAdapter) testShape;
				
				DialogCircle dlgH = new DialogCircle();
				dlgH.setTitle("Hexagon");
				dlgH.setTextX(Integer.toString((oldHexagon).getHexagon().getX()));
				dlgH.setTextY(Integer.toString((oldHexagon).getHexagon().getY()));
				dlgH.setTextRadius(Integer.toString((oldHexagon).getHexagon().getR()));
				dlgH.setFillColor((oldHexagon).getHexagon().getAreaColor());
				dlgH.setEdgeColor((oldHexagon).getHexagon().getBorderColor());
				dlgH.setVisible(true);
			
				if (dlgH.isOk()) {
					int radius = Integer.parseInt(dlgH.getTextRadius());

					if (radius == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Radius must be greater than 0", "Error",
								JOptionPane.WARNING_MESSAGE);
					} else {
						HexagonAdapter newHexagon = new HexagonAdapter(Integer.parseInt(dlgH.getTextX()), Integer.parseInt(dlgH.getTextY()), Integer.parseInt(dlgH.getTextRadius()));
						newHexagon.setColor(dlgH.getEdgeColor());
						newHexagon.setFillColor(dlgH.getFillColor());
						
						CmdUpdateHexagon cmdHexagon = new CmdUpdateHexagon(oldHexagon, newHexagon);
						cmdHexagon.execute();
						frame.repaint();

						addCommandsUndo(cmdHexagon);
						frame.getListModel().addElement("Update: " + testShape.toString());
					}
				}
			}
			else if(testShape instanceof Donut) 
			{
				Donut oldDonut = (Donut) testShape;
				
				DialogDonut dlgD = new DialogDonut();
				dlgD.setTextX(Integer.toString((oldDonut).getCenter().getX()));
				dlgD.setTextY(Integer.toString((oldDonut).getCenter().getY()));
				dlgD.setTextInnerR(Integer.toString((oldDonut).getInnerRadius()));
				dlgD.setTextOuterR(Integer.toString((oldDonut).getRadius()));
				dlgD.setEdgeColor(((oldDonut).getsEdgeColor()));
				dlgD.setFillColor(((oldDonut).getFillColor()));
				dlgD.setVisible(true);

				if (dlgD.isOk()) {

					int innerRadius = Integer.parseInt(dlgD.getTextInnerR());
					int outerRadius = Integer.parseInt(dlgD.getTextOuterR());
					if (innerRadius == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Radius must be greater than 0", "Error",
								JOptionPane.WARNING_MESSAGE);
					}
					else if (innerRadius >= outerRadius) {
						JOptionPane.showMessageDialog(new JFrame(), "Outer radius must be greater than inner radius",
								"Error", JOptionPane.WARNING_MESSAGE);
					}
					else {
						Donut newDonut = new Donut(new Point(Integer.parseInt(dlgD.getTextX()), Integer.parseInt(dlgD.getTextY())), outerRadius, innerRadius);
						newDonut.setsEdgeColor(dlgD.getEdgeColor());
						newDonut.setFillColor(dlgD.getFillColor());
						
						CmdUpdateDonut cmdDonut = new CmdUpdateDonut(oldDonut, newDonut);
						cmdDonut.execute();
						frame.repaint();
	
						addCommandsUndo(cmdDonut);
						frame.getListModel().addElement("Update: " + testShape.toString());
					}
				}
			}
			else if(testShape instanceof Circle)
			{
				Circle oldCircle = (Circle) testShape;

				DialogCircle dlgC = new DialogCircle();
				dlgC.setTextX(Integer.toString((oldCircle).getCenter().getX()));
				dlgC.setTextY(Integer.toString((oldCircle).getCenter().getY()));
				dlgC.setTextRadius(Integer.toString((oldCircle).getRadius()));
				dlgC.setFillColor((oldCircle).getFillColor());
				dlgC.setEdgeColor((oldCircle).getEdgeColor());
				dlgC.setVisible(true);
				
				if (dlgC.isOk()) {
		
					int radius = Integer.parseInt(dlgC.getTextRadius());

					if (radius == 0) {
						JOptionPane.showMessageDialog(new JFrame(), "Radius must be greater than 0", "Error",
								JOptionPane.WARNING_MESSAGE);
					} else {
						Circle newCircle = new Circle(new Point(Integer.parseInt(dlgC.getTextX()), Integer.parseInt(dlgC.getTextY())), Integer.parseInt(dlgC.getTextRadius()));
						newCircle.setEdgeColor(dlgC.getEdgeColor());
						newCircle.setFillColor(dlgC.getFillColor());
						
						CmdUpdateCircle cmdCircle = new CmdUpdateCircle(oldCircle, newCircle);
						cmdCircle.execute();
						frame.repaint();

						addCommandsUndo(cmdCircle);
						frame.getListModel().addElement("Update: " + testShape.toString());
					}
				}
			}	
		}
		else
		{		
			JOptionPane.showMessageDialog(new JFrame(), "You must select a shape.", "Error!", JOptionPane.WARNING_MESSAGE);
		}
	}
	
//BRISANJE
	public void btnDeleteClicked(MouseEvent arg0) {
		List<Shape> shapes = model.getAllSelected();
		if(JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to delete selected shape?", "Confirmation",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		{
			while(shapes.size() > 0)
			{
				frame.getListModel().addElement("Delete: " + shapes.get(0).toString());
				
				CmdRemoveShape cmdRemoveShape = new CmdRemoveShape(model,shapes.get(0));
				cmdRemoveShape.execute();	            
				
				addCommandsUndo(cmdRemoveShape);    

			}
			frame.repaint();
		}
	}
	
// TANSLACIJA PO Z OSI
	public void toFront() {
		if (testShape != null) {
			CmdToFront cmdToFront = new CmdToFront (model, testShape);
			frame.getListModel().addElement("ToFront: " + testShape);
			cmdToFront.execute();
			
			addCommandsUndo(cmdToFront);
			
			frame.repaint();
		}
	}
	
	public void bringToFront() {
		if (testShape != null) {			
			CmdBringToFront cmdBringToFront = new CmdBringToFront (model, testShape);
			frame.getListModel().addElement("BringToFront: " + testShape);
			cmdBringToFront.execute();
			
			addCommandsUndo(cmdBringToFront);

			frame.repaint();
		}
	}
	
	public void toBack() {
		//testShape je selektovan
		if (testShape != null) {
			CmdToBack cmdToBack = new CmdToBack (model, testShape);
			frame.getListModel().addElement("ToBack: " + testShape);
			cmdToBack.execute();

			addCommandsUndo(cmdToBack);
			
			frame.repaint();
		}
	}
	
	public void bringToBack() {
		if (testShape != null) {
			CmdBringToBack cmdBringToBack = new CmdBringToBack (model, testShape);
			frame.getListModel().addElement("BringToBack: " + testShape);
			cmdBringToBack.execute();
			
			addCommandsUndo(cmdBringToBack);

			frame.repaint();
		}
	}
	
// UNDO I REDO

	public void undo() {
		lastCommand = commandsUndo.getLast();
		
		for (int i = 0; i < commandsUndo.size() - 1; i++) {
			previousCommand = commandsUndo.get(i);
		}
		commandsUndo.getLast().unexecute();
		addCommandsRedo(commandsUndo.getLast());
		frame.getBtnRedo().setEnabled(true);
		removeCommandsUndo(commandsUndo.removeLast());
		
		if (commandsUndo.size() > 0) {    
			if (lastCommand instanceof CmdRemoveShape && previousCommand instanceof CmdRemoveShape) { 
				undo(); 
			} 
		}
		else 
			frame.getBtnUndo().setEnabled(false);
		
		frame.getListModel().addElement("Undo() ");
		frame.repaint();
	}
	
	
	public void redo() {
		lastCommand = commandsRedo.getLast();
		
		for (int i = 0; i < commandsRedo.size() - 1; i++) {
			previousCommand = commandsRedo.get(i);
		}
		commandsRedo.getLast().execute();
		addCommandsUndo(commandsRedo.getLast());
		removeCommandsRedo(commandsRedo.removeLast());
		
		if (commandsRedo.size() > 0) {    
			if (lastCommand instanceof CmdRemoveShape && previousCommand instanceof CmdRemoveShape) { 
				redo(); 
			} 
		}
		else 
			frame.getBtnRedo().setEnabled(false);
		
		frame.getListModel().addElement("Redo() ");
		frame.repaint();
	}
	
	
	public void checkRedo() {
		
		if (commandsRedo.size() > 0) {
			for (int i = 0; i < commandsRedo.size() - 1; i++) {
				previousCommand = commandsRedo.get(i);
			}
			lastRedoCommand = commandsRedo.getLast();
			
			if (lastRedoCommand instanceof CmdRemoveShape || lastRedoCommand instanceof CmdAddShape) {
				removeCommandsRedo(commandsRedo.removeLast());
				
				if (lastRedoCommand instanceof CmdRemoveShape && previousCommand instanceof CmdRemoveShape) { 
					removeCommandsRedo(commandsRedo.removeLast());
				}
			}
		} 
		
		if (commandsRedo.size() == 0) 
			frame.getBtnNext().setEnabled(true);
		return;
	}

	public void logSelect(DrawingModel m, Shape s) {
		CmdSelectShape cmd = new CmdSelectShape(m, s);
		cmd.execute();
		addCommandsUndo(cmd);
		
		frame.getListModel().addElement("Select: " + s.toString());
	}
	
	public void logDeselect(Shape s) {
		CmdDeselectShape cmd = new CmdDeselectShape(model, s);
		cmd.execute();
		addCommandsUndo(cmd);

		frame.getListModel().addElement("Deselect: " + s.toString());
	}
	
//UNDO
	public LinkedList<Command> getCommandsUndo() {
		return commandsUndo;
	}

	public void setCommandsUndo(LinkedList<Command> commandsUndo) {
		this.commandsUndo = commandsUndo;
	}
	
	public void addCommandsUndo(Command c) {
		commandsUndo.add(c);
		setNumOfUndoCommands(this.commandsUndo.size());

	}
	
	public void removeCommandsUndo(Command c) {
		commandsUndo.remove(c);
		setNumOfUndoCommands(this.commandsUndo.size());
	}
		
//REDO
	public LinkedList<Command> getCommandsRedo() {
		return commandsRedo;
	}

	public void setCommandsRedo(LinkedList<Command> commandsRedo) {
		this.commandsRedo = commandsRedo;
	}
	
	public void addCommandsRedo(Command c) {
		commandsRedo.add(c);
		setNumOfRedoCommands(this.commandsRedo.size());
	}

	public void removeCommandsRedo(Command c) {
		commandsRedo.remove(c);
		setNumOfRedoCommands(this.commandsRedo.size());
	}
	
//NumOfUndo/RedoCommands
	public int getNumOfUndoCommands() {
		return numOfUndoCommands;
	}

	public void setNumOfUndoCommands(int numOfUndoCommands) {
		this.numOfUndoCommands = numOfUndoCommands;
	}

	public int getNumOfRedoCommands() {
		return numOfRedoCommands;
	}

	public void setNumOfRedoCommands(int numOfRedoCommands) {
		this.numOfRedoCommands = numOfRedoCommands;
	}

	public Shape getTestShape() {
		return testShape;
	}

	public void setTestShape(Shape testShape) {
		this.testShape = testShape;
	}

}