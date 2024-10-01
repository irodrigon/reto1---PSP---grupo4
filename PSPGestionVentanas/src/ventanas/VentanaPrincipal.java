package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblTitle;
	private JButton btnOption1;
	private JButton btnOption2;
	private JButton btnOption3;
	private JButton btnExit;

	
	public VentanaPrincipal(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/resources/small-computer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(new Color(70, 130, 180));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOption1 = new JButton("Opción 1: Abrir programas");
		btnOption1.setBounds(10, 110, 698, 45);
		btnOption1.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnOption1.setBackground(new Color(70, 130, 180));
	    btnOption1.setForeground(Color.WHITE);
	    btnOption1.setFocusPainted(false);
	    btnOption1.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnOption1.setPreferredSize(new Dimension(180, 45));
	    btnOption1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnOption1);
		
		btnOption2 = new JButton("Opción 2: Ping Machine");
		btnOption2.setBounds(10, 166, 698, 45);
		btnOption2.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnOption2.setBackground(new Color(70, 130, 180));
	    btnOption2.setForeground(Color.WHITE);
	    btnOption2.setFocusPainted(false);
	    btnOption2.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnOption2.setPreferredSize(new Dimension(180, 45));
	    btnOption2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnOption2);
		
		btnOption3 = new JButton("Opción 3: Lanzar comandos");
		btnOption3.setBounds(10, 222, 698, 45);
		btnOption3.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnOption3.setBackground(new Color(70, 130, 180));
	    btnOption3.setForeground(Color.WHITE);
	    btnOption3.setFocusPainted(false);
	    btnOption3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnOption3.setPreferredSize(new Dimension(180, 45));
	    btnOption3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnOption3);
		
		lblTitle = new JLabel("GESTIÓN DE VENTANAS PSP");
		lblTitle.setBounds(196, 23, 356, 45);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblTitle.setForeground(Color.WHITE);
		contentPane.add(lblTitle);
		
		btnExit = new JButton("Salir");
		btnExit.setBounds(10, 323, 698, 45);
		btnExit.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnExit.setBackground(new Color(70, 130, 180));
	    btnExit.setForeground(Color.WHITE);
	    btnExit.setFocusPainted(false);
	    btnExit.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnExit.setPreferredSize(new Dimension(180, 45));
	    btnExit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(btnExit);
		
		btnOption1.addActionListener(this);
		btnOption2.addActionListener(this);
		btnOption3.addActionListener(this);
		btnExit.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOption1)) {
			VentanaAbrirApps vAbrirApps = new VentanaAbrirApps();
			vAbrirApps.setVisible(true);
			this.dispose();
		}else if(e.getSource().equals(btnOption2)) {
			VentanaPing vPing = new VentanaPing();
			vPing.setVisible(true);
			this.dispose();
		}else if(e.getSource().equals(btnOption3)) {
			VentanaComando vComando = new VentanaComando();
			vComando.setVisible(true);
			this.dispose();
		}else if(e.getSource().equals(btnExit)) {
			this.dispose();
		}
		
	}
}
