package dao;

import java.util.List;

import entidade.Cliente;

public interface ClienteDAO {

	public boolean inserirCliente(Cliente cliente);

	public Cliente pesquisarCliente(String cpf);

	public boolean adicionarContatoCliente(Cliente cliente);

	public boolean removerContatoCliente(Cliente cliente);
	
	public List<Cliente> listarTodos();

}
