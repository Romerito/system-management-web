package web;

import java.util.List;

import javax.faces.bean.*;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import conta.Conta;
import conta.ContaRN;
import usuario.Usuario;
import usuario.UsuarioRN;

@ManagedBean(name="contextoBean")
@SessionScoped
public class ContextoBean {
	 
	private Usuario usuarioLogado = null;
	private Conta contaAtiva = null;

	public void setContaAtiva(Conta contaAtiva) {
		this.contaAtiva = contaAtiva;
	}
	public Usuario getUsuarioLogado(){
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();
		
		if (usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())){
			if(login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				this.usuarioLogado = usuarioRN.buscarPorLogin(login);
				this.contaAtiva = null;
			}
		}
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuario){
		this.usuarioLogado = usuario;
	}
	
	public Conta getContaAtiva(){
		if (this.contaAtiva == null){
			Usuario usuario = this.getUsuarioLogado();
			ContaRN contaRN = new ContaRN();
			this.contaAtiva = contaRN.buscarFavorita(usuario);
			
			if (this.contaAtiva == null){
				List<Conta> contas = contaRN.listar(usuario);
				
				if (contas != null){
					for (Conta conta : contas){
						this.contaAtiva = conta;
						break;
					}
				}
			}
		}
		return this.contaAtiva;
	}
	
	public void setContaAtiva(ValueChangeEvent event){
		Integer conta = (Integer) event.getNewValue();
		ContaRN contaRN = new ContaRN();
		this.contaAtiva = contaRN.carregar(conta);
	}

}

