
package proyecto.pkg1;

import java.util.Scanner;

public class Proyecto1 {
    
    static int elementosMax = 100;
    static String codigos [] = new String [elementosMax];
    static String nombres [] = new String [elementosMax];
    
    
    
    public static void main(String[] args) {
       Scanner entrada = new Scanner(System.in);
       
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
                        Bitacora();
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
}   