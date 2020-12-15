package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.Contato;
import entidade.RetornoCliente;

@Path("/cliente")
public class ServicoCliente {

	ClienteDAO clienteDAO;

	public ServicoCliente() {

		this.clienteDAO = new ClienteDAOImpl();

	}

	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {

		return "Cliente DetonaAgendaREST !!!";

	}

	@Path("/inserirCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente inserirCliente(Cliente cliente) {

		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (cliente.getContatos() != null && cliente.getContatos().size() > 0) {
			for (Contato contato : cliente.getContatos()) {
				contato.setCliente(cliente);
			}
		}

		if (!this.clienteDAO.inserirCliente(cliente)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não inserido!!");
		}

		return retorno;

	}

	@Path("/pesquisarCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente pesquisarCliente(Cliente cliente) {

		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (this.clienteDAO.pesquisarCliente(cliente.getCpf()) == null) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não encontrado!!!!");
		}

		return retorno;

	}

	@Path("/adicionarContatoCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente adicionarContatoCliente(Cliente cliente) {

		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.clienteDAO.adicionarContatoCliente(cliente)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não adicionado!!");
		}

		return retorno;

	}

	@Path("/removerContatoCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente removerContatoCliente(Cliente cliente) {

		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.clienteDAO.removerContatoCliente(cliente)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não removido!!");
		}

		return retorno;

	}

}
