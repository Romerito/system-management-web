package web;

import java.util.List;

import javax.faces.bean.*;

import conta.Conta;
import util.ContextoUtil;

@ManagedBean(name = "contaBean")
@RequestScoped
public class ContaBean {
	
	private Conta selecionada = new Conta();
	private List<Conta> lista = null;
	
	public void salvar(){
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
	}
	
	public void editar(){
		
	}
	
	public void excluir(){
		
	}
	
	public void tornarFavorita(){
		
	}

	public Conta getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Conta selecionada) {
		this.selecionada = selecionada;
	}

	public List<Conta> getLista() {
		return lista;
	}

	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}
	
}
