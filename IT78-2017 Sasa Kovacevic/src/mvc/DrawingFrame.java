package mvc;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.UIManager;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import javax.swing.JScrollPane;



public class DrawingFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DrawingView view = new DrawingView();
	private DrawingController controller;

	JToggleButton tglbtnPoint;
	JToggleButton tglbtnLine;
	JToggleButton tglbtnRectangle;
	JToggleButton tglbtnCircle;
	JToggleButton tglbtnDonut;
	JToggleButton tglbtnSelect;
	JToggleButton tglbtnModify;
	JToggleButton tglbtnDelete;
	JToggleButton tglbtnHexagon;
	
	private JButton btnUndo;
	private JButton btnRedo;
	private JButton btnNext;
	private JButton btnToFront;
	private JButton btnBringToFront;
	private JButton btnToBack;
	private JButton btnBringToBack;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmOpenDrawing;
	private JMenuItem mntmSaveDrawing;
	private JSeparator separator;
	private JMenuItem mntmOpenLog;
	private JMenuItem mntmSaveLog;
	private JSeparator separator_1;
	private JMenuItem mntmExit;
	private JPanel toolBarPanel;
	private JButton btnEdgeColor;
	private JButton btnFillColor;
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JList<String> listLog = new JList<String>(listModel);
	private JScrollPane scrollPane = new JScrollPane(listLog);

	public DrawingFrame() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("IT78-2017 Sasa Kovacevic");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 900);
		setMinimumSize(new Dimension(1132,800));
		
		ButtonGroup grupa = new ButtonGroup();
		view.setBackground(Color.WHITE);
		
		view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
					controller.mouseClicked(arg0);
					  			  
			}
		});

		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
				
		tglbtnPoint = new JToggleButton("Point  ");
		tglbtnPoint.setBackground(UIManager.getColor("ToggleButton.light"));
		tglbtnPoint.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(tglbtnPoint);
		grupa.add(tglbtnPoint);
		
	    tglbtnLine = new JToggleButton("Line  ");
	    tglbtnLine.setBackground(UIManager.getColor("ToggleButton.light"));
		tglbtnLine.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(tglbtnLine);
		grupa.add(tglbtnLine);
		
		tglbtnRectangle = new JToggleButton("Rectangle  ");
		tglbtnRectangle.setBackground(UIManager.getColor("ToggleButton.light"));
		tglbtnRectangle.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(tglbtnRectangle);
		grupa.add(tglbtnRectangle);
		
		tglbtnCircle = new JToggleButton("Circle  ");
		tglbtnCircle.setBackground(UIManager.getColor("ToggleButton.light"));
		tglbtnCircle.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(tglbtnCircle);
		grupa.add(tglbtnCircle);
		
		tglbtnDonut = new JToggleButton("Donut    ");
		tglbtnDonut.setBackground(UIManager.getColor("ToggleButton.light"));
		tglbtnDonut.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		grupa.add(tglbtnDonut);
		toolBar.add(tglbtnDonut);
		
		tglbtnHexagon = new JToggleButton("Hexagon    ");
		tglbtnHexagon.setBackground(UIManager.getColor("ToggleButton.light"));
		tglbtnDonut.setBackground(UIManager.getColor("ToggleButton.light"));
		tglbtnHexagon.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		grupa.add(tglbtnHexagon);
		toolBar.add(tglbtnHexagon);
		
		//used to create dividing lines between menu items in a JMenu
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 51, 153));
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		tglbtnSelect = new JToggleButton("Select  ");
		grupa.add(tglbtnSelect);
		tglbtnSelect.setFont(new Font("Cambria Math", Font.BOLD, 18));
		toolBar.add(tglbtnSelect);
		
		tglbtnModify = new JToggleButton(" Modify  ");
		tglbtnModify.setEnabled(false);
		tglbtnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controller.btnModifyClicked(arg0);
			}
		});

		grupa.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Cambria Math", Font.BOLD, 18));
		toolBar.add(tglbtnModify);
		
		tglbtnDelete = new JToggleButton("Delete  ");
		tglbtnDelete.setEnabled(false);
		tglbtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {			
				controller.btnDeleteClicked(arg0);
			}
		});
		grupa.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Cambria Math", Font.BOLD, 18));
		toolBar.add(tglbtnDelete);
		
		btnToFront = new JButton("To Front");
		btnToFront.setEnabled(false);
		btnToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.toFront();
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(new Color(0, 51, 153));
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_3);
		btnToFront.setBackground(UIManager.getColor("Button.highlight"));
		btnToFront.setForeground(Color.BLACK);
		btnToFront.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(btnToFront);
		
		btnBringToFront = new JButton("Bring To Front");
		btnBringToFront.setEnabled(false);
		btnBringToFront.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringToFront();
			}
		});
		btnBringToFront.setBackground(UIManager.getColor("Button.highlight"));
		btnBringToFront.setForeground(Color.BLACK);
		btnBringToFront.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(btnBringToFront);
		
		btnToBack = new JButton("To Back");
		btnToBack.setEnabled(false);
		btnToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.toBack();
			}
		});
		btnToBack.setBackground(UIManager.getColor("Button.highlight"));
		btnToBack.setForeground(Color.BLACK);
		btnToBack.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(btnToBack);
		
		btnBringToBack = new JButton("Bring To Back");
		btnBringToBack.setEnabled(false);
		btnBringToBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bringToBack();
			}
		});
		btnBringToBack.setBackground(UIManager.getColor("Button.highlight"));
		btnBringToBack.setForeground(Color.BLACK);
		btnBringToBack.setFont(new Font("Cambria Math", Font.PLAIN, 18));
		toolBar.add(btnBringToBack);
		
		//scrollPane = new JScrollPane();		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(view, GroupLayout.DEFAULT_SIZE, 1658, Short.MAX_VALUE))
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, 1114, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1646, Short.MAX_VALUE)
							.addGap(12)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(view, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		GridBagLayout gbl_view = new GridBagLayout();
		gbl_view.columnWidths = new int[]{0};
		gbl_view.rowHeights = new int[]{0};
		gbl_view.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_view.rowWeights = new double[]{Double.MIN_VALUE};
		view.setLayout(gbl_view);
		
		//listLog = new JList();
		listLog.setFont(new Font("Cambria Math", Font.PLAIN, 14));
		scrollPane.setViewportView(listLog);
		getContentPane().setLayout(groupLayout);
		
		menuBar = new JMenuBar();
		menuBar.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		mnFile.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		menuBar.add(mnFile);
		
		mntmOpenDrawing = new JMenuItem("Open drawing");
		mntmOpenDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.openDrawing();
			}
		});
		mntmOpenDrawing.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		mnFile.add(mntmOpenDrawing);
		
		mntmSaveDrawing = new JMenuItem("Save drawing");
		mntmSaveDrawing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.saveDrawing();
			}
		});
		mntmSaveDrawing.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		mnFile.add(mntmSaveDrawing);
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		mntmOpenLog = new JMenuItem("Open log");
		mntmOpenLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.openLog();
			}
		});
		mntmOpenLog.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		mnFile.add(mntmOpenLog);
		
		mntmSaveLog = new JMenuItem("Save log");
		mntmSaveLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controller.saveLog();
			}
		});
		mntmSaveLog.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		mnFile.add(mntmSaveLog);
		
		separator_1 = new JSeparator();
		mnFile.add(separator_1);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		mnFile.add(mntmExit);
		
		toolBarPanel = new JPanel();
		menuBar.add(toolBarPanel);
		
		btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.undo();
			}
		});
		btnUndo.setBackground(Color.LIGHT_GRAY);
		btnUndo.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		btnUndo.setEnabled(false);
		
		btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.redo();
			}
		});
		btnRedo.setBackground(Color.LIGHT_GRAY);
		btnRedo.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		btnRedo.setEnabled(false);
		
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//controller.next();
			}
		});
		btnNext.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		btnNext.setBackground(Color.LIGHT_GRAY);
		
		//Fill color
		btnFillColor = new JButton("Fill color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnFillColor.setBackground(selectedColor(btnFillColor.getBackground()));
			}
		});
		btnFillColor.setBackground(Color.WHITE);
		btnFillColor.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		
		//Edge color
		btnEdgeColor = new JButton("Edge color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEdgeColor.setBackground(selectedColor(btnEdgeColor.getBackground()));
			}
		});
		btnEdgeColor.setBackground(Color.BLUE);
		btnEdgeColor.setFont(new Font("Cambria Math", Font.PLAIN, 16));
		
		GroupLayout gl_toolBarPanel = new GroupLayout(toolBarPanel);
		gl_toolBarPanel.setHorizontalGroup(
			gl_toolBarPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toolBarPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnUndo)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnRedo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnEdgeColor)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnFillColor)
					.addGap(527))
		);
		gl_toolBarPanel.setVerticalGroup(
			gl_toolBarPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toolBarPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_toolBarPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnUndo)
						.addComponent(btnRedo)
						.addComponent(btnEdgeColor)
						.addComponent(btnFillColor)
						.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		toolBarPanel.setLayout(gl_toolBarPanel);
		//view.add(toolBar, BorderLayout.NORTH);
			
	}

	//Choose a color
	public Color selectedColor(Color oldColor) {
		Color newColor = JColorChooser.showDialog(null, "Choose a color", oldColor);
		if (newColor != null)
			return newColor;
		else
			return oldColor;
	}

	public DrawingView getView() {
		return view;
	}

	public void setController(DrawingController controller) {
		this.controller = controller;
	}

	public boolean getTglbtnPoint() {
		return tglbtnPoint.isSelected();
	}

	public boolean getTglbtnLine() {
		return tglbtnLine.isSelected();
	}

	public boolean getTglbtnRectangle() {
		return tglbtnRectangle.isSelected();
	}

	public boolean getTglbtnCircle() {
		return tglbtnCircle.isSelected();
	}

	public boolean getTglbtnDonut() {
		return tglbtnDonut.isSelected();
	}

	public boolean getTglbtnSelect() {
		return tglbtnSelect.isSelected();
	}

	public JToggleButton getTglbtnModify() {
		return tglbtnModify;
	}
	
	public void setTglbtnModify(JToggleButton tglbtnModify) {
		this.tglbtnModify = tglbtnModify;
	}

	public JToggleButton getTglbtnDelete() {
		return tglbtnDelete;
	}

	public void setTglbtnDelete(JToggleButton tglbtnDelete) {
		this.tglbtnDelete = tglbtnDelete;
	}
	
	public boolean getTglbtnHexagon() {
		return tglbtnHexagon.isSelected();
	}
	
	public JButton getBtnUndo() {
		return btnUndo;
	}

	public void setBtnUndo(JButton btnUndo) {
		this.btnUndo = btnUndo;
	}

	public JButton getBtnRedo() {
		return btnRedo;
	}

	public void setBtnRedo(JButton btnRedo) {
		this.btnRedo = btnRedo;
	}
	
	public JButton getBtnNext() {
		return btnNext;
	}

	public void setBtnNext(JButton btnNext) {
		this.btnNext = btnNext;
	}
	
	public JButton getBtnEdgeColor() {
		return btnEdgeColor;
	}

	public void setBtnEdgeColor(JButton btnEdgeColor) {
		this.btnEdgeColor = btnEdgeColor;
	}

	public JButton getBtnFillColor() {
		return btnFillColor;
	}

	public void setBtnFillColor(JButton btnFillColor) {
		this.btnFillColor = btnFillColor;
	}
	
	public JButton getBtnToFront() {
		return btnToFront;
	}

	public void setBtnToFront(JButton btnToFront) {
		this.btnToFront = btnToFront;
	}

	public JButton getBtnBringToFront() {
		return btnBringToFront;
	}

	public void setBtnBringToFront(JButton btnBringToFront) {
		this.btnBringToFront = btnBringToFront;
	}

	public JButton getBtnToBack() {
		return btnToBack;
	}

	public void setBtnToBack(JButton btnToBack) {
		this.btnToBack = btnToBack;
	}

	public JButton getBtnBringToBack() {
		return btnBringToBack;
	}

	public void setBtnBringToBack(JButton btnBringToBack) {
		this.btnBringToBack = btnBringToBack;
	}
	
	public DefaultListModel<String> getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel<String> listModel) {
		this.listModel = listModel;
	}
	
}