package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DialogCircle extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textRadius;
	private JTextField textY;
	private JTextField textX;
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
			DialogCircle dialog = new DialogCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogCircle() {
		setTitle("Circle");
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(new BorderLayout());
	    setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblRadius = new JLabel("Radius");
		lblRadius.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		textRadius = new JTextField();
		textRadius.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textRadius.setColumns(10);
		
		textRadius.addKeyListener(new KeyAdapter() {
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
		
		JLabel lblCenter = new JLabel("Center");
		lblCenter.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblX = new JLabel("X coordinate");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblY = new JLabel("Y coordinate");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textX = new JTextField();
		textX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textX.setColumns(10);
		
		textX.addKeyListener(new KeyAdapter() {
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
		
		textY = new JTextField();
		textY.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textY.setColumns(10);
		
		textY.addKeyListener(new KeyAdapter() {
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
		btnFillColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFillColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 fillColor = JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
				 
			}
		});
		
		btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				edgeColor = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCenter, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblRadius)
									.addGap(64))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textX, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(btnFillColor)
									.addGap(30)
									.addComponent(btnEdgeColor))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(textRadius, Alignment.LEADING)
									.addComponent(textY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
						.addComponent(lblX))
					.addContainerGap(157, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(52)
					.addComponent(lblCenter, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(textRadius, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnFillColor)
						.addComponent(btnEdgeColor))
					.addGap(24))
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
					public void actionPerformed(ActionEvent e)
					{
						if (textX.getText().isEmpty() || textY.getText().isEmpty() || textRadius.getText().isEmpty()) {
							ok = false;
							setVisible(true);
							JOptionPane.showMessageDialog(contentPanel, "Inavlid input. All fields must be filled.", "Error!", JOptionPane.WARNING_MESSAGE);
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

	public String getTextY() {
		return textY.getText();
	}

	public void setTextY(String textY) {
		this.textY.setText(textY);
	}

	public String getTextX() {
		return textX.getText();
	}

	public void setTextX(String textX) {
		this.textX.setText(textX);
	}
	
	public void setTextXEdit(boolean b)
	{
		this.textX.setEditable(b);
	}
	
	public void setTextYEdit(boolean b)
	{
		this.textY.setEditable(b);
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public String getTextRadius() {
		return textRadius.getText();
	}

	public void setTextRadius(String textField) {
		this.textRadius.setText(textField);
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
