/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.File;
import java.io.IOException;
import javax.swing.JTextArea;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author Alessandro
 */


public class FileManager {
    
    private Utility utility = new Utility();
    public JTextArea testo;
    private PDDocument ricevuteTutte,tempPDFDoc;
    private File bolletta, pagamento, tempFile;
    private PDFMergerUtility merge;
    private String data;
    private String[] nomiFile = {   "Predretti","Tamburelli","Lombardi","Lambri","Fracassi","Cerra","Bergamaschi",
                                    "Scolari","Pavone","Carbone","Rossi","Bardi","Pozzi","Canato",
                                    "Lenoci","Magnaghi","Stasolla","Portale","Gandini","Groppaldi","La Bella"};
    
    public FileManager(String ricevuteTutte, String data, String bollettaPath, String pagamentoPath, JTextArea t) throws IOException {
        this.ricevuteTutte = PDDocument.load(new File(ricevuteTutte));
        this.bolletta = new File(bollettaPath);
        this.pagamento = new File(pagamentoPath);
        this.data = data;
        this.testo = t;
        print();
    }
    
    private void print() throws IOException{
        
        String nomeDir = new String("C:/Users/Alessandro/Desktop/Ricevute");
        utility.creaDirectory(nomeDir, testo);
        
        for (int i = 0; i < ricevuteTutte.getNumberOfPages(); i++) {
                        
            tempPDFDoc = new PDDocument();            
            tempPDFDoc.addPage(ricevuteTutte.getPage(i));
                    
            this.tempFile = new File("C:/Users/Alessandro/Desktop/Ricevute/temp.pdf");
            tempPDFDoc.save(tempFile);
            
            merge = new PDFMergerUtility();
            merge.setDestinationFileName("C:/Users/Alessandro/Desktop/Ricevute/"+"Ricevuta Acqua "+data+" - Famiglia "+nomiFile[i]+".pdf");
            
            merge.addSource(tempFile);
            merge.addSource(bolletta);
            //merge.addSource(pagamento);
            merge.mergeDocuments();
           
            tempPDFDoc.close();
        }
        
        utility.cancellaFile(tempFile.getAbsolutePath(),testo);
        testo.setText(testo.getText()+"\nRicevute Pronte!");
        ricevuteTutte.close();
        
    }
}
