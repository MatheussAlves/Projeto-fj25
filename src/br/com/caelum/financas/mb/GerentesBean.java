package br.com.caelum.financas.mb;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.financas.dao.GerenteDao;
import br.com.caelum.financas.modelo.Gerente;


public class GerentesBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@Inject
	private GerenteDao gerenteDao = new GerenteDao();
	
	private List<Gerente> gerentes;
	private Gerente gerente = new Gerente();
	
	
	
	
	public List<Gerente> getGerentes() {
		if(this.gerentes == null){
			this.gerentes = gerenteDao.lista();
		}
		return gerentes;
	}
	public void grava(){
		System.out.println("Gravando gerente");
		
		if(this.gerente.getId()==null){
			gerenteDao.adiciona(gerente);
		}else{
			gerenteDao.altera(gerente);
		}
		this.gerentes = gerenteDao.lista();
		limpaFormularioDoJSF();
		
	}
	public void remove(){
		System.out.println("Removendo gerente");
		
		gerenteDao.remove(gerente);
		this.gerentes = gerenteDao.lista();
		limpaFormularioDoJSF();
	}
	
	
	
	public void setGerentes(List<Gerente> gerentes) {
		this.gerentes = gerentes;
	}
	public Gerente getGerente() {
		return gerente;
	}
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	
	
	private void limpaFormularioDoJSF() {
		this.gerente = new Gerente();
	}

	
	
	
	
	
}
