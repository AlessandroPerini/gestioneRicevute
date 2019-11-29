/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testconnectiondenodozoho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a.perini
 */
public class WriteToDenodo {
    
        public Boolean Write(String query){
            String url = "jdbc:vdb://localhost:9999/tutorial"; 
            String user = "admin";
            String pass = "admin";

            Boolean result = false;

            try {
                Connection con = DriverManager.getConnection(url,user,pass);
                Statement st = con.createStatement(); 
                Boolean errors = st.execute(query); 
                if (!errors) {
                    result = true;
                    System.out.print("Dati inseriti correttamente\n\n");
                }
                else System.out.println("Query failed");
                con.close();
            } catch (SQLException ex) {
                System.out.print("Errore durante la connessione con il database:\n\n- "+ex);
                Logger.getLogger(ReadFromDenodo.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result;
        }
    
}
