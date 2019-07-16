package com.qweeby.download;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class MangeQrCode {
	
	
	
	public void insert(String pathQrCode, String pathPdf, String pathPdfOut) throws Exception{
		
		try { 
		PdfReader reader = new PdfReader(pathPdf);
		    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(pathPdfOut));
		    Image img = Image.getInstance(pathQrCode);
		    img.setAbsolutePosition(0, 600);
		    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
		    PdfContentByte under, over;
		    int total = reader.getNumberOfPages() + 1;
		    //for (int i = 1; i < total; i++) {
		      stamper.setRotateContents(false);
		      under = stamper.getUnderContent(1);
		      under.addImage(img);
		      stamper.close();
		      System.out.println("Insertion dans le document PDF ");
		}
		catch(Exception e){
			
		}
		   
		
		
	}
	 
	public void create(String qrCodeData, String filePath){
		   try {
	           // String qrCodeData = "bghgfhghgfhfghfdgfdgfdgf";
	           // String filePath = "C:/pdf/img4.png";
	            String charset = "UTF-8"; // or "ISO-8859-1"
	            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
	            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
	            BitMatrix matrix = new MultiFormatWriter().encode(
	                new String(qrCodeData.getBytes(charset), charset),
	                BarcodeFormat.QR_CODE, 150, 150, hintMap);
	            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
	                .lastIndexOf('.') + 1), new File(filePath));
	            System.out.println("Création de QR CODE ");
	        } catch (Exception e) {
	            System.err.println(e);
	        }
		
	}

}
