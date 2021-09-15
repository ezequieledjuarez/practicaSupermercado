package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class Carrito {

	private int id;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> lstItem;
	private Cliente cliente;

	public Carrito() {
		super();
	}

	public Carrito(int id, LocalDate fecha, LocalTime hora, List<ItemCarrito> lstItem, Cliente cliente) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.hora = hora;
		this.lstItem = lstItem;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public List<ItemCarrito> getLstItem() {
		return lstItem;
	}

	public void setLstItem(List<ItemCarrito> lstItem) {
		this.lstItem = lstItem;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora, id, lstItem);
	}

	public boolean equals(Carrito c) {
		return this.id == c.id;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", lstItem=" + lstItem + "]";
	}

	public boolean agregarItem(Producto producto, int cantidad) {

		ItemCarrito item = traerItemCarrito(producto.getProducto());
		
		int id = 1;
		
		if(item == null) {
			if(lstItem.size() > 0) {
				id = lstItem.get(lstItem.size()-1).getIdItem()+1;
			}
			ItemCarrito nuevoItem = new ItemCarrito(id, producto, cantidad);
			lstItem.add(nuevoItem);
		}
		else {
			item.setCantidad(item.getCantidad()+cantidad);
		}
		return true;
	}

	public ItemCarrito traerItemCarrito(String producto) {
		ItemCarrito item = null;

		int iterator = 0;

		while (item == null && iterator < lstItem.size()) {
			if (producto.equalsIgnoreCase(lstItem.get(iterator).getProducto().getProducto())) {
				item = lstItem.get(iterator);
			}
			if(item != null) {
				iterator = lstItem.size();
			}
			iterator++;
		}
		return item;
	}

	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		ItemCarrito item = traerItemCarrito(producto.getProducto());
		boolean eliminado = true;

		if (item == null) {
			throw new Exception("El producto no existe");

		}
		if(cantidad == item.getCantidad()) {
			eliminado = lstItem.remove(item);
		}
		else if(cantidad <item.getCantidad()) {
			item.setCantidad(item.getCantidad() - cantidad);
		}
		

		return eliminado;
	}

	public float calcularSubTotal() {
		float subtotal = 0f;

		for (ItemCarrito itemCarrito : lstItem) {
			subtotal = itemCarrito.getProducto().getPrecio() * itemCarrito.getCantidad();
		}
		return subtotal;
	}

	public float calcularTotal() {
		float total = 0f;

		for (ItemCarrito itemsCarrito : lstItem) {
			total += itemsCarrito.getProducto().getPrecio() * itemsCarrito.getCantidad();
		}

		return total;
	}
}
