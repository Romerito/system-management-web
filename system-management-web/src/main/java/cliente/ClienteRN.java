package cliente;

import java.util.List;

import util.DAOFactory;

public class ClienteRN {
	
	private ClienteDAO clienteDAO;
	
	public ClienteRN(){
		this.clienteDAO = DAOFactory.criarClenteDAO();
	}

	public void salvar(Cliente cliente) {
		Integer codigo = cliente.getCodigo();
		if(codigo == null || codigo == 0){
			this.clienteDAO.salvar(cliente);
		}else{
			this.clienteDAO.atualizar(cliente);
		}
	}

	public void excluir(Cliente cliente) {
		this.clienteDAO.excluir(cliente);
		
	}

	public Cliente carregar(Integer codigo) {
		return this.clienteDAO.carregar(codigo);
	}

	public List<Cliente> list() {
		return this.clienteDAO.list();
	}

}
