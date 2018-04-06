package cliente;

import java.util.List;

import org.hibernate.Session;

public class ClienteDAOHibernate implements ClienteDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Cliente cliente) {
		this.session.save(cliente);

	}

	@Override
	public void atualizar(Cliente cliente) {
		this.session.update(cliente);
	}

	@Override
	public void excluir(Cliente cliente) {
		this.session.delete(cliente);

	}

	@Override
	public Cliente carregar(Integer codigo) {
		return (Cliente) this.session.get(Cliente.class, codigo);
	}

	@Override
	public List<Cliente> list() {
		return this.session.createCriteria(Cliente.class).list();
	}

}
