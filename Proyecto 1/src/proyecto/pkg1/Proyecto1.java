package proyecto.pkg1;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPCell;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Proyecto1 {
    
    static int elementosMax = 100;
    static int bitacoraMax = 200;
    static String codigo [] = new String [elementosMax];
    static String nombres [] = new String [elementosMax];
    static String categorias [] = new String[elementosMax]; 
    static float precio [] = new float [elementosMax];
    static int stocks [] = new int [elementosMax];
    static String  accionesBitacora [] = new String[bitacoraMax];
    static int totalProductos = 0;
    static int totalBitacora = 0;
    
    static Scanner entrada = new Scanner(System.in);
    
    public static void main(String[] args) {
        
       int opcion =0;  

               
       do{
            System.out.println("\n=== Bienvenido al menu de la tienda ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto");
            System.out.println("3. Eliminar producto");
            System.out.println("4. Registrar venta");
            System.out.println("5. Generar reportes");
            System.out.println("6. Ver datos del estudiante");
            System.out.println("7. Bitacora");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opcion: ");
            
            try{
                opcion = Integer.parseInt(entrada.nextLine());
                switch(opcion){
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        buscarProducto();
                        break;
                    case 3:
                        eliminarProducto();
                        break;
                    case 4:
                        registrarVenta();
                        break;
                    case 5:
                        generarReporte();
                        break;
                    case 6:
                        verDatosEstudiante();
                        break;
                    case 7:
                        bitacora();
                        break;
                    case 8:
                        System.out.println("Saliste del menu principal");;
                        break;
                    default :
                        System.out.println("OPCION INVALIDA, DIGITE UN NUMERO DEL MENU");
                }
            }catch(NumberFormatException e){
                System.out.println("Error: Debe ingresar un numero valido");
            }
       }while(opcion != 8); 
    }
    
    
    public static void agregarProducto(){ 
       //El codigo verifica que no se haya excedido el numero de articulos
       //si el codigo no ha excedido el numero de produtos, no recorrera este bloque
       Scanner entrada = new Scanner(System.in);
       
       if (totalProductos >= elementosMax){
           System.out.println("Llego al limite de compra, por favor haga una nueva compra");
           return;
       }
       
       System.out.println("Agregue un producto a su compra :)");
       
       
       boolean codigoUnico = false;
       int contador = 0, stockNuevo;
       String nuevoCodigo, categoria;
       float precioNuevo;
       
       do{
       System.out.println("Ingrese el codigo del articulo: ");
       nuevoCodigo = entrada.nextLine().trim();
       if (nuevoCodigo.isEmpty()){
           System.out.println("Error: el codigo esta vacio, por favor digite un codigo valido");
       }
       
       codigoUnico = true;
       for(int i = 0; i <totalProductos; i++){
           if(codigo[i] != null && codigo[i].equalsIgnoreCase(nuevoCodigo))
               System.out.println("Error: este codigo ya existe");
           codigoUnico = false;
           return;
       } 
       }while(!codigoUnico);
       
       //Agregar a la compra el nombre de un articulo
        System.out.println("Que producto desea comprar?: ");
        String nombre = entrada.nextLine().trim();
        if (nombre.isEmpty()){
            System.out.println("Error: debe ingresar el nombre de algun producto");
            return;
        }
        
        //Añadir compra 
        System.out.println("Que desea comprar: \nPantalones:\n, \nPlayeras:\n, \nCalcetines:\n, \nRopa interior:\n, \nSueteres:\n, \nGorras:\n ");
        categoria = entrada.nextLine().trim();
        
        for(int i=0; i<totalProductos; i++){
            if (categorias[i] != null && categorias [i].equalsIgnoreCase(categoria)){
                contador++;
            }
        }
        //Para que la compra sea más dinámica solo se permitirá comprar 5 cosas de cada categoría
        if (contador >= 5){
            System.out.println("Solo puedes escoger 5 productos de cada categoria"+categoria);
            return;
        }
       
        System.out.println("Precio: ");
        String precios = entrada.nextLine().trim();
        try{
            precioNuevo = Float.parseFloat(precios);
            if(precioNuevo < 0){
                System.out.println("El precio no puede ser negativo");
                return;
            }
        }catch (NumberFormatException e){
            System.out.println("Error: digite un precio valido");
            return;
        }
        
        System.out.print("Stock: ");
        String stockStr = entrada.nextLine().trim();
         try{
        stockNuevo = Integer.parseInt(stockStr);
        if (stockNuevo < 0){
            System.out.println("El stock tiene que ser un valor positivo, corríjalo por favor.");
            return;
        }
        }catch (NumberFormatException e){
        System.out.println("Stock inválido.");
        return;
        
        }
        codigo[totalProductos] = nuevoCodigo;
        nombres[totalProductos] = nombre;
        categorias[totalProductos] = categoria;
        precio[totalProductos] = precioNuevo;
        stocks[totalProductos] = stockNuevo;
        totalProductos++;
        
        System.out.println("Listo! su producto fue agreagado a la compra");
        
        
        
        
    }
    
    public static void buscarProducto(){
          
         System.out.println("¿Que desea buscar?: ");
         String dato = entrada.nextLine().trim();
         
         boolean encontrado = false;
         int indice = -1;
         
         for(int i=0; i<totalProductos; i++){
             if(categorias[i] != null && categorias[i].equalsIgnoreCase(dato)){
                 encontrado = true;
                 indice = i;
                 break;
             }
         }
         
         if(!encontrado){
             System.out.println("No se encontro su producto, intente de nuevo.");
         } else{
             System.out.println("Genial! su articulo fue encontrado:");
             System.out.println("1. Codigo: "+codigo[indice]);
             System.out.println("2. Producto: "+nombres[indice]);
             System.out.println("3. Categoria: "+categorias[indice]);
             System.out.println("4. Precio: "+precio[indice]);
             System.out.println("5. Stock: "+stocks[indice]);
         }     
    }
    
    public static void eliminarProducto(){
        System.out.println("Para eliminar un producto necesita ingresar el código: ");
        String eliminarCodigo = entrada.nextLine().trim();
        
        int indice = -1;
        
        for(int i=0; i<totalProductos; i++){
             if(categorias[i] != null && codigo[i].equalsIgnoreCase(eliminarCodigo)){
                 indice = i;
                 break; //Para eliminar el codigo primero debemos buscarlo dentro de nuestro arreglo usando un for
             }
        }
        if(indice == -1){
            System.out.println("No hay ningun producto con este codigo: "+eliminarCodigo);
            return;
        } 
        for(int i=indice; i<totalProductos-1; i++){
            codigo[i] = codigo[i+1];
            nombres[i] = nombres[i+1];
            categorias[i] = categorias[i+1];
            precio[i] = precio[i+1];
            stocks[i] = stocks[i+1]; //De este modo vaciamos el espacio de nuestro vector
        }
        
        totalProductos--;
        System.out.println("Se elimino el producto de su compra.");
    }
    
    public static void registrarVenta(){
        System.out.println("Ingrese el código del producto para registrar la venta: ");
        String codProducto = entrada.nextLine().trim();
        int posicion = -1;
        for(int i=0; i<totalProductos; i++){
            if(codigo[i].equalsIgnoreCase(codProducto)){
                posicion = 1;
                break;
            }
        }
        if(posicion == -1){
            System.out.println("No existe ningun producto con este codigo");
            return;
        }
        
        boolean validarCantidad = false;
        do{
            System.out.println("Ingrese la cantidad vendida: ");
            int cantVenta = Integer.parseInt(entrada.nextLine());
            if(cantVenta <= 0){
            System.out.println("Necesita ingresar un valor positivo");
        }else if(cantVenta > totalProductos){
                System.out.println("La venta supera a la cantidad de los productos disponibles");
                
                totalProductos -= cantVenta;
                int totalVenta = (int)(cantVenta*precio[posicion]);
                
                System.out.println("La venta total es de :"+totalVenta);
                System.out.println("Venta Registrada de manera exitosa");
                System.out.println("Producto: "+nombres[posicion]);
                System.out.println("Total vendido: "+totalVenta);
                System.out.println("Stocks: "+stocks[posicion]);
                validarCantidad = true;      
        }
            
        }while(!validarCantidad);
        
    }

    
    public static void generarReporte(){
        try{
            String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss"));
            String stockArchivo = fecha +". Stock.pdf";
            String ventaArchivo = fecha +". Venta.pdf";
            
            generarReporteStockPDF(stockArchivo);
            generarReporteVentasPDF(ventaArchivo);
            
            System.out.println("Reportes: ");
            System.out.println(" " +stockArchivo);
            System.out.println(" " +ventaArchivo);
            
        }catch(Exception e){
            System.out.println("Error al generar el reporte"+e.getMessage());   
        }

    }
    
   private static void generarReporteStockPDF(String nombArchivo) throws IOException, DocumentException {
       Document documento = new Document(PageSize.LETTER, 36,36,36,36);
       PdfWriter.getInstance(documento, new java.io.FileOutputStream(nombArchivo));
       
       documento.open();
       
       Paragraph titulo = new Paragraph("Estos son los reportes generados para Stock", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
       documento.add(titulo);
       documento.add(new Paragraph(" "));
       
       PdfPTable tablapdf = new PdfPTable(5);
       tablapdf.setWidthPercentage(100);
       tablapdf.setWidths(new float []{28f,20f,22f,15f,15f,});
   
       addHeader(tablapdf, "Nombre :");
       addHeader(tablapdf, "Codigo :");
       addHeader(tablapdf, "Categoria :");
       addHeader(tablapdf, "Precio : ");
       addHeader(tablapdf, "Stock :");
       
       Font fFila = FontFactory.getFont(FontFactory.COURIER, 10);
       for (int i = 0; i<totalProductos; i++){
           
           tablapdf.addCell(new Phrase(safe(nombres[i]), fFila));
           tablapdf.addCell(new Phrase(safe(codigo[i]), fFila));
           tablapdf.addCell(new Phrase(safe(categorias[i]), fFila));
           tablapdf.addCell(new Phrase(String.format("%.2f", precio [i]), fFila));
           tablapdf.addCell(new Phrase(String.valueOf(stocks[i]), fFila));
       }   
       
       documento.add(tablapdf);
       documento.close();
   }
   
   private static void generarReporteVentasPDF(String nomArchivo) throws IOException, DocumentException {
       Document documento = new Document(PageSize.LETTER, 36,36,36,36);
       PdfWriter.getInstance(documento, new java.io.FileOutputStream(nomArchivo));
       documento.open();
       
       Paragraph tituloDoc = new Paragraph(" Reporte de ventas ", FontFactory.getFont(FontFactory.HELVETICA_BOLD,16));
       tituloDoc.setAlignment(Element.ALIGN_LEFT);
       documento.add(tituloDoc);
       documento.add(new Paragraph(" "));
       
       PdfPTable tabla2 = new PdfPTable(5);
       tabla2.setWidthPercentage(100);
       tabla2.setWidths(new float[]{20f,28f,10f,18f,24f});
       
       addHeader(tabla2, " Nombre: ");
       addHeader(tabla2, " Codigo: ");
       addHeader(tabla2, " Cantidad total: ");
       addHeader(tabla2, " Total (en quetzalez): ");
       addHeader(tabla2, " Fecha y hora: ");
       
       Font fFila = FontFactory.getFont(FontFactory.COURIER, 10);
       File f = new File("Reporte de ventas.txt");
       if (!f.exists()){           
           documento.add(new Paragraph("ERROR: NO SE REGISTRO NINGUNA VENTA",FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE, 11)));
           return;       
       }
       float totalGeneral = 0f;
       
       try(BufferedReader lectura = new BufferedReader(new FileReader(f))){
           String linea;
           while((linea =lectura.readLine()) !=null){
               String[] p = linea.split(" ");
               if (p.length < 6) continue;
               
               String codigoProd = p[0];
               String nomProd = p[1];
               String cantProd = p[2];
               String totalConsumo = p[4];
               String fechaCompra = p[5];
               
               try {
                   totalGeneral += Float.parseFloat(totalConsumo);
               }catch (NumberFormatException ignore) {}
               
               tabla2.addCell(new Phrase(safe(codigoProd), fFila));
               tabla2.addCell(new Phrase(safe(nomProd), fFila));
               tabla2.addCell(new Phrase(safe(cantProd), fFila));
               tabla2.addCell(new Phrase(safe(totalConsumo), fFila));
               tabla2.addCell(new Phrase(safe(fechaCompra), fFila));
               
           }
       }
       
       documento.add(tabla2);
       documento.add(new Paragraph(" - "));
       documento.add(new Paragraph("EL total de la compra es: " + String.format("%.2f", totalGeneral), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
       
   }
        
    public static void verDatosEstudiante(){
        System.out.println("Nombre: Juan Jose María González Tuch");
        System.out.println("Carnet: 202300700");
        System.out.println("Proyecto 1 IPC1");
    }
 
    public static void registrarAccion(String tipoAccion, boolean correcta, String usuario){
        if (totalBitacora >= bitacoraMax){
            System.out.println("Las acciones de la bitacora llegaron a su limite");
            return;
        }
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String modo = correcta? "Correcto" : " Error ";
        String inicio = String.format("|=======Accion:=======|=======Modo:=======|=======Usuario: =======|", fecha, tipoAccion, modo, usuario);
        
        accionesBitacora[totalBitacora] = inicio;
        totalBitacora++;
    }
    
    public static void bitacora(){
        System.out.println("Bitacora");
        if (totalBitacora == 0){
            System.out.println("Digite una opcion valida");
        }else{
            for(int i=0; i<totalBitacora; i++){
            System.out.println(accionesBitacora[i]);
            }
        }
    }

    private static void addHeader(PdfPTable tabla, String txt) {
        Font f = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 11);
        PdfPCell sc = new PdfPCell(new Phrase(txt, f));
        sc.setHorizontalAlignment(Element.ALIGN_CENTER);
        tabla.addCell(sc);
    }

    private static String safe(String datosfinales) { return (datosfinales == null) ? "" : datosfinales; }
  
}   