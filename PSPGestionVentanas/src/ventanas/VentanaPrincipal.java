package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnOption1 = new JButton("Opción 1: Abrir programas");
		btnOption1.setBounds(272, 152, 208, 23);
		contentPane.add(btnOption1);
		
		btnOption2 = new JButton("Opción 2: Ping Machine");
		btnOption2.setBounds(272, 199, 208, 23);
		contentPane.add(btnOption2);
		
		btnOption3 = new JButton("Opción 3: Lanzar comandos");
		btnOption3.setBounds(272, 244, 208, 23);
		contentPane.add(btnOption3);
		
		lblTitle = new JLabel("GESTIÓN DE VENTANAS PSP");
		lblTitle.setBounds(214, 85, 326, 14);
		lblTitle.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(lblTitle);
		
		btnExit = new JButton("Salir");
		btnExit.setBounds(272, 304, 208, 23);
		contentPane.add(btnExit);
		
		btnOption1.addActionListener(this);
		btnOption2.addActionListener(this);
		btnOption3.addActionListener(this);
		btnExit.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnOption1)) {
			
		}else if(e.getSource().equals(btnOption2)) {
			VentanaPing vPing = new VentanaPing();
			vPing.setVisible(true);
			this.dispose();
		}else if(e.getSource().equals(btnOption3)) {
			
		}else if(e.getSource().equals(btnExit)) {
			this.dispose();
		}
		
	}
}
