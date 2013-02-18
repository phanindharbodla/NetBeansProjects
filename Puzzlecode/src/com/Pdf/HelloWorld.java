/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pdf;

/**
 *
 * @author Phanindhar Bodla
 */
import com.lowagie.text.Chapter;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class HelloWorld {

  public static void main(String[] args) throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\j1013563\\Documents\\NetBeansProjects\\Puzzlecode\\src\\com\\pdf\\output.pdf"));
    document.open();
    document.add(new Chapter("\tUsage Of This Application ", 1));
    document.add(new Paragraph("\n\n    Whenever there is a need of auto documentation based on the test case generation , we can make use of this thing with a reccuring loop ."));
    document.add(new Paragraph("\n     So with every test case we can generate analysis automatically."));
    document.close();
  }
}