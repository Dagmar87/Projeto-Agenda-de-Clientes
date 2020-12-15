package dao;

import java.util.List;

import entidade.Contato;

public interface ContatoDAO {

	public boolean inserirContato(Contato contato);
	
	public boolean adicionarContato(Contato contato);
	
	public boolean removerContato(Contato contato);
	
	public Contato pesquisarContato(int id);
	
	public List<Contato> listarTodos();

}
