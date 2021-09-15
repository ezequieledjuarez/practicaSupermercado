package model;

import java.util.List;

public class AdmCliente {
	
	private List<Cliente> lstCliente;

	
	public AdmCliente(List<Cliente> lstCliente) {
		super();
		this.lstCliente = lstCliente;
	}

	
	public List<Cliente> getListaCliente() {
		return lstCliente;
	}

	public void setListaCliente(List<Cliente> lstCliente) {
		this.lstCliente = lstCliente;
	}
	
	public Cliente traerCliente(long dni) {
		int iterator = 0;
		boolean encontrado = false;
		Cliente cliente = null;
		
		while(iterator < lstCliente.size() && !encontrado) {
			if(dni == lstCliente.get(iterator).getDni()) {
				cliente = lstCliente.get(iterator);
				encontrado = true;
			}
			iterator ++;
		}
		
		return cliente;
	}
	
	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception{
	
		Cliente clienteBuscado = traerCliente(dni);
		
		if (clienteBuscado != null) {
			throw new Exception("ERROR EL CLIENTE YA EXISTE");

		}
		
		return lstCliente.add(new Cliente (lstCliente.get(lstCliente.size()-1).getIdCliente()+1, cliente, dni ,direccion));
		
		
	}
	
	public boolean eliminarCliente(long dni) throws Exception{
		Cliente clienteBuscado = traerCliente(dni);
		
		if(clienteBuscado == null) {
			throw new Exception("El cliente no existe");

		}
		
		return lstCliente.remove(clienteBuscado);
	}
	
	
}
