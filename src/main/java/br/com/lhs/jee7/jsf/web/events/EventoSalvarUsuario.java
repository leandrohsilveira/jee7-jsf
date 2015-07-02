package br.com.lhs.jee7.jsf.web.events;

import br.com.lhs.jee7.jsf.model.Usuario;

public class EventoSalvarUsuario extends EventoUsuario {

	/**
	 *
	 */
	private static final long serialVersionUID = -4825060090037956222L;
	private Usuario usuario;

	public EventoSalvarUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

}
