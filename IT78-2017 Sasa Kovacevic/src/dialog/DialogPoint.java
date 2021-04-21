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
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class DialogPoint extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textX;
	private JTextField textY;
	private JButton btnColor;
	private boolean ok;
	private Color color;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogPoint dialog = new DialogPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogPoint() {
		setTitle("Point");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
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
		
		btnColor = new JButton("Color");
		btnColor.setBackground(Color.WHITE);
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				color = JColorChooser.showDialog(null, "Choose a color:", Color.BLACK);
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(55)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblX)
						.addComponent(lblY))
					.addGap(52)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textY)
						.addComponent(btnColor)
						.addComponent(textX))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblX)
						.addComponent(textX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblY)
						.addComponent(textY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnColor)
					.addContainerGap(62, Short.MAX_VALUE))
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
					public void actionPerformed(ActionEvent arg0) {
						if (textX.getText().isEmpty() || textY.getText().isEmpty()) {
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
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setTextXEdit(boolean b)
	{
		this.textX.setEditable(b);
	}
	
	public void setTextYEdit(boolean b)
	{
		this.textY.setEditable(b);
	}
	
	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

}