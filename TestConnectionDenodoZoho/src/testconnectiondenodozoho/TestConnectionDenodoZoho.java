package testconnectiondenodozoho;

import java.sql.SQLException;

public class TestConnectionDenodoZoho {

    public static void main(String[] args) throws SQLException {
                
        ReadFromDenodo rfd = new ReadFromDenodo();
        WriteToDenodo wtd = new WriteToDenodo();
        
        //rfd.Read("select * from client_with_bills where client_id like 'E%';");
        
        //wtd.Write("insert into client (client_id, name, surname, client_type) values ('E002','Prova','Test','2')");
        
        
        rfd.Read("select * from client_j_client_type where client_id like 'C00%';");
        
        wtd.Write("insert into client_j_client_type values ('03',  'Test',  'C666',  'Test',  'Test',  '01')");
        
        rfd.Read("select * from client_j_client_type where client_id like 'C00%';");
        
    }
    
}