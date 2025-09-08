
package proyecto.pkg1;

import java.util.Scanner;

public class Proyecto1 {
    
    static int elementosMax = 100;
    static String codigo [] = new String [elementosMax];
    static String nombres [] = new String [elementosMax];
    static String categorias [] = new String[elementosMax]; 
    static float precio [] = new float [elementosMax];
    static int stocks [] = new int [elementosMax];
    static int totalProductos = 0;
    
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
            System.out.print("Seleccione una opción: ");
            
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
                        verDatos();
                        break;
                    case 7:
                        bitacora();
                        break;
                    case 8:
                        salir();
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
       
       if (totalProductos >= elementosMax){
           System.out.println("Llego al limite de compra, por favor haga una nueva compra");
           return;
       }
       
       System.out.println("Agregue un producto a su compra :)");
       
       //Pedir el codigo de un articulo 
       boolean codigoUnico = false;
       int contador = 0;
       double precio;
       String nuevoCodigo, categoria;
       
       do{
       System.out.println("Ingrese el codigo del articulo: ");
       nuevoCodigo = entrada.nextLine().trim();
       if (nuevoCodigo.isEmpty()){
           System.out.println("Error: el codigo esta vacio, por favor digite un codigo valido");
       }
       
       //Validar que el codigo sea unico
       codigoUnico = true;
       for(int i = 0; i <totalProductos; i++){
           if(codigo[i] != null && codigo[i].equalsIgnoreCase(nuevoCodigo))
               System.out.println("Error: este codigo ya existe");
           codigoUnico = false;
           break;
       } 
       }while(!codigoUnico);
       
       //Agregar a la compra el nombre de un articulo
        System.out.println("Que producto desea comprar?: ");
        String nombre = entrada.nextLine().trim();
        if (nombre.isEmpty()){
            System.out.println("Error: debe ingresar el nombre de algun producto");
            return;
        }
        
        
        System.out.println("Que desea comprar: \nPantalones:\n, \nPlayeras:\n, \nCalcetines:\n, \nRopa interior:\n, \nSueteres:\n, \nGorras:\n ");
        categoria = entrada.nextLine().trim();
        
        for(int i=0; i<totalProductos; i++){
            if (categorias[i] != null && categorias [i].equalsIgnoreCase(categoria)){
                contador++;
            }
        }
        if (contador >= 5){
            System.out.println("Solo puedes escoger 5 productos de cada categoria"+categoria);
            return;
        }
       

 
        
    }
    
    
    
}   