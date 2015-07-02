package br.com.lhs.jee7.jsf.web.mb;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lhs.jee7.jsf.dao.UsuarioDAO;
import br.com.lhs.jee7.jsf.model.Usuario;
import br.com.lhs.jee7.jsf.qualifiers.MemoriaImpl;
import br.com.lhs.jee7.jsf.web.events.EventoUsuario;

@Named
@SessionScoped
public class RepositorioUsuarios extends BaseManagedBean {

	/**
	 *
	 */
	private static final long serialVersionUID = 5734704397310586240L;
	private static final Logger logger = Logger.getLogger(RepositorioUsuarios.class.getName());

	@Inject
	@MemoriaImpl
	UsuarioDAO usuarioDAO;

	private List<Usuario> usuarios;

	@Override
	protected void postConstruct() {
		super.postConstruct();
		carregarUsuarios();
	}

	private void carregarUsuarios() {
		usuarios = usuarioDAO.listar();
	}

	@SuppressWarnings("unused")
	private void eventoAtualizarUsuarios(@Observes EventoUsuario evento) {
		carregarUsuarios();
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

	@Override
	protected String getNomeClasse() {
		return getClass().getSimpleName();
	}

}
