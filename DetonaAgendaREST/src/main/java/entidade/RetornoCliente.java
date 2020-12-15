package entidade;

import java.util.List;

public class RetornoCliente extends RetornoPadrao {

	private Cliente cliente;

	private List<Cliente> listaCliente;

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

}
