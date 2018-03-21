/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alessandro
 */
public class Grafica {
    
    public static CardLayout card;
    public static JPanel container;
    public static MainFrame mainFrame;
    public static JPanel pannelloPrincipale, alto, basso, coppia;
    public static JLabel nome;
    private JFileChooser fileChooser;
    private String ricevuteTutte, bolletta, pagamento;
    private JButton scegliFile, stampa;
    
    private FileManager fm;
    
    
    public Grafica(){
        
        mainFrame  = new MainFrame("Gestione PDF");        
        pannelloPrincipale = new JPanel(new GridLayout(2, 1)); pannelloPrincipale.setBackground(Color.white);
        
        alto = new JPanel();
        basso = new JPanel();
        
        fileChooser = new JFileChooser();
        scegliFile = new JButton("Scegli il file Ricevute");
        ricevuteTutte = new String();
        
        pannelloPrincipale.add(alto);
        pannelloPrincipale.add(basso);
        
       
        
        scegliFile.addActionListener((ActionEvent e) -> {
            fileChooser.showOpenDialog(null);
            ricevuteTutte = fileChooser.getSelectedFile().getAbsolutePath();
        });
        stampa = new JButton("Produci Ricevute Separate");
        stampa.addActionListener((ae) -> {
            try {
                fm = new FileManager(ricevuteTutte, "2018.03.21");
            } catch (IOException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        basso.add(scegliFile);
        basso.add(stampa);
                
        mainFrame.add(pannelloPrincipale);
        mainFrame.setVisible(true);
        
        
    }
    
    public void chiudi(){
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }
}