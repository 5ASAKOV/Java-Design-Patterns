package dialog;

import java.awt.BorderLayout;
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
import java.awt.Color;

public class DialogRectangle extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textXcor;
	private JTextField textYcor;
	private JTextField textHeight;
	private JTextField textWidth;
	JLabel lblInsert;
	private boolean ok;
	private Color fillColor;
	private Color edgeColor;
	private JButton btnEdgeColor;
	private JButton btnFillColor;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogRectangle dlg = new DialogRectangle();
			dlg.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dlg.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogRectangle() {
		setTitle("Rectangle");
		setBounds(100, 100, 550, 370);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblX = new JLabel("X coordinate:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblY = new JLabel("Y coordinate:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		lblInsert = new JLabel("Fill the following fields:");
		lblInsert.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textXcor = new JTextField();
		textXcor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textXcor.setColumns(10);
		
		textXcor.addKeyListener(new KeyAdapter() {
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
		
		textYcor = new JTextField();
		textYcor.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textYcor.setColumns(10);
		
		textYcor.addKeyListener(new KeyAdapter() {
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
		
		textHeight = new JTextField();
		textHeight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textHeight.setColumns(10);
		
		textHeight.addKeyListener(new KeyAdapter() {
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
		
		textWidth = new JTextField();
		textWidth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textWidth.setColumns(10);
		
		textWidth.addKeyListener(new KeyAdapter() {
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
		
		btnFillColor = new JButton("Fill Color");
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fillColor=JColorChooser.showDialog(null, "Choose a color", null);
			}
		});
		btnFillColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor=JColorChooser.showDialog(null, "Choose a color", null);
			}
		});
		btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(53)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInsert)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblX)
								.addComponent(lblY)
								.addComponent(lblHeight)
								.addComponent(lblWidth))
							.addGap(65)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textXcor)
								.addComponent(textWidth, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addComponent(textHeight, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addComponent(textYcor, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(btnFillColor)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnEdgeColor)))))
					.addContainerGap(131, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblInsert)
							.addGap(28)
							.addComponent(lblX))
						.addComponent(textXcor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblY)
						.addComponent(textYcor, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(textHeight, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(textWidth, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnFillColor)
						.addComponent(btnEdgeColor))
					.addGap(32))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 102));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				okButton.setBackground(Color.WHITE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textXcor.getText().isEmpty() ||
								textYcor.getText().isEmpty() ||
								textHeight.getText().isEmpty() || textWidth.getText().isEmpty()) {
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
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.WHITE);
				cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ok=false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}
	
	public void setLblInsert(String lblInsert) {
		this.lblInsert.setText(lblInsert);
	}

	public void setTextHeight(String textHeight) {
		this.textHeight.setText(textHeight);
	}

	public void setTextWidth(String textWidth) {
		this.textWidth.setText(textWidth);
	}

	public String getTextXcor() {
		return textXcor.getText();
	}

	public void setTextXcor(String textXcor) {
		this.textXcor.setText(textXcor);
	}

	public String getTextYcor() {
		return textYcor.getText();
	}

	public void setTextYcor(String textYcor) {
		this.textYcor.setText(textYcor);
	}

	public String getTextHeight() {
		return textHeight.getText();
	}

	public String getTextWidth() {
		return textWidth.getText();
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public void setTextXcorEditable(boolean b)
	{
		this.textXcor.setEditable(b);
	}
	
	public void setTextYcorEditable(boolean b)
	{
		this.textYcor.setEditable(b);
	}
	
	public void setTextHeightEditable(boolean b)
	{
		this.textHeight.setEditable(b);
	}
	
	public void setTextWidthEditable(boolean b)
	{
		this.textWidth.setEditable(b);
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
}