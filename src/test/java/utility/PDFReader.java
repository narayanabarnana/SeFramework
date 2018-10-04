package utility;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PDFReader {

    public static void main(String[] args) throws IOException {
    	
    	//Loading an existing document
        File file = new File("C:\\Users\\Nbarnana\\Desktop\\143526_2018.pdf");
        
        PDDocument document = PDDocument.load(file);
        
      //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();
        
        HashMap<String , String> hm=new HashMap<String, String>();
        
      //Retrieving text from PDF document
        String text = pdfStripper.getText(document);
        //System.out.println(pdfStripper.hashCode());
        //pdfStripper.
        //System.out.println(hm.put("", text));
      //Getting the PDDocumentInformation object
        PDDocumentInformation pdd = document.getDocumentInformation();
        System.out.println("Keywords of the document are :"+ pdd.getKeywords());
        System.out.println(text);
        
        //ExcelDataConfig EDC = new ExcelDataConfig("C:\\Users\\Nbarnana\\Desktop\\PDF Comparison.xlsx");
        //ExcelDataConfig EDC=new ExcelDataConfig("C:\\Users\\Nbarnana\\Desktop\\PDFComparison.xlsx");
        //String test=EDC.getCellData("Sheet1", "PlanNumber", 2);
        //Closing the document
        document.close();

        
}
}

 
	


