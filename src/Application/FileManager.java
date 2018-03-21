/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Alessandro
 */


public class FileManager {
    
    private Utility utility = new Utility();
    private PDDocument ricevuteTutte;
    private File bolletta, pagamento, tempFile;
    private PDDocument tempPDFDoc;
    private PDFMergerUtility merge;
    private String data, bollettaPath, ricevutaPath;
    private String[] nomiFile = {   "Predretti","Tamburelli","Lombardi","Lambri","Fracassi","Cominato","Bergamaschi",
                                    "Scolari","Pavone","Carbone","Rossi","Bardi","Pozzi","Canato",
                                    "Lenoci","Magnaghi","Stasolla","Portale","Gandini","Groppaldi","La Bella"};
    
    public FileManager(String ricevuteTutte, String data) throws IOException {
        this.ricevuteTutte = PDDocument.load(new File(ricevuteTutte));
        //this.bollettaPath
        this.data = data;
        print();
    }
    
    private void print() throws IOException{
        
        String nomeDir = new String("C:/Users/Alessandro/Desktop/Ricevute");
        utility.creaDirectory(nomeDir);
        
        for (int i = 0; i < ricevuteTutte.getNumberOfPages(); i++) {
            
            bolletta = new File("C:/Users//Alessandro/Desktop/bolletta.pdf");
            pagamento = new File("C:/Users/Alessandro/Desktop/pagamento.pdf");
            
            tempPDFDoc = new PDDocument();            
            tempPDFDoc.addPage(ricevuteTutte.getPage(i));
                    
            this.tempFile = new File("C:\\Users\\Alessandro\\Desktop\\Ricevute\\temp.pdf");
            tempPDFDoc.save(tempFile);
            
            merge = new PDFMergerUtility();
            
            merge.setDestinationFileName("C:/Users/Alessandro/Desktop/Ricevute/"+"Ricevuta Acqua "+data+" - Famiglia "+nomiFile[i]+".pdf");
            
            merge.addSource(tempFile);
            merge.addSource(bolletta);
            merge.addSource(pagamento);
            
            merge.mergeDocuments();
           
            tempPDFDoc.close();
            
        }
        
        utility.cancellaFile(tempFile.getAbsolutePath());
        System.out.println("Ricevute Pronte!");
        ricevuteTutte.close();
        
    }
    
    
}
