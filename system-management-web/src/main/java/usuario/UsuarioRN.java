package usuario;

import java.util.List;
import util.DAOFactory;
public class UsuarioRN{
	private UsuarioDAO usuarioDAO;
	
	public UsuarioRN(){
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if(codigo == null || codigo == 0){
			usuario.getPermissao().add("ROLE_USUARIO");
			this.usuarioDAO.salvar(usuario);
		}else{
			this.usuarioDAO.atualizar(usuario);
		}

	}
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
		
	}
	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}
	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}

}
