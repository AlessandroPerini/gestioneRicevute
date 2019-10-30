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
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Alessandro
 */
public class Grafica {
    
    public static CardLayout card;
    public static JPanel container;
    public static MainFrame mainFrame;
    public static JPanel pannelloPrincipale, basso, alto, coppia;
    public static JLabel nome;
    public JTextArea testo;
    private JFileChooser fileChooser1, fileChooser2, fileChooser3;
    private String ricevuteTuttePath = new String(), bollettaPath = new String(), pagamentoPath = new String();
    private JButton scegliFile1, scegliFile2, scegliFile3, stampa;
    private FileManager fm;
    
    public Grafica(){
        
        mainFrame  = new MainFrame("Gestione PDF - Ricevute Bollette Acqua");        
        pannelloPrincipale = new JPanel(new GridLayout(2, 1)); 
        pannelloPrincipale.setBackground(Color.white);
        ricevuteTuttePath = new String();
       
        fileChooser1 = new JFileChooser();
        scegliFile1 = new JButton("Scegli il file Ricevute");
        fileChooser2 = new JFileChooser();
        scegliFile2 = new JButton("Scegli il file Bolletta");
        fileChooser3 = new JFileChooser();
        scegliFile3 = new JButton("Scegli il file Pagamento");
        scegliFile3.setBackground(Color.red);
        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int returnVal = fileChooser1.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    ricevuteTuttePath = fileChooser1.getSelectedFile().getAbsolutePath();
                }
            }
        };
        scegliFile1.addActionListener(al);            
        
        ActionListener al2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int returnVal2 = fileChooser2.showOpenDialog(null);
                if(returnVal2 == JFileChooser.APPROVE_OPTION){
                    bollettaPath = fileChooser2.getSelectedFile().getAbsolutePath();
                }
            }
        };
        scegliFile2.addActionListener(al2);
                
        ActionListener al3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int returnVal3 = fileChooser3.showOpenDialog(null);
                if(returnVal3 == JFileChooser.APPROVE_OPTION){
                    pagamentoPath = "";//fileChooser3.getSelectedFile().getAbsolutePath();
                }
            }
        };
        scegliFile3.addActionListener(al3);
                
        testo = new JTextArea();
                
        basso = new JPanel();
        alto = new JPanel();
        alto.setBackground(Color.blue);
        
        pannelloPrincipale.add(alto);
        pannelloPrincipale.add(basso);
        
        alto.add(scegliFile1);
        alto.add(scegliFile2);
        alto.add(scegliFile3);
        stampa = new JButton("Produci Ricevute Separate");
        stampa.setBackground(Color.green);
        alto.add(stampa);
        
        testo.setBackground(Color.white);
        basso.setBackground(Color.white);
        basso.add(testo);
        testo.setText("");
        
        mainFrame.add(pannelloPrincipale);
        mainFrame.setVisible(true);
        
        stampa.addActionListener((ae) -> {
            try {
                fm = new FileManager(ricevuteTuttePath, "2019.08.31", bollettaPath, pagamentoPath, testo);
            } catch (IOException ex) {
                String mancante = new String("");
                mancante = mancante +"";
                if(ricevuteTuttePath.isEmpty()) mancante = mancante +"'Ricevute'";
                if(bollettaPath.isEmpty()) mancante = mancante +", 'Bolletta'";
                //if(pagamentoPath.isEmpty()) mancante = mancante +", 'Pagamento'";
                testo.setText("Selezionare i seguenti pdf: "+mancante);
            }
        });
        
    }
    
    public void chiudi(){
        mainFrame.setVisible(false);
        mainFrame.dispose();
    }
}