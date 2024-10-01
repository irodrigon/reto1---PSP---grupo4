package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VentanaPing extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldAddress;
	private JLabel lblTitle;
	private JLabel lblAddress;
	private JButton btnPing;
	private JButton btnVolver;

	public VentanaPing() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPing.class.getResource("/resources/small-computer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(70, 130, 180));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("PING MACHINE:");
		lblTitle.setBounds(298, 44, 200, 24);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblTitle.setForeground(Color.WHITE);
		contentPane.add(lblTitle);
		
		lblAddress = new JLabel("Introduce la IP o dirección Web:");
		lblAddress.setBounds(10, 98, 357, 41);
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblAddress.setForeground(Color.WHITE);
		contentPane.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(327, 98, 381, 41);
		textFieldAddress.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		btnPing = new JButton("PING!");
		btnPing.setBounds(10, 194, 698, 45);
		btnPing.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnPing.setBackground(new Color(70, 130, 180));
	    btnPing.setForeground(Color.WHITE);
	    btnPing.setFocusPainted(false);
	    btnPing.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnPing.setPreferredSize(new Dimension(180, 45));
	    btnPing.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnPing);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(10, 261, 698, 45);
		btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnVolver.setBackground(new Color(70, 130, 180));
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setFocusPainted(false);
	    btnVolver.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnVolver.setPreferredSize(new Dimension(180, 45));
	    btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnVolver);
		
		btnPing.addActionListener(this);
		btnVolver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnPing)) {
			if(textFieldAddress.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "No has introducido ningún valor.", "Error", JOptionPane.ERROR_MESSAGE);
			}else {
				try {
					ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c","start","cmd","/c","ping",textFieldAddress.getText());
					builder.start();
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		}else if(e.getSource().equals(btnVolver)) {
			VentanaPrincipal vPrincipal = new VentanaPrincipal();
			vPrincipal.setVisible(true);
			this.dispose();
		}
		
	}
}
