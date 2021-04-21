package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DialogLine extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textStartX;
	private JTextField textStartY;
	private JTextField textEndX;
	private JTextField textEndY;
	private JButton btnColor;
	private boolean ok;
	private Color col;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogLine dialog = new DialogLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogLine() {
		setTitle("Line");
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblStartPoint = new JLabel("Start point");
		lblStartPoint.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblStartX = new JLabel("X coordinate");
		lblStartX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblStartY = new JLabel("Y coordinate");
		lblStartY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEndPoint = new JLabel("End point");
		lblEndPoint.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblEndX = new JLabel("X coordinate");
		lblEndX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblEndY = new JLabel("Y coordinate");
		lblEndY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textStartX = new JTextField();
		textStartX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textStartX.setColumns(10);
		
		textStartX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textStartY = new JTextField();
		textStartY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textStartY.setColumns(10);
		
		textStartY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textEndX = new JTextField();
		textEndX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textEndX.setColumns(10);
		
		textEndX.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		textEndY = new JTextField();
		textEndY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textEndY.setColumns(10);
		
		textEndY.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') ||
						(c == KeyEvent.VK_BACK_SPACE) ||
						(c == KeyEvent.VK_DELETE))) {
					e.consume();
					getToolkit().beep();
				}
			}
		});
		
		btnColor = new JButton("Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				col = JColorChooser.showDialog(null, "Choose a color", null);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblStartPoint)
							.addContainerGap())
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(21)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblStartX, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblStartY, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(lblEndY, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
										.addGap(5))
									.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
										.addComponent(lblEndX, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
										.addGap(17))))
							.addGap(97)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textEndX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnColor)
								.addComponent(textStartY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(151))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblEndPoint, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(22)
					.addComponent(lblStartPoint)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartX)
						.addComponent(textStartX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textStartY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStartY))
					.addGap(34)
					.addComponent(lblEndPoint, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEndX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndX))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEndY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndY))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(btnColor)
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 102));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Color.WHITE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						if (textStartX.getText().isEmpty() || textStartY.getText().isEmpty() || textEndX.getText().isEmpty() || textEndY.getText().isEmpty())  {
							ok = false;
							setVisible(true);
							JOptionPane.showMessageDialog(new JFrame(),"Inavlid input. All fields must be filled.", "Error!", JOptionPane.ERROR_MESSAGE);
						} else {
							ok = true;
							dispose();
						}
						
					}					
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
			
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public String getTextStartX() {
		return textStartX.getText();
	}

	public void setTextStartX(String textStartX) {
		this.textStartX.setText(textStartX);
	}

	public String getTextStartY() {
		return textStartY.getText();
	}

	public void setTextStartY(String textStartY) {
		this.textStartY.setText(textStartY);
	}

	public String getTextEndX() {
		return textEndX.getText();
	}

	public void setTextEndX(String textEndX) {
		this.textEndX.setText(textEndX);
	}

	public String getTextEndY() {
		return textEndY.getText();
	}

	public void setTextEndY(String textEndY) {
		this.textEndY.setText(textEndY);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Color getCol() {
		return col;
	}

	public void setCol(Color col) {
		this.col = col;
	}
	
	public void setTextStartXEdit(boolean b)
	{
		this.textStartX.setEditable(b);
	}
	
	public void setTextStartYEdit(boolean b)
	{
		this.textStartY.setEditable(b);
	}
	
	public void setTextEndXEdit(boolean b)
	{
		this.textEndX.setEditable(b);
	}
	
	public void setTextEndYEdit(boolean b)
	{
		this.textEndY.setEditable(b);
	}
	
	
	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

}
