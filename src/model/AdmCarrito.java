package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AdmCarrito {
		private List<Carrito> lstCarrito;

		public AdmCarrito(List<Carrito> listaCarrito) {
			super();
			this.lstCarrito = listaCarrito;
		}

		public List<Carrito> getListaCarrito() {
			return lstCarrito;
		}

		public void setListaCarrito(List<Carrito> listaCarrito) {
			this.lstCarrito = listaCarrito;
		}
		
//		public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception{
//			int listaCarritoSize, iterator = 0;
//			
//			boolean encontrado = false;
//			
//			while(iterator < lstCarrito.size() && !encontrado) {
//				if(lstCarrito.get(iterator).getCliente())
//			}
//		}
}
