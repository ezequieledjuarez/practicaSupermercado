package model;

public class Cliente {

		private int idCliente;
		private String cliente;
		private long dni;
		private String domicilio;

		public Cliente(int idCliente, String cliente, long dni, String domicilio) {
			super();
			this.idCliente = idCliente;
			this.cliente = cliente;
			this.dni = dni;
			this.domicilio = domicilio;
		}

		public int getIdCliente() {
			return idCliente;
		}

		public void setIdCliente(int idCliente) {
			this.idCliente = idCliente;
		}

		public String getCliente() {
			return cliente;
		}

		public void setCliente(String cliente) {
			this.cliente = cliente;
		}

		public long getDni() {
			return dni;
		}

		public void setDni(long dni) {
			this.dni = dni;
		}

		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(String domicilio) {
			this.domicilio = domicilio;
		}

		@Override
		public String toString() {
			return "Cliente [idCliente=" + idCliente + ", cliente=" + cliente + ", dni=" + dni + ", domicilio=" + domicilio
					+ "]";
		}

		public boolean equals(Cliente cliente) {
			return cliente.getDni() == this.dni;
		}

	
}
