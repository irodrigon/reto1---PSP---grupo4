package ventanas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("PING MACHINE:");
		lblTitle.setBounds(298, 44, 200, 24);
		contentPane.add(lblTitle);
		
		lblAddress = new JLabel("Introduce la IP o dirección Web:");
		lblAddress.setBounds(65, 101, 210, 14);
		contentPane.add(lblAddress);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(454, 98, 200, 20);
		contentPane.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		btnPing = new JButton("PING!");
		btnPing.setBounds(328, 163, 89, 23);
		contentPane.add(btnPing);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(328, 256, 89, 23);
		contentPane.add(btnVolver);
		
		btnPing.addActionListener(this);
		btnVolver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnPing)) {
			try {
				ProcessBuilder builder = new ProcessBuilder("cmd.exe","/c","start","cmd","/c","ping",textFieldAddress.getText());
				builder.start();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}else if(e.getSource().equals(btnVolver)) {
			VentanaPrincipal vPrincipal = new VentanaPrincipal();
			vPrincipal.setVisible(true);
			this.dispose();
		}
		
	}
}
