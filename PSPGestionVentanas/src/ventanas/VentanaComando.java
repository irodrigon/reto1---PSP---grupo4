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
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblTitle = new JLabel("COMMAND EXECUTOR:");
        lblTitle.setBounds(298, 44, 200, 24);
        contentPane.add(lblTitle);
        
        lblCommand = new JLabel("Introduce el comando a ejecutar:");
        lblCommand.setBounds(65, 101, 210, 14);
        contentPane.add(lblCommand);
        
        textFieldCommand = new JTextField();
        textFieldCommand.setBounds(454, 98, 200, 20);
        contentPane.add(textFieldCommand);
        textFieldCommand.setColumns(10);
        
        btnExecute = new JButton("Ejecutar");
        btnExecute.setBounds(328, 163, 89, 23);
        contentPane.add(btnExecute);
        
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(328, 256, 89, 23);
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
