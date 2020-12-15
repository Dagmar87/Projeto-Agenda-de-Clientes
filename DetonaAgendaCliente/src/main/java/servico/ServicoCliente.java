package servico;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import entidade.Cliente;
import entidade.RetornoCliente;
import entidade.RetornoContato;

public class ServicoCliente {

	public static RetornoCliente inserirCliente(Cliente cliente) {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:9090/DetonaAgendaREST/rest/cliente/inserirCliente");

			ClientResponse response = webResource.type("application/json").post(ClientResponse.class, cliente);

			if (response.getStatus() != 200) {

				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());

			}

			RetornoCliente retornoCliente = response.getEntity(RetornoCliente.class);
			return retornoCliente;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

	public static RetornoContato listarTodosContatos() {

		try {

			Client client = Client.create();

			WebResource webResource = client
					.resource("http://localhost:9090/DetonaAgendaREST/rest/contato/listarTodos");

			ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
				
			}
			
			RetornoContato retornoServico = response.getEntity(RetornoContato.class);
			
			return retornoServico;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return null;

	}

}
