package br.com.lhs.jee7.jsf.web.mb.usuario;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lhs.jee7.jsf.dao.UsuarioDAO;
import br.com.lhs.jee7.jsf.model.Usuario;
import br.com.lhs.jee7.jsf.qualifiers.MemoriaImpl;
import br.com.lhs.jee7.jsf.web.mb.BaseManagedBean;

@RequestScoped
public class UsuariosProducer extends BaseManagedBean {

	/**
	 *
	 */
	private static final long serialVersionUID = 5734704397310586240L;

	@Inject
	Logger logger;

	@Inject
	@MemoriaImpl
	UsuarioDAO usuarioDAO;

	@Inject
	FacesContext facesContext;

	private List<Usuario> usuarios;

	// @Produces
	// @Named
	// String usuarioIdParam;

	@Override
	@PostConstruct
	protected void postConstruct() {
		super.postConstruct();
		carregarUsuarios();
	}

	private void carregarUsuarios() {
		logger.info("carregarUsuarios() on phaseId: " + facesContext.getCurrentPhaseId() + "\n");
		usuarios = usuarioDAO.listar();
	}

	@Produces
	@Named
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
