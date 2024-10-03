package interfaces;

import modelos.Producto;

public interface CarroCompras {

	void agregarProducto(Producto producto);
	void listaProductos();
	int calcularTotal(); 
	
}
