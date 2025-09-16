package actividad6;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

public class Actividad6 {

    public static void main(String[] args) {
        try {
           
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("ejercicio_matriz.pdf"));
            document.open();

          
            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK);
            Font fontEncabezado = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE);
            Font fontCelda = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);

           
            Paragraph titulo = new Paragraph("Listado Premium de Películas", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(25);
            document.add(titulo);

            
            PdfPTable tabla = new PdfPTable(3);
            tabla.setWidthPercentage(100);
            tabla.setWidths(new float[]{3, 1, 2});

           
            BaseColor colorEncabezado = new BaseColor(33, 150, 243); 
            BaseColor colorFila1 = new BaseColor(227, 242, 253);     
            BaseColor colorFila2 = BaseColor.WHITE;
            BaseColor bordeCelda = new BaseColor(200, 200, 200);     

   
            String[] encabezados = {"pais", "capital", "poblacion(millones)"};
            for (String encabezado : encabezados) {
                PdfPCell celda = new PdfPCell(new Paragraph(encabezado, fontEncabezado));
                celda.setBackgroundColor(colorEncabezado);
                celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                celda.setPadding(8);
                celda.setBorderWidth(1.5f);
                celda.setBorderColor(bordeCelda);
                celda.setUseVariableBorders(true);
                tabla.addCell(celda);
            }

        
            String[][] paises = {
                    {"Guatemala", "Ciudad de Guatemala", "17"},
                    {"Mexico", "Ciudad de Mexico", "126"},
                    {"España", "Madrid", "47"},
                    {"Japon", "Tokio", "125"}
            };

           
            for (int i = 0; i < paises.length; i++) {
                BaseColor fondo = (i % 2 == 0) ? colorFila1 : colorFila2;
                for (String dato : paises[i]) {
                    PdfPCell celda = new PdfPCell(new Paragraph(dato, fontCelda));
                    celda.setBackgroundColor(fondo);
                    celda.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celda.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    celda.setPadding(6);
                    celda.setBorderWidth(1f);
                    celda.setBorderColor(bordeCelda);
                    tabla.addCell(celda);
                }
            }

           
            document.add(tabla);

         
            document.close();
            System.out.println("PDF premium creado: ejercicio_matriz.pdf");

        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
