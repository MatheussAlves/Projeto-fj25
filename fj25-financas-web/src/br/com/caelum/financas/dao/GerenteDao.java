package br.com.caelum.financas.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.financas.modelo.Gerente;

@Stateless
public class GerenteDao {
	@PersistenceContext
	private EntityManager manager;
	
	
	
	
	
	public void adiciona(Gerente gerente){
		this.manager.joinTransaction();
		this.manager.persist(gerente);
	}
	
	public void remove(Gerente gerente){
		Gerente gerenteParaRemover = this.manager.find(Gerente.class,gerente.getId());
		this.manager.remove(gerenteParaRemover);
	}
	
	public void altera(Gerente gerente){
		this.manager.merge(gerente);
	}
	public Gerente busca(Integer id){
		return this.manager.find(Gerente.class,id);
	}
	
	
	public List<Gerente> lista(){
		return this.manager.createQuery("select c from Gerente c",Gerente.class).getResultList();
	}
	
	
}
