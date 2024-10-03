package principal;

import java.time.LocalDate;
import java.util.Scanner;

import modelos.CarroDeComprasImpl;
import modelos.Producto;
import modelos.Vegetales;
import modelos.Vendedor;
import modelos.Vestuario;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		CarroDeComprasImpl carro = new CarroDeComprasImpl(); 
		
		Vendedor vendedor = new Vendedor("Juan Perez Machuca", "15.971.652-3");
		
		Producto[] productosDisponibles = {
	            new Vegetales("Tomate", "001", 500, LocalDate.of(2024, 1, 1), LocalDate.of(2024, 2, 1)),
	            new Vegetales("Lechuga", "002", 300, LocalDate.of(2024, 1, 5), LocalDate.of(2024, 2, 5)),
	            new Vestuario("Camisa", "003", 10000, "M", "Rojo"),
	            new Vestuario("Pantalón", "004", 15000, "L", "Azul")
	        };
		
		
		boolean salir = false;
		
		while(!salir) {
			System.out.println("\nMenú de la tienda:");
            System.out.println("1. Listar productos disponibles");
            System.out.println("2. Agregar producto al carro de compras");
            System.out.println("3. Listar productos del carro");
            System.out.println("4. Pagar");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            
            switch (opcion) {
            
            case 1: 
            	System.out.println("\nProductos Disponibles: ");
            	for (Producto producto : productosDisponibles) {
            		System.out.println(producto);
            	}
            	break;
            	
            case 2:
            	System.out.println("\nIngrese el código del producto que desea agregar: ");
            	String codigo = scanner.next();
            	boolean productoEncontrado = false; 
            	
            	for (Producto producto : productosDisponibles) {
            		if (producto.getCodigo().equals(codigo)) {
            			carro.agregarProducto(producto);
            			productoEncontrado = true;
            			
            			break;
            		}
            	}
            	
            	if (!productoEncontrado) {
            		System.out.println("Producto no encontrado");
            	}
            	break;
            	
            case 3:
            	System.out.println("\nProductos en el carro");
            	carro.listaProductos();
            	break;
            	
            case 4:
            	int total = carro.calcularTotal();
            	System.out.println("\n Total a pagar: $" + total);
            	System.out.println("\n Venta realizada por: " + vendedor);
            	break;
            
            case 5:
            	salir = true; 
            	break;
            	
            default:
            	System.out.println("Opcion no valida");
            	
            }
                        
		}

	}

}
