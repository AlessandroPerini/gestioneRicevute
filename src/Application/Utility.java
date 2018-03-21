/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.File;

/**
 *
 * @author Alessandro
 */
public class Utility {

    void cancellaFile(String path) {
        try {
            File file = new File(path);
            if (file.delete()) {
                System.out.println(file.getName() + " è stato cancellato!");
            } else {
                System.out.println("Problema durante la cancellazione");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void creaDirectory(String nome) {
        File theDir = new File(nome);
        if (!theDir.exists()) {
            System.out.println("Creazione della cartella '" + theDir.getName()+"'...");
            boolean result = false;
            try {
                theDir.mkdir();
                result = true;
            } catch (SecurityException se) {
                //handle it
            }
            if (result) {
                System.out.println("Cartella creata!");
            }
        }
    }
    
}
