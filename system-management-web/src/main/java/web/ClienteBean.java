package web;

import java.util.List;

import cliente.Cliente;

public class ClienteBean {
	
	private Cliente clinte = new Cliente();
	private String destinoSalvar;
	private List<Cliente> listar;
	
	
	
	public Cliente getClinte() {
		return clinte;
	}
	public void setClinte(Cliente clinte) {
		this.clinte = clinte;
	}
	public String getDestinoSalvar() {
		return destinoSalvar;
	}
	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}
	public List<Cliente> getListar() {
		return listar;
	}
	public void setListar(List<Cliente> listar) {
		this.listar = listar;
	}
	
	
	
	
	
	
	
}
