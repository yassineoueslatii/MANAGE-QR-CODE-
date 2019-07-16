package com.qweeby.download;




public class MainClass {
	
	
	
	static String pathPdf ="C:/pdf/pdf.pdf";
	static String pathPdfOUt ="C:/pdf/pdf2.pdf";
	static String pathQrCode ="C:/pdf/img5.png";
	static String qrCodeData= "bghgfhghgfhfghfdgfdgfdgf";
	static int success= -99;
	public static void main(String[] args){
		
		MangeQrCode manageQr = new MangeQrCode();
		try {
			//manageQr.insert(pathQrCode, pathPdf, pathPdfOUt);
			//System.out.println("Le Qr code est bien ajouté");
			
			manageQr.create(qrCodeData, pathQrCode);
			manageQr.insert(pathQrCode, pathPdf, pathPdfOUt);
			success= -1;
		} catch (Exception e) {
			System.out.println("Erreur de l'ajout de QrCode");
			
			e.printStackTrace();
		}
		System.out.println("success    :"+" "+ success);
	}
  

}