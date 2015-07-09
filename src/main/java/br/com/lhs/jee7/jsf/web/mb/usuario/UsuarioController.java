package br.com.lhs.jee7.jsf.web.mb.usuario;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lhs.jee7.jsf.dao.UsuarioDAO;
import br.com.lhs.jee7.jsf.model.Usuario;
import br.com.lhs.jee7.jsf.qualifiers.MemoriaImpl;
import br.com.lhs.jee7.jsf.web.mb.BaseManagedBean;

@Model
public class UsuarioController extends BaseManagedBean {

	/**
	 *
	 */
	private static final long serialVersionUID = 1751005112070455136L;

	@Inject
	Logger logger;

	@Inject
	@MemoriaImpl
	UsuarioDAO usuarioDAO;

	@Produces
	@Named
	Usuario usuario;

	@PostConstruct
	@Override
	protected void postConstruct() {
		super.postConstruct();
		usuario = new Usuario();
	}

	public void carregar(String idStr) {
		usuario = usuarioDAO.recuperar(Long.valueOf(idStr));
	}

	public void salvar() {
		usuarioDAO.salvar(usuario);
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

}
