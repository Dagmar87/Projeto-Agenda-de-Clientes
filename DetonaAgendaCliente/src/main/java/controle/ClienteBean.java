package controle;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import entidade.Cliente;
import entidade.Contato;
import entidade.RetornoCliente;
import servico.ServicoCliente;

@ManagedBean(name = "ClienteBean")
@SessionScoped
public class ClienteBean {

	private Cliente cliente;
	private List<Contato> listaContatos;

	public ClienteBean() {

		this.cliente = new Cliente();

		this.listaContatos = ServicoCliente.listarTodosContatos().getListaContatos();

	}

	public void salvar() {

		RetornoCliente retorno = ServicoCliente.inserirCliente(cliente);

		if (retorno.getCodigoRetorno() == 0) {

			System.out.println("-- Salvou --");

		} else {

			System.out.println(" ++ Não salvou ++");

		}

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Contato> getListaContatos() {
		return listaContatos;
	}

	public void setListaContatos(List<Contato> listaContatos) {
		this.listaContatos = listaContatos;
	}

}
