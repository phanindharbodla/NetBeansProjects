/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pdf;

/**
 *
 * @author Phanindhar Bodla
 */
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class HelloWorld {

  public static void main(String[] args) throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\j1013563\\Documents\\NetBeansProjects\\Puzzlecode\\src\\com\\pdf\\output.pdf"));
    document.open();
    
    document.add(new Paragraph("Phanindhar Bodla"));
    document.add(new Paragraph("Nit Warangal    "));
    document.close();
  }
}