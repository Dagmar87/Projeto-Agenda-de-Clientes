package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Cliente;
import util.JpaUtil;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public boolean inserirCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Cliente cliBase = ent.find(Cliente.class, cliente.getCpf());

		if (cliBase == null) {

			ent.persist(cliente);
			trans.commit();

		} else {

			retorno = false;

		}

		ent.close();
		return retorno;
	}

	@Override
	public Cliente pesquisarCliente(String cpf) {
		// TODO Auto-generated method stub

		EntityManager ent = JpaUtil.getEntityManager();
		Cliente retorno = ent.find(Cliente.class, cpf);

		return retorno;
	}

	@Override
	public boolean adicionarContatoCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Cliente cliBase = ent.find(Cliente.class, cliente.getCpf());

		if (cliBase != null) {

			ent.merge(cliente);
			trans.commit();

		} else {

			retorno = false;
			System.out.println("Clente não localizado!");

		}

		ent.close();
		return retorno;
	}

	@Override
	public boolean removerContatoCliente(Cliente cliente) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Cliente cliBase = ent.find(Cliente.class, cliente.getCpf());

		if (cliBase != null) {

			ent.remove(cliBase);
			trans.commit();

		} else {
			retorno = false;
			System.out.println("Clente não localizado!");
		}

		ent.close();
		return retorno;
	}

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub

		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Cliente cli");

		@SuppressWarnings("unchecked")
		List<Cliente> clientes = query.getResultList();

		return clientes;
	}

}
