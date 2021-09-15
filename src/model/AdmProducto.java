package model;

import java.util.List;

public class AdmProducto {
		private List<Producto> lstProducto;

		public AdmProducto(List<Producto> lstProducto) {
			super();
			this.lstProducto = lstProducto;
		}

		public List<Producto> getListaProducto() {
			return lstProducto;
		}

		public void setListaProducto(List<Producto> lstProducto) {
			this.lstProducto = lstProducto;
		}
		
		public Producto traerProducto(int idProducto) {
			int iterator = 0;
			
			boolean encontrado = false;
			
			Producto producto = null;
			
			while(iterator < lstProducto.size() && !encontrado) {
				if(idProducto == lstProducto.get(iterator).getIdProducto()) {
					producto = lstProducto.get(iterator);
					encontrado = true;
				}
				iterator ++;
			}
			
			return producto;
		}
		
		public boolean modificarProducto(int idProducto, String producto, float precio)throws Exception {
			Producto productoBuscado = traerProducto(idProducto);
			
			if(productoBuscado == null) 
				throw new Exception("EL PRODUCTO QUE SE INTENTA MODIFICAR NO EXISTE");
			
			productoBuscado.setProducto(producto);
			productoBuscado.setPrecio(precio);

			return true;
		}
		
		public boolean agregarProducto(String producto, float precio) throws Exception{
			int iterator = 0;
			boolean encontrado = false;
			int lstProductoSize = 0;
			
			while(iterator < lstProducto.size() && !encontrado) {
				if(producto.equalsIgnoreCase(lstProducto.get(iterator).getProducto())) {
					encontrado = true;
				}
				else {
					lstProductoSize = lstProducto.get(lstProducto.size()-1).getIdProducto()+1;
				}
				
				iterator ++;
			}
			if(encontrado)
				throw new Exception("El producto ya existe");
			
			return lstProducto.add(new Producto(lstProductoSize, producto, precio));
		}
		
	
}
