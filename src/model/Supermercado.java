package model;

import java.util.List;
import java.util.Objects;

public class Supermercado {

	List<Producto> gondola;
	
	public Supermercado() {
		super();
	}

	public Supermercado(List<Producto> gondola) {
		super();
		this.gondola = gondola;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gondola);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supermercado other = (Supermercado) obj;
		return Objects.equals(gondola, other.gondola);
	}

	@Override
	public String toString() {
		return "Gondola [producto=" + gondola + "]";
	}

	public List<Producto> getProducto() {
		return gondola;
	}

	public void setProducto(List<Producto> producto) {
		this.gondola = producto;
	}
	
	public boolean agregarProducto(String producto, float precio) {
		boolean exist = false;
		 int gondolaSize = gondola.size();
		 int iterator = 0;
		 
		 while(iterator <= gondolaSize) {
			 if (iterator == gondolaSize) {
				gondola.add(new Producto(gondolaSize+1, producto, precio));
				iterator = gondolaSize +1;
			 }
			 else if (producto.equals(gondola.get(iterator).getProducto())) {
				 exist = true;
				 iterator = gondolaSize+1;
			 }else {
				 iterator ++;
			 }
		 }
		
		return exist;
	}
	
	public Producto  traerProducto(int idProducto) {
		Producto buscado = null;
		int iterator = 0;
		Producto seleccionado = gondola.get(iterator);
		
		while(iterator <= gondola.size()) {
			if(idProducto == seleccionado.getIdProducto()) {
				buscado = new Producto(idProducto, seleccionado.getProducto(), seleccionado.getPrecio());
				
			}
		}
		
		return buscado;
	}
	
	public void modificarProducto(int idProducto, String producto, double precio) {
		final Producto aModificar = this.traerProducto(idProducto);
		
		
	}
	
	public boolean eliminarProducto(int idProducto) {
		boolean aEliminar = false;
		
		return aEliminar;
	}
}

