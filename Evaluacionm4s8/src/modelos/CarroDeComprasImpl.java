package modelos;

import java.util.ArrayList;
import java.util.List;

import interfaces.CarroCompras;

public class CarroDeComprasImpl implements CarroCompras {
	
	private List<Producto> productos = new ArrayList<>(); 
	private static final int MAX_PRODUCTOS = 10;
	
	
	@Override
	public void agregarProducto(Producto producto) {
		if (productos.size() < MAX_PRODUCTOS) {
			productos.add(producto);
			System.out.println(producto.getNombre() + "ha sido agregado al carro.");
		} else {
			System.out.println("El carro de compras está lleno");
		}
	}


	@Override
	public void listaProductos() {
		if (productos.isEmpty() ) {
			System.out.println("El carro está vacío");
		} else {
			productos.forEach(System.out::println);
		}
		
	}


	@Override
	public int calcularTotal() {
		return productos.stream().mapToInt(Producto::getPrecio).sum();
	}

}
