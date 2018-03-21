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
    private JFileChooser fileChooser1, fileChooser2, fileChooser3;
    private String ricevuteTuttePath, bollettaPath, pagamentoPath;
    private JButton scegliFile1, scegliFile2, scegliFile3, stampa;
    private FileManager fm;
    
    public Grafica(){
        
        mainFrame  = new MainFrame("Gestione PDF - Ricevute Bollette Acqua");        
        pannelloPrincipale = new JPanel(new GridLayout(2, 1)); pannelloPrincipale.setBackground(Color.white);
        ricevuteTuttePath = new String();
       
        fileChooser1 = new JFileChooser();
        scegliFile1 = new JButton("Scegli il file Ricevute");
        fileChooser2 = new JFileChooser();
        scegliFile2 = new JButton("Scegli il file Bolletta");
        fileChooser3 = new JFileChooser();
        scegliFile3 = new JButton("Scegli il file Pagamento");
        
        scegliFile1.addActionListener((ActionEvent e) -> {
            fileChooser1.showOpenDialog(null);
            ricevuteTuttePath = fileChooser1.getSelectedFile().getAbsolutePath();
        });
        scegliFile2.addActionListener((ActionEvent e) -> {
            fileChooser2.showOpenDialog(null);
            bollettaPath = fileChooser2.getSelectedFile().getAbsolutePath();
        });
        scegliFile3.addActionListener((ActionEvent e) -> {
            fileChooser3.showOpenDialog(null);
            pagamentoPath = fileChooser3.getSelectedFile().getAbsolutePath();
        });
        
        stampa = new JButton("Produci Ricevute Separate");
        stampa.setBackground(Color.green);
        stampa.addActionListener((ae) -> {
            try {
                fm = new FileManager(ricevuteTuttePath, "2018.03.21", bollettaPath, pagamentoPath);
            } catch (IOException ex) {
                Logger.getLogger(Grafica.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        alto = new JPanel();
        alto.setBackground(Color.lightGray);
        basso = new JPanel();
        basso.setBackground(Color.blue);
        pannelloPrincipale.add(alto);
        pannelloPrincipale.add(basso);
        
        basso.add(scegliFile1);
        basso.add(scegliFile2);
        basso.add(scegliFile3);
        basso.add(stampa);
        
        mainFrame.add(pannelloPrincipale);
        mainFrame.setVisible(true);
    }
    
    public void chiudi(){
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }
}