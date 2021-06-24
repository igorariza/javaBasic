package groupar.co.product.presentation;

import groupar.co.product.service.*;
import java.util.Scanner;

public class ProductAllPresentation {
    public static void main(String[] args) {
        var option = -1;
        var scanner = new Scanner(System.in);
        InProductAll productList =  new ProductAllImpl();
        
        while(option != 0){
            System.out.println("Elige una opcion: \n"
                    + "1. Iniciar la lista de productos \n"
                    + "2. Agregar Producto \n"
                    + "3. Listar Productos \n"
                    + "4. Buscar Producto \n"
                    + "0. Salir");
            option = Integer.parseInt(scanner.nextLine());
            
            switch(option){
                case 1:
                    productList.initProductAll();
                    break;
                case 2:
                    System.out.println("Introduce el nombre del producto");
                    var nameProduct = scanner.nextLine();
                    productList.addProduct(nameProduct);
                    break;
                case 3:
                    productList.tolistProduct();
                    break;
                case 4:
                    System.out.println("Introduce producto a buscar");
                    var search = scanner.nextLine();
                    productList.searchProduct(search);
                    break;
                case 0:
                    System.out.println("See you!!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
                    break;                           
            }
            
        }
    }
    
}
