package br.com.lhs.jee7.jsf.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Singleton;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import br.com.lhs.jee7.jsf.model.Usuario;
import br.com.lhs.jee7.jsf.qualifiers.MemoriaImpl;
import br.com.lhs.jee7.jsf.web.events.EventoSalvarUsuario;
import br.com.lhs.jee7.jsf.web.events.EventoUsuario;

@MemoriaImpl
@Singleton
public class UsuarioImplMemDAO implements UsuarioDAO {

	/**
	 *
	 */
	private static final long serialVersionUID = 1791923905996374811L;
	private final Map<Long, Usuario> usuarios = new LinkedHashMap<Long, Usuario>();
	private Long cont = 1l;

	@Inject
	Event<EventoUsuario> eventoAtualizarRepositorioUsuarios;

	@Override
	public synchronized void salvar(Usuario u) {
		if (u != null) {
			if (u.getId() == null) {
				u.setId(cont++);
			}
			usuarios.put(u.getId(), u);
			eventoAtualizarRepositorioUsuarios.fire(new EventoSalvarUsuario(u));
		}
	}

	@Override
	public synchronized List<Usuario> listar() {
		List<Usuario> saida = new ArrayList<>();
		usuarios.forEach((i, u) -> saida.add(u));
		// return usuarios.entrySet().stream().map(e -> e.getValue());
		return saida;
	}

	@Override
	public synchronized Usuario recuperar(Long id) {
		return usuarios.get(id);
	}

}
