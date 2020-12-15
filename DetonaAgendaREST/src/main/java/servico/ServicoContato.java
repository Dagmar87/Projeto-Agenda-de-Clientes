package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dao.ContatoDAO;
import dao.ContatoDAOImpl;
import entidade.Contato;
import entidade.RetornoContato;

@Path("/contato")
public class ServicoContato {

	ContatoDAO contatoDAO;
	ClienteDAO clienteDAO;

	public ServicoContato() {

		this.contatoDAO = new ContatoDAOImpl();
		this.clienteDAO = new ClienteDAOImpl();

	}

	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {

		return "Contato DetonaAgendaREST !!!";

	}

	@Path("/inserirContato")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoContato inserirContato(Contato contato) {

		RetornoContato retorno = new RetornoContato();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");

		if (!this.contatoDAO.inserirContato(contato)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Contato não inserido!!");
		}

		return retorno;

	}

	@Path("/listarTodos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public RetornoContato listarTodos() {

		RetornoContato retorno = new RetornoContato();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		retorno.setListaContatos(this.contatoDAO.listarTodos());

		return retorno;

	}

}
