package usuario;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOHibernate implements UsuarioDAO {
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);

	}
	public void atualizar(Usuario usuario) {
		if(usuario.getPermissao() == null || usuario.getPermissao().size() == 0){
			Usuario usuarioPermissao = this.carregar(usuario.getCodigo());
			usuario.setPermissao(usuarioPermissao.getPermissao());
			/*
			 * THE METHOD .evict CLEAN OF CONTEXT PERSISTENCE THIS OBJECT.
			 */
			this.session.evict(usuarioPermissao);
		}
		this.session.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
		
	}

	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscarPorLogin(String email) {
		String hql = "select u from Usuario u where u.email = :email";
		Query consulta = this.session.createQuery(hql);
		consulta.setString("email", email);
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

}

