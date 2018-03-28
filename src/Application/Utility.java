/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.File;
import javax.swing.JTextArea;

/**
 *
 * @author Alessandro
 */
public class Utility {

    public JTextArea testo;
    
    void cancellaFile(String path, JTextArea t) {
        this.testo = t;
        try {
            File file = new File(path);
            if (file.delete()) {
                testo.setText(testo.getText()+"\n"+file.getName() + " è stato cancellato!");
            } else {
                testo.setText(testo.getText()+"\nProblema durante la cancellazione");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void creaDirectory(String nome, JTextArea t) {
        this.testo = t;
        File theDir = new File(nome);
        if (!theDir.exists()) {
            testo.setText(testo.getText()+"\nCreazione della cartella '" + theDir.getName()+"'...");
            boolean result = false;
            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                testo.setText(testo.getText()+"\nCartella creata!");
            }
        }
    }
    
}
