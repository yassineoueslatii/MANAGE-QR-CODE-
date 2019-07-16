
import java.io.FileOutputStream;

import com.lowagie.text.Image;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class TestMain {
  public static void main(String[] args) throws Exception {
    PdfReader reader = new PdfReader("C:/pdf/pdf.pdf");
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:/pdf/pdf2.pdf"));
    Image img = Image.getInstance("C:/pdf/img5.png");
    img.setAbsolutePosition(200, 400);
    BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
    PdfContentByte under, over;
    int total = reader.getNumberOfPages() + 1;
    for (int i = 1; i < total; i++) {
      stamper.setRotateContents(false);
      under = stamper.getUnderContent(i);
      under.addImage(img);

    }
    stamper.close();
  }

}