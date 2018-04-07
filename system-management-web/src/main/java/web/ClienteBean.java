package web;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import cliente.Cliente;
import cliente.ClienteRN;

@ManagedBean(name = "clienteBean")
@RequestScoped
public class ClienteBean {
	
	private Cliente cliente = new Cliente();
	private String destinoSalvar;
	private List<Cliente> lista;
	
	public String salvar(){
		this.destinoSalvar = "clienteSucesso";
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.salvar(this.cliente);
		return this.destinoSalvar;
		/*
		 * Tratar exceção com mesmo cpf;
		 * 
		 */
	}
	public String editar(){
		return "publico/cliente";
	}
	
	public String excluir(){
		ClienteRN clienteRN = new ClienteRN();
		clienteRN.excluir(cliente);
		this.lista = null;
		return null;
	}
	
	public List<Cliente> getLista(){
		if(this.lista == null){
			ClienteRN clienteRN = new ClienteRN();
			this.lista = clienteRN.list();
		}
		return lista;
	}
	
	public Cliente getClinte() {
		return cliente;
	}
	public void setClinte(Cliente clinte) {
		this.cliente = clinte;
	}
	public String getDestinoSalvar() {
		return destinoSalvar;
	}
	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}
	public List<Cliente> getListar() {
		return lista;
	}
	public void setListar(List<Cliente> listar) {
		this.lista = listar;
	}
	
	
	
	
	
	
	
}
