package test;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import model.AdmCliente;
import model.Carrito;
import model.Cliente;
import model.ItemCarrito;
import model.Producto;

public class SupermeracadoTest {

	public static void main(String[] args) {

		System.out.println("Inicio test");
		
		try {
			// Genero instancias de un producto
			Producto galletitas = new Producto(001, "Galletitas pepas", 60.0f);
			Producto detergente = new Producto(002, "Detergente Ala", 90.0f);
			Producto aceite = new Producto(003, "Aceite Girasol", 150.0f);

			// Genero instancias de ItemsCarrito

			ItemCarrito galletitasItemCarrito = new ItemCarrito(1, galletitas, 4);
			ItemCarrito detergenteItemCarrito = new ItemCarrito(2, detergente, 1);
			ItemCarrito aceiteItemCarrito = new ItemCarrito(3, aceite, 2);

			// Genero instancias de Cliente

			Cliente cliente = new Cliente(25, "Cliente Veinti Cinco", 2135050, "Calle Falsa 123");
			Cliente homero = new Cliente(40, "Homero Simpson", 14567788, "Avenida SiempreViva 247");

			// Genero una lista de Clientes
			List<Cliente> listaClientes = new ArrayList<Cliente>();

			// Administrador de clientes
			AdmCliente administradorDeClientes = new AdmCliente(listaClientes);

			LocalDate fechaActual = LocalDate.now();
			LocalTime horaActual = LocalTime.now();

			// Lista de items en un carritos
			List<ItemCarrito> listaItemCarrito = new ArrayList<ItemCarrito>();

			listaItemCarrito.add(aceiteItemCarrito);
			listaItemCarrito.add(detergenteItemCarrito);

			Carrito carritoHomero = new Carrito(444, fechaActual, horaActual, listaItemCarrito, homero);

			System.out.println(carritoHomero.eliminarItem(aceite, 1));

			for (ItemCarrito item : listaItemCarrito) {
				System.out.println(item);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
