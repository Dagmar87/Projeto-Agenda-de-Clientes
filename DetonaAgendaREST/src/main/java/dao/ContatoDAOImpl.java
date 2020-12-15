package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Contato;
import util.JpaUtil;

public class ContatoDAOImpl implements ContatoDAO {

	@Override
	public boolean inserirContato(Contato contato) {
		// TODO Auto-generated method stub

		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Contato contBase = ent.find(Contato.class, contato.getId());

		if (contBase == null) {

			ent.persist(contato);
			trans.commit();

		} else {

			retorno = false;

		}

		ent.close();
		return retorno;
	}

	@Override
	public boolean adicionarContato(Contato contato) {
		// TODO Auto-generated method stub
		
		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Contato contBase = ent.find(Contato.class, contato.getId());

		if (contBase != null) {

			ent.merge(contato);
			trans.commit();

		} else {

			retorno = false;
			System.out.println("Contato não localizado!");

		}

		ent.close();
		return retorno;
	}

	@Override
	public boolean removerContato(Contato contato) {
		// TODO Auto-generated method stub
		
		boolean retorno = true;

		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Contato contBase = ent.find(Contato.class, contato.getId());

		if (contBase != null) {

			ent.remove(contato);
			trans.commit();

		} else {

			retorno = false;
			System.out.println("Contato não localizado!");

		}

		ent.close();
		return retorno;
	}

	@Override
	public Contato pesquisarContato(int id) {
		// TODO Auto-generated method stub
		
		EntityManager ent = JpaUtil.getEntityManager();
		Contato retorno = ent.find(Contato.class, id);
		
		return retorno;
	}

	@Override
	public List<Contato> listarTodos() {
		// TODO Auto-generated method stub
		
		EntityManager ent = JpaUtil.getEntityManager();
		
		Query query = ent.createQuery("from Contato cont");
		
		@SuppressWarnings("unchecked")
		List<Contato> contatos = query.getResultList();
		
		return contatos;
	}

}
