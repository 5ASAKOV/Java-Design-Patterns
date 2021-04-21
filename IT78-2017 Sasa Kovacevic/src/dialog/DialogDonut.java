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

public class DialogDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textX;
	private JTextField textY;
	private JTextField textInnerR;
	private JTextField textOuterR;
	private Color fillColor;
	private Color edgeColor;
	private boolean ok;
	private JButton btnEdgeColor;
	private JButton btnFillColor;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogDonut dialog = new DialogDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogDonut() {
		setBounds(100, 100, 600, 420);
		setTitle("Donut");
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
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
		
		JLabel lblRadius = new JLabel("Radiuses");
		lblRadius.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblInnerR = new JLabel("Inner radius");
		lblInnerR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblOuterR = new JLabel("Outer radius");
		lblOuterR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		textInnerR = new JTextField();
		textInnerR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textInnerR.setColumns(10);
		
		textInnerR.addKeyListener(new KeyAdapter() {
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
		
		textOuterR = new JTextField();
		textOuterR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textOuterR.setColumns(10);
		
		textOuterR.addKeyListener(new KeyAdapter() {
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
			public void actionPerformed(ActionEvent e) {
				
				fillColor=JColorChooser.showDialog(null, "Choose a color", Color.WHITE);
			}
		});
		
		btnEdgeColor = new JButton("Edge Color");
		btnEdgeColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEdgeColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edgeColor=JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblRadius, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblX, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lblY, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lblOuterR, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInnerR, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(textInnerR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textOuterR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
											.addGap(49)
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnEdgeColor)
												.addComponent(btnFillColor))))
									.addContainerGap(72, Short.MAX_VALUE))))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblCenter)
							.addContainerGap(479, Short.MAX_VALUE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(31)
					.addComponent(lblCenter)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(43)
					.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerR, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(textInnerR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnFillColor))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOuterR, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(textOuterR, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnEdgeColor)))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(0, 0, 102));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (textX.getText().isEmpty() ||
								textY.getText().isEmpty() ||
								textInnerR.getText().isEmpty() || textOuterR.getText().isEmpty()) {
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
	public Color getFillColor() {
		return fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor =edgeColor;
	}

	public void setTextXEditable(boolean b)
	{
		this.textX.setEditable(b);
	}
	
	public void setTextYEditable(boolean b)
	{
		this.textY.setEditable(b);
	}
	
	public void setTextInnerREditable(boolean b)
	{
		this.textInnerR.setEditable(b);
	}
	
	public void setTextOuterREditable(boolean b)
	{
		this.textOuterR.setEditable(b);
	}
	

	public String getTextInnerR() {
		return textInnerR.getText();
	}

	public void setTextInnerR(String textInnerR) {
		this.textInnerR.setText(textInnerR);
	}

	public String getTextOuterR() {
		return textOuterR.getText();
	}

	public void setTextOuterR(String textOuterR) {
		this.textOuterR.setText(textOuterR);
	}

	public String getTextX() {
		return textX.getText();
	}

	public void setTextX(String textX) {
		this.textX.setText(textX);
	}

	public String getTextY() {
		return textY.getText();
	}

	public void setTextY(String textY) {
		this.textY.setText(textY);
	}
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
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