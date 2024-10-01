package ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
public class VentanaAbrirApps extends JFrame implements ActionListener{
	
   private JButton wordButton;
   private JButton calcButton;
   private JButton notepadButton;
   private JButton firefoxButton;
   private JButton edgeButton;
   private JButton btnVolver;
   private JPanel buttonPanel;
   
   public VentanaAbrirApps() {
   	setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAbrirApps.class.getResource("/resources/small-computer.png")));
       setTitle("Launcher de Programas");
       setSize(866, 559);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLocationRelativeTo(null);
       getContentPane().setBackground(new Color(45, 45, 45));
       buttonPanel = new JPanel();
       buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));
       buttonPanel.setOpaque(false);
       wordButton = crearBoton("Abrir Word");
       notepadButton = crearBoton("Abrir Notepad");
       calcButton = crearBoton("Abrir Calculadora");
       firefoxButton = crearBoton("Abrir Firefox");
       edgeButton = crearBoton("Abrir Edge");
       btnVolver = crearBoton("Volver");
       buttonPanel.add(wordButton);
       buttonPanel.add(notepadButton);
       buttonPanel.add(calcButton);
       buttonPanel.add(firefoxButton);
       buttonPanel.add(edgeButton);
       buttonPanel.add(btnVolver);
       getContentPane().add(buttonPanel, BorderLayout.CENTER);
       wordButton.addActionListener(this);
       notepadButton.addActionListener(this);
       calcButton.addActionListener(this);
       firefoxButton.addActionListener(this);
       edgeButton.addActionListener(this);
       btnVolver.addActionListener(this);
   }
   private JButton crearBoton(String texto) {
       JButton boton = new JButton(texto);
       boton.setFont(new Font("Segoe UI", Font.BOLD, 16));
       boton.setBackground(new Color(70, 130, 180));
       boton.setForeground(Color.WHITE);
       boton.setFocusPainted(false);
       boton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
       boton.setPreferredSize(new Dimension(180, 45));
       boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
       return boton;
   }
   private void abrirPrograma(String programa) {
       File archivo = new File(programa);
       if (!archivo.exists() && !programa.endsWith(".exe")) {
           JOptionPane.showMessageDialog(this, "El programa no se encontró: " + programa, "Error", JOptionPane.ERROR_MESSAGE);
           return;
       }
       try {
           Runtime.getRuntime().exec(programa);
       } catch (IOException ex) {
           JOptionPane.showMessageDialog(this, "Error al ejecutar el programa: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
       }
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	if(e.getSource().equals(wordButton)) {
		abrirPrograma("C:/Program Files/LibreOffice/program/swriter.exe");
	}else if(e.getSource().equals(calcButton)) {
		abrirPrograma("calc.exe");
	}else if(e.getSource().equals(notepadButton)) {
		abrirPrograma("notepad.exe");
	}else if(e.getSource().equals(firefoxButton)) {
		abrirPrograma("C:/Program Files/Mozilla Firefox/firefox.exe");
	}else if(e.getSource().equals(edgeButton)) {
		abrirPrograma("C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe");
	}else if(e.getSource().equals(btnVolver)) {
		VentanaPrincipal vPrincipal = new VentanaPrincipal();
        vPrincipal.setVisible(true);
        this.dispose();
	}
	
   }
   
}

