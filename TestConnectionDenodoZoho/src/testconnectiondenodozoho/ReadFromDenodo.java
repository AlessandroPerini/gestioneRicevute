/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testconnectiondenodozoho;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.*; 
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author a.perini
 */
public class ReadFromDenodo {
    
    public Boolean Read(String query){
        String url = "jdbc:vdb://localhost:9999/tutorial"; 
        String user = "admin";
        String pass = "admin";
       
        Boolean result = false;
    
        try {
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement(); 
            Boolean ok = st.execute(query); 
            if (ok) {
                ResultSet resultset = st.getResultSet();
                ArrayList<String> arrayList = new ArrayList<String>(); 
                int columnsNumber = resultset.getMetaData().getColumnCount();
                //System.out.print(resultset.getMetaData().getColumnName(1)+"\n___________________________________\n");
                while (resultset.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultset.getString(i);
                        System.out.print(columnValue);
                    }
                }
                result = true;
            }
            else
                System.out.println("Query failed"); 
                result = false;

            con.close(); 
        } catch (SQLException ex) {
            System.out.print("Errore durante la connessione con il database\n\n");
            Logger.getLogger(ReadFromDenodo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
}
