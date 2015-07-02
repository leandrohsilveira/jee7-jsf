package br.com.lhs.jee7.jsf.web.mb;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;

import br.com.lhs.jee7.jsf.dao.UsuarioDAO;
import br.com.lhs.jee7.jsf.model.Usuario;
import br.com.lhs.jee7.jsf.qualifiers.MemoriaImpl;

@Named
@RequestScoped
public class FormularioUsuario extends BaseManagedBean {

	/**
	 *
	 */
	private static final long serialVersionUID = 1751005112070455136L;
	private static final Logger logger = Logger.getLogger(FormularioUsuario.class.getName());

	@Inject
	@MemoriaImpl
	UsuarioDAO usuarioDAO;

	private String id;

	@NotNull
	private String nome;

	@NotNull
	private String email;

	public void carregar(String idStr) {
		Usuario usuario = usuarioDAO.recuperar(Long.valueOf(idStr));
		// Usuario usuario = new Usuario(1l, "Leandro", "silveira@bry.com.br");
		id = usuario.getId().toString();
		nome = usuario.getNome();
		email = usuario.getEmail();
	}

	@Override
	protected String getNomeClasse() {
		return getClass().getSimpleName();
	}

	public void salvar() {
		Long id = StringUtils.isNotBlank(this.id) ? Long.valueOf(this.id) : null;
		usuarioDAO.salvar(new Usuario(id, nome, email));
	}

	@Override
	protected Logger getLogger() {
		return logger;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
