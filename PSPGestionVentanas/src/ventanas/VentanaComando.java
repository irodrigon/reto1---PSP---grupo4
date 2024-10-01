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
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class VentanaComando extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldCommand;
    private JLabel lblTitle;
    private JLabel lblCommand;
    private JButton btnExecute;
    private JButton btnVolver;

    public VentanaComando() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaComando.class.getResource("/resources/small-computer.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 755, 440);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(new Color(70, 130, 180));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblTitle = new JLabel("COMMAND EXECUTOR:");
        lblTitle.setBounds(233, 43, 286, 24);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblTitle.setForeground(Color.WHITE);
        contentPane.add(lblTitle);
        
        lblCommand = new JLabel("Introduce el comando a ejecutar:");
        lblCommand.setBounds(65, 101, 276, 25);
        lblCommand.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblCommand.setForeground(Color.WHITE);
        contentPane.add(lblCommand);
        
        textFieldCommand = new JTextField();
        textFieldCommand.setBounds(351, 96, 303, 30);
        contentPane.add(textFieldCommand);
        textFieldCommand.setColumns(10);
        
        btnExecute = new JButton("Ejecutar");
        btnExecute.setBounds(65, 172, 589, 36);
        btnExecute.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnExecute.setBackground(new Color(70, 130, 180));
	    btnExecute.setForeground(Color.WHITE);
	    btnExecute.setFocusPainted(false);
	    btnExecute.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnExecute.setPreferredSize(new Dimension(180, 45));
	    btnExecute.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(btnExecute);
        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(65, 243, 589, 36);
        btnVolver.setFont(new Font("Segoe UI", Font.BOLD, 16));
	    btnVolver.setBackground(new Color(70, 130, 180));
	    btnVolver.setForeground(Color.WHITE);
	    btnVolver.setFocusPainted(false);
	    btnVolver.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	    btnVolver.setPreferredSize(new Dimension(180, 45));
	    btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));
        contentPane.add(btnVolver);
        
        btnExecute.addActionListener(this);
        btnVolver.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnExecute)) {
            try {
                String command = textFieldCommand.getText();
                if (!command.isEmpty()) {
                    // Abrir una nueva ventana de cmd y ejecutar el comando introducido
                    ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "start", "cmd", "/k", command);
                    builder.start();
                } else {
                    System.out.println("Por favor, introduce un comando.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (e.getSource().equals(btnVolver)) {
            VentanaPrincipal vPrincipal = new VentanaPrincipal();
            vPrincipal.setVisible(true);
            this.dispose();
        }
    }
}